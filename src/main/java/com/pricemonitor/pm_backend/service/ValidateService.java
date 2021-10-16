package com.pricemonitor.pm_backend.service;

import com.pricemonitor.pm_backend.bean.pojo.User;
import com.pricemonitor.pm_backend.bean.pojo.Validate;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public interface ValidateService {
    void sendPasswordResetEmail(SimpleMailMessage email);
    int insertNewResetRecord(Validate validate, User users, String token);
    List<Validate> findUserByResetToken(String resetToken);
    boolean validateLimitation(String email, long requestPerDay, long interval, String token);
    boolean sendValidateLimitation(String email, long requestPerDay, long interval);
}
