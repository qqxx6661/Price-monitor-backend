package com.pricemonitor.pm_backend.service;

import com.pricemonitor.pm_backend.bean.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    void register(String email, String name, String phone, String password, String serverJiang);

    boolean checkRegisterByEmail(String email);

    boolean checkRegisterByPhone(String Phone);

    boolean checkUserByPassword(String password, int id);

    @Transactional
    void updatePassword(String password, int id);

    List<User> findUserByEmail(String email);
}