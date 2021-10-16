package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.Class;
import com.pricemonitor.pm_backend.bean.pojo.ClassExample;
import com.pricemonitor.pm_backend.mapper.ClassMapper;
import com.pricemonitor.pm_backend.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "class")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Cacheable
    @Override
    public int count() {
        ClassExample classExample = new ClassExample();
        return classMapper.countByExample(classExample);
    }

    @Cacheable
    @Override
    public List<Class> list(int startRow, int pageSize) {
        ClassExample classExample = new ClassExample();
        classExample.setPageSize(pageSize);
        classExample.setStartRow(startRow);
        return classMapper.selectByExample(classExample);
    }

    @Cacheable
    @Override
    public List<Class> findByClassTopId(int classId) {
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andClassIdEqualTo(classId);
        return classMapper.selectByExample(classExample);
    }
}