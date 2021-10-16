package com.pricemonitor.pm_backend.service.impl;

import com.pricemonitor.pm_backend.bean.pojo.MonitorItem;
import com.pricemonitor.pm_backend.bean.pojo.MonitorItemExample;
import com.pricemonitor.pm_backend.mapper.MonitorItemMapper;
import com.pricemonitor.pm_backend.service.MonitorItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MonitorItemServiceImpl implements MonitorItemService {

    @Autowired
    private MonitorItemMapper monitorItemMapper;

    @Value("${time.check.update.jd.item}")
    private String checkTime;

    /**
     * 查询单个商品监控详情
     * @param itemId
     * @param userId
     * @return
     */
    @Override
    public List<MonitorItem> findByUserIdAndItemId(Long itemId, int userId) {
        MonitorItemExample monitorItemExample = new MonitorItemExample();
        MonitorItemExample.Criteria criteria = monitorItemExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andItemIdEqualTo(itemId);
        return monitorItemMapper.selectByExample(monitorItemExample);
    }

    /**
     * 插入监控商品
     * @param itemId
     * @param userPrice
     * @param isAlert
     * @param userId
     */
    @Override
    public void insert(Long itemId, String userPrice, boolean isAlert, int userId) {
        MonitorItem monitorItem = new MonitorItem();
        monitorItem.setItemId(itemId);
        monitorItem.setUserPrice(userPrice);
        monitorItem.setUserId(userId);
        monitorItem.setIsAlert(isAlert);
        monitorItem.setGmtCreate(new Date());
        monitorItem.setGmtModified(new Date());
        monitorItemMapper.insertSelective(monitorItem);
    }

    /**
     * 统计用户监控商品总数
     * @param userId
     * @return
     */
    @Override
    public int count(int userId) {
        MonitorItemExample monitorItemExample = new MonitorItemExample();
        MonitorItemExample.Criteria criteria = monitorItemExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return monitorItemMapper.countByExample(monitorItemExample);
    }

    /**
     * 分页查询监控商品
     * @param startRow
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    public List<MonitorItem> list(int startRow, int pageSize, int userId) {
        MonitorItemExample monitorItemExample = new MonitorItemExample();
        MonitorItemExample.Criteria criteria = monitorItemExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        monitorItemExample.setPageSize(pageSize);
        monitorItemExample.setStartRow(startRow);
        return monitorItemMapper.selectByExample(monitorItemExample);
    }

    /**
     * 删除监控商品
     * @param id
     * @param userId
     */
    @Override
    public void delete(int id, int userId) {
        MonitorItemExample monitorItemExample = new MonitorItemExample();
        MonitorItemExample.Criteria criteria = monitorItemExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIdEqualTo(id);
        monitorItemMapper.deleteByExample(monitorItemExample);
    }

    /**
     * 更新监控商品
     * @param id
     * @param itemId
     * @param userPrice
     * @param isAlert
     * @param userId
     */
    @Override
    public void update(int id, Long itemId, String userPrice, boolean isAlert, int userId) {
        MonitorItem monitorItem = new MonitorItem();
        monitorItem.setId(id);
        monitorItem.setItemId(itemId);
        monitorItem.setUserPrice(userPrice);
        monitorItem.setUserId(userId);
        monitorItem.setIsAlert(isAlert);
        monitorItem.setGmtModified(new Date());
        monitorItemMapper.updateByPrimaryKeySelective(monitorItem);
    }

    @Override
    public int updateIsAlertByGmtCreate(int daysBefore) {
        MonitorItemExample example = new MonitorItemExample();
        MonitorItemExample.Criteria criteria = example.createCriteria();
        criteria.andGmtCreateLessThanOrEqualTo(getDateByDaysBefore(daysBefore));
        MonitorItem monitorItem = new MonitorItem();
        monitorItem.setIsAlert(false);
        return monitorItemMapper.updateByExampleSelective(monitorItem, example);
    }

    @Override
    public List<MonitorItem> getByIsAlert() {
        MonitorItemExample example = new MonitorItemExample();
        MonitorItemExample.Criteria criteria = example.createCriteria();
        criteria.andIsAlertEqualTo(true);
        criteria.andGmtModifiedLessThanOrEqualTo(getTimeByMinutesBefore(Integer.parseInt(checkTime)));
        return monitorItemMapper.selectByExample(example);
    }

    /**
     * 获取前n天的日期
     * @param daysBefore
     * @return
     */
    private static Date getDateByDaysBefore(int daysBefore) {
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DATE, -daysBefore);
        return calendar.getTime();
    }

    /**
     * 获取前n分钟的时间
     * @param minutesBefore
     * @return
     */
    private static Date getTimeByMinutesBefore(int minutesBefore) {
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MINUTE, -minutesBefore);
        return calendar.getTime();
    }
}
