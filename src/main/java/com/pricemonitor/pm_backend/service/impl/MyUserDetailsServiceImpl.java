package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.action.MyUserDetails;
import com.pricemonitor.pm_backend.bean.pojo.User;
import com.pricemonitor.pm_backend.bean.pojo.UserExample;
import com.pricemonitor.pm_backend.bean.pojo.UserExample.Criteria;
import com.pricemonitor.pm_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 覆盖loadUserByUsername：根据email查询用户是否存在
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> list = userMapper.selectByExample(example);
        if (list.size() == 0) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        }
        User user = list.get(0);
        return this.create(user);
    }

    /**
     * 将User转为MyUserDetails类，将属性传递
     * @param user
     * @return
     */
    private MyUserDetails create(User user) {
        return new MyUserDetails(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                user.getIsActive(),
                user.getIsSuperuser()
        );
    }
}
