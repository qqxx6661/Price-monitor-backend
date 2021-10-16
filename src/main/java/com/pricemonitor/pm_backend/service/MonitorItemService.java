package com.pricemonitor.pm_backend.service;


import com.pricemonitor.pm_backend.bean.pojo.MonitorItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MonitorItemService {

    List<MonitorItem> findByUserIdAndItemId(Long itemId, int userId);

    @Transactional
    void insert(Long itemId, String userPrice, boolean isAlert, int userId);

    int count(int userId);

    List<MonitorItem> list(int startRow, int pageSize, int userId);

    @Transactional
    void delete(int id, int userId);

    @Transactional
    void update(int id, Long itemId, String userPrice, boolean isAlert, int userId);

    /**
     * 更新days以前的监控商品状态is_alert为0
     * @param daysBefore
     * @return 影响行数
     */
    int updateIsAlertByGmtCreate(int daysBefore);

    /**
     * 获取所有待爬商品
     * @return
     */
    List<MonitorItem> getByIsAlert();

}
