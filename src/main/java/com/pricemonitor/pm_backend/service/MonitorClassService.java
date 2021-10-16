package com.pricemonitor.pm_backend.service;


import com.pricemonitor.pm_backend.bean.pojo.MonitorClass;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MonitorClassService {

    @Transactional
    void insert(int classId, String expectedDiscount, int userId);

    boolean checkByUserIdAndClassId(int classId, int userId);

    int count(int userId);

    List<MonitorClass> list(int startRow, int pageSize, int userId);

    @Transactional
    boolean delete(int classId, int userId);

}