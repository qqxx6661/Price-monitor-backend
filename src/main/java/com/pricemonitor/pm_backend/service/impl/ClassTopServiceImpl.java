package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.ClassTop;
import com.pricemonitor.pm_backend.bean.pojo.ClassTopExample;
import com.pricemonitor.pm_backend.mapper.ClassTopMapper;
import com.pricemonitor.pm_backend.service.ClassTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "classTop")
public class ClassTopServiceImpl implements ClassTopService {

    @Autowired
    private ClassTopMapper classTopMapper;

    @Cacheable
    @Override
    public List<ClassTop> list() {
        ClassTopExample classTopExample = new ClassTopExample();
        return classTopMapper.selectByExample(classTopExample);
    }
}