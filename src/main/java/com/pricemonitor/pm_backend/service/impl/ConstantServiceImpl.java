package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.Constant;
import com.pricemonitor.pm_backend.bean.pojo.ConstantExample;
import com.pricemonitor.pm_backend.mapper.ConstantMapper;
import com.pricemonitor.pm_backend.service.ConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "constant")
public class ConstantServiceImpl implements ConstantService {

    @Autowired
    private ConstantMapper constantMapper;

    @Cacheable
    @Override
    public List<Constant> alertMessage() {
        ConstantExample constantExample = new ConstantExample();
        ConstantExample.Criteria criteria = constantExample.createCriteria();
        criteria.andTypeEqualTo("alert");
        return constantMapper.selectByExample(constantExample);
    }

    @Cacheable
    @Override
    public List<Constant> noteMessage() {
        ConstantExample constantExample = new ConstantExample();
        ConstantExample.Criteria criteria = constantExample.createCriteria();
        criteria.andTypeEqualTo("note");
        return constantMapper.selectByExample(constantExample);
    }

    @Cacheable
    @Override
    public List<Constant> banner() {
        ConstantExample constantExample = new ConstantExample();
        ConstantExample.Criteria criteria = constantExample.createCriteria();
        criteria.andTypeEqualTo("banner");
        return constantMapper.selectByExample(constantExample);
    }
}