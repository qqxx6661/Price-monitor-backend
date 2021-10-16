package com.pricemonitor.pm_backend.service;


import com.pricemonitor.pm_backend.bean.pojo.Class;

import java.util.List;

public interface ClassService {
    int count();
    List<Class> list(int startRow, int pageSize);
    List<Class> findByClassTopId(int classId);
}