package com.pricemonitor.pm_backend.service;

import com.pricemonitor.pm_backend.bean.pojo.JdItemHistory;

import java.util.List;

public interface JdItemHistoryService {
    List<JdItemHistory> findHistoryPriceByItemId(Long itemId);
}
