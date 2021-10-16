package com.pricemonitor.pm_backend.service;

import com.pricemonitor.pm_backend.bean.pojo.JdItem;

import java.util.List;

public interface JdItemService{
    int count(Integer classTopId, String sort);
    List<JdItem> list(int startRow, int pageSize, Integer classTopId, String sort);
}