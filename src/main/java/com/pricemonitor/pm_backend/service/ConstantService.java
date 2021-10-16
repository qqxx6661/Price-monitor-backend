package com.pricemonitor.pm_backend.service;

import com.pricemonitor.pm_backend.bean.pojo.Constant;

import java.util.List;

public interface ConstantService {
    List<Constant> alertMessage();
    List<Constant> noteMessage();
    List<Constant> banner();
}