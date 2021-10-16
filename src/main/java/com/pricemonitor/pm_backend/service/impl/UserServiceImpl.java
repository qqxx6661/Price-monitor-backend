package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.UserExample;
import com.pricemonitor.pm_backend.mapper.UserMapper;
import com.pricemonitor.pm_backend.bean.pojo.User;
import com.pricemonitor.pm_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 用户注册：默认活动账号，非管理员帐号
     * @param email
     * @param name
     * @param phone
     * @param password
     * @param serverJiang
     */
    @Override
    public void register(String email, String name, String phone, String password, String serverJiang) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        user.setIsActive(true);
        user.setIsSuperuser(false);
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setServerJiang(serverJiang);
        userMapper.insertSelective(user);
    }

    /**
     * 查询Email是否存在
     * @param email
     * @return
     */
    @Override
    public boolean checkRegisterByEmail(String email) {
        if (email != null) {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andEmailEqualTo(email);
            int count = userMapper.countByExample(example);
            return count == 1;
        }
        return false;
    }

    /**
     * 查询Phone是否存在
     * @param Phone
     * @return
     */
    @Override
    public boolean checkRegisterByPhone(String Phone) {
        if (Phone != null) {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(Phone);
            int count  = userMapper.countByExample(example);
            return count == 1;
        }
        return false;
    }

    /**
     * 检查用户旧密码
     * @param password
     * @param id
     * @return
     */
    @Override
    public boolean checkUserByPassword(String password, int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    /**
     * 更新用户密码
     * @param password
     * @param id
     */
    @Override
    public void updatePassword(String password, int id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        User user = new User();
        user.setGmtModified(new Date());
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userMapper.updateByExampleSelective(user, example);
    }

    /**
     * 通过邮箱地址查找用户
     * @param email
     * @return
     */
    @Override
    public List<User> findUserByEmail(String email){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(userExample);
    }
}