package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.action.request.UserRequest;
import com.pricemonitor.pm_backend.service.UserService;
import com.pricemonitor.pm_backend.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * JWT测试接口: 返回用户ID
     * @return
     */
    @ApiOperation(value="测试接口: 返回用户ID", notes="测试接口: 返回用户ID")
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        return String.valueOf(userId);
    }


    /**
     * 用户注册
     * @param userRequest
     * @return
     */
    @ApiOperation(value="用户注册", notes="用户注册")
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseData<String> register(@RequestBody UserRequest userRequest){
        ResponseData<String> responseData = new ResponseData<>();
        try {
            userService.register(userRequest.getEmail(), userRequest.getName(),
                    userRequest.getPhone(), userRequest.getPassword(), userRequest.getServerJiang());
            responseData.jsonFill(1, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    /**
     * 查询Email是否存在
     * @param email
     * @return
     */
    @ApiOperation(value="查询用户Email", notes="查询用户Email")
    @RequestMapping(value = "/checkRegisterByEmail", method = {RequestMethod.GET})
    public ResponseData<String> checkRegisterByEmail(@ApiParam("邮箱") @RequestParam("email") String email){
        ResponseData<String> responseData = new ResponseData<>();
        try {
            boolean hasEmail = userService.checkRegisterByEmail(email);
            if (hasEmail) {
                responseData.jsonFill(2, "该邮箱已被使用", null);
            } else {
                responseData.jsonFill(1, null, "该邮箱可以注册");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    /**
     * 查询用户手机号是否存在
     * @param phone
     * @return
     */
    @ApiOperation(value="查询用户手机号", notes="查询用户手机号")
    @RequestMapping(value = "/checkRegisterByPhone", method = {RequestMethod.GET})
    public ResponseData<String> checkRegisterByPhone(@ApiParam("手机号") @RequestParam("phone") String phone){
        ResponseData<String> responseData = new ResponseData<>();
        try {
            boolean hasPhone = userService.checkRegisterByPhone(phone);
            if (hasPhone) {
                responseData.jsonFill(2, "该手机号已被使用", null);
            } else {
                responseData.jsonFill(1, null, "该手机号可以注册");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }


    /**
     * 修改用户密码
     * @param userRequest
     * @param request
     * @return
     */
    @ApiOperation(value="修改用户密码", notes="修改用户密码")
    @RequestMapping(value = "/updatePassword", method = {RequestMethod.POST})
    public ResponseData<String> updatePassword(@RequestBody UserRequest userRequest, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<String> responseData = new ResponseData<>();
        try {
            if (userService.checkUserByPassword(userRequest.getOldPassword(), userId)) {
                userService.updatePassword(userRequest.getPassword(), userId);
                responseData.jsonFill(1, null, null);
            } else {
                responseData.jsonFill(2, "旧密码错误", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }
}
