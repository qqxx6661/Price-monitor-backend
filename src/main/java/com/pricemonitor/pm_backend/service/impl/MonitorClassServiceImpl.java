package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.MonitorClass;
import com.pricemonitor.pm_backend.bean.pojo.MonitorClassExample;
import com.pricemonitor.pm_backend.mapper.MonitorClassMapper;
import com.pricemonitor.pm_backend.service.MonitorClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MonitorClassServiceImpl implements MonitorClassService {
    @Autowired
    private MonitorClassMapper monitorClassMapper;

    /**
     * 添加品类监控
     * @param classId
     */
    @Override
    public void insert(int classId, String expectedDiscount, int userId) {
        MonitorClass monitorClass = new MonitorClass();
        monitorClass.setUserId(userId);
        monitorClass.setExpectedDiscount(expectedDiscount);
        monitorClass.setClassId(classId);
        monitorClass.setGmtCreate(new Date());
        monitorClass.setGmtModified(new Date());
        monitorClassMapper.insertSelective(monitorClass);
    }

    /**
     * 根据ClassId查询用户记录
     * @param classId
     * @param userId
     * @return
     */
    @Override
    public boolean checkByUserIdAndClassId(int classId, int userId) {
        MonitorClassExample monitorClassExample = new MonitorClassExample();
        MonitorClassExample.Criteria criteria = monitorClassExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andClassIdEqualTo(classId);
        int count = monitorClassMapper.countByExample(monitorClassExample);
        return count == 1;
    }

    /**
     * 返回监控总数
     * @param userId
     * @return
     */
    @Override
    public int count(int userId) {
        MonitorClassExample monitorClassExample = new MonitorClassExample();
        MonitorClassExample.Criteria criteria = monitorClassExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return monitorClassMapper.countByExample(monitorClassExample);
    }

    /**
     * 查询品类监控
     * @param startRow
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    public List<MonitorClass> list(int startRow, int pageSize, int userId) {
        MonitorClassExample monitorClassExample = new MonitorClassExample();
        MonitorClassExample.Criteria criteria = monitorClassExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        monitorClassExample.setPageSize(pageSize);
        monitorClassExample.setStartRow(startRow);
        return monitorClassMapper.selectByExample(monitorClassExample);
    }

    @Override
    public boolean delete(int id, int userId) {
        MonitorClassExample monitorClassExample = new MonitorClassExample();
        MonitorClassExample.Criteria criteria = monitorClassExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIdEqualTo(id);
        int count = monitorClassMapper.deleteByExample(monitorClassExample);
        return count == 1;
    }
}