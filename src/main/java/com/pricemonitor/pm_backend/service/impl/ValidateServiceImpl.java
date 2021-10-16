package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.User;
import com.pricemonitor.pm_backend.bean.pojo.Validate;
import com.pricemonitor.pm_backend.bean.pojo.ValidateExample;
import com.pricemonitor.pm_backend.mapper.ValidateMapper;
import com.pricemonitor.pm_backend.service.ValidateService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ValidateMapper validateMapper;

    /**
     * 发送邮件：@Async进行异步调用发送邮件接口
     * @param email
     */
    @Override
    @Async
    public void sendPasswordResetEmail(SimpleMailMessage email){
        javaMailSender.send(email);
    }

    /**
     * 在pm_validate表中插入一条validate记录，userid，email属性来自pm_user表，token由UUID生成
     * @param validate
     * @param users
     * @param token
     * @return
     */
    @Override
    public int insertNewResetRecord(Validate validate, User users, String token){
        validate.setUserId(users.getId());
        validate.setEmail(users.getEmail());
        validate.setResetToken(token);
        validate.setType("passwordReset");
        validate.setGmtCreate(new Date());
        validate.setGmtModified(new Date());
        return validateMapper.insert(validate);
    }

    /**
     * pm_validate表中，通过token查找重置申请记录
     * @param token
     * @return
     */
    @Override
    public List<Validate> findUserByResetToken(String token){
        ValidateExample validateExample = new ValidateExample();
        ValidateExample.Criteria criteria = validateExample.createCriteria();
        criteria.andResetTokenEqualTo(token);
        return validateMapper.selectByExample(validateExample);
    }

    /**
     * 验证是否发送重置邮件：每个email的重置密码每日请求上限为requestPerDay次，与上一次的请求时间间隔为interval分钟。
     * @param email
     * @param requestPerDay
     * @param interval
     * @return
     */
    @Override
    public boolean sendValidateLimitation(String email, long requestPerDay, long interval){
        ValidateExample validateExample = new ValidateExample();
        ValidateExample.Criteria criteria= validateExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<Validate> validates = validateMapper.selectByExample(validateExample);
        // 若查无记录，意味着第一次申请，直接放行
        if (validates.isEmpty()) {
            return true;
        }
        // 有记录，则判定是否频繁申请以及是否达到日均请求上线
        long countTodayValidation = validates.stream().filter(x->DateUtils.isSameDay(x.getGmtModified(), new Date())).count();
        Optional validate = validates.stream().map(Validate::getGmtModified).max(Date::compareTo);
        Date dateOfLastRequest = new Date();
        if (validate.isPresent()) {
            dateOfLastRequest = (Date) validate.get();
        }
        long intervalForLastRequest = new Date().getTime() - dateOfLastRequest.getTime();

        return countTodayValidation <= requestPerDay && intervalForLastRequest >= interval * 60 * 1000;
    }

    /**
     * 验证连接是否失效：链接有两种情况失效 1.超时 2.最近请求的一次链接自动覆盖之前的链接（待看代码）
     * @param email
     * @param requestPerDay
     * @param interval
     * @return
     */
    @Override
    public boolean validateLimitation(String email, long requestPerDay, long interval, String token){
        ValidateExample validateExample = new ValidateExample();
        ValidateExample.Criteria criteria= validateExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<Validate> validates = validateMapper.selectByExample(validateExample);
        // 有记录才会调用该函数，只需判断是否超时
        Optional validate = validates.stream().map(Validate::getGmtModified).max(Date::compareTo);
        Date dateOfLastRequest = new Date();
        if (validate.isPresent()) dateOfLastRequest = (Date) validate.get();
        long intervalForLastRequest = new Date().getTime() - dateOfLastRequest.getTime();

        Optional lastRequestToken = validates.stream().filter(x-> x.getResetToken().equals(token)).map(Validate::getGmtModified).findAny();
        Date dateOfLastRequestToken = new Date();
        if (lastRequestToken.isPresent()) {
            dateOfLastRequestToken = (Date) lastRequestToken.get();
        }
        return intervalForLastRequest <= interval * 60 * 1000 && dateOfLastRequest == dateOfLastRequestToken;
    }
}
