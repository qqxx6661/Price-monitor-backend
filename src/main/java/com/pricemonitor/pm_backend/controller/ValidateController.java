package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.action.request.ResetRequest;
import com.pricemonitor.pm_backend.bean.pojo.User;
import com.pricemonitor.pm_backend.bean.pojo.Validate;
import com.pricemonitor.pm_backend.service.UserService;
import com.pricemonitor.pm_backend.service.ValidateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;


/**
 * @author miaogd
 */
@RestController
@RequestMapping(value = "/validate")
public class ValidateController {

    @Autowired
    private ValidateService validateService;

    @Autowired
    private UserService userService;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送忘记密码邮件请求，每日申请次数不超过5次，每次申请间隔不低于1分钟
     * @param email
     * @param request
     * @return
     */
    @ApiOperation(value = "发送忘记密码邮件", notes = "发送忘记密码邮件")
    @RequestMapping(value = "/sendValidationEmail", method = {RequestMethod.GET})
    public ResponseData<String> sendValidationEmail(@ApiParam("邮箱地址") @RequestParam("email") String email,
                                               HttpServletRequest request){
        ResponseData<String> responseData = new ResponseData<>();
        List<User> users = userService.findUserByEmail(email);
        if (users == null){
            responseData.jsonFill(2, "该邮箱所属用户不存在", null);
        }else {
            if (validateService.sendValidateLimitation(email, 5,1)){
                // 若允许重置密码，则在pm_validate表中插入一行数据，带有token
                Validate validate = new Validate();
                validateService.insertNewResetRecord(validate, users.get(0), UUID.randomUUID().toString());
                // 设置邮件内容
                String appUrl = request.getScheme() + "://" + request.getServerName();
                SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
                passwordResetEmail.setFrom(from);
                passwordResetEmail.setTo(email);
                passwordResetEmail.setSubject("【电商价格监控】忘记密码");
                passwordResetEmail.setText("您正在申请重置密码，请点击此链接重置密码: \n" + appUrl + "/#/resetPassword?token=" + validate.getResetToken());
                validateService.sendPasswordResetEmail(passwordResetEmail);
                responseData.jsonFill(1, null, null);
            }else {
                responseData.jsonFill(2,"操作过于频繁，请稍后再试！",null);
            }
        }
        return responseData;
    }


    /**
     * 将url的token和数据库里的token匹配，成功后便可修改密码，token有效期为60分钟
     * @param resetRequest
     * @return
     */
    @ApiOperation(value = "重置密码", notes = "重置密码")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ResponseData<String> resetPassword(@RequestBody ResetRequest resetRequest){
        ResponseData<String> responseData = new ResponseData<>();
        // 通过token找到validate记录
        List<Validate> validates = validateService.findUserByResetToken(resetRequest.getToken());
        if (validates == null){
            responseData.jsonFill(2,"该重置请求不存在",null);
        }else {
            Validate validate = validates.get(0);
            if (validateService.validateLimitation(validate.getEmail(), Long.MAX_VALUE, 60, resetRequest.getToken())){
                Integer userId = validate.getUserId();
                userService.updatePassword(resetRequest.getPassword(), userId);
                responseData.jsonFill(1, null,null);
            }else {
                responseData.jsonFill(2,"该链接失效",null);
            }
        }
        return responseData;
    }
}
