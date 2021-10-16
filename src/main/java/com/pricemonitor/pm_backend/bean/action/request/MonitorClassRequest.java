package com.pricemonitor.pm_backend.bean.action.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yzd
 */
public class MonitorClassRequest {

    @ApiModelProperty(value="品类id")
    private Integer classId;

    @ApiModelProperty(value="期望折扣价格(小于1大于0)")
    private String expectedDiscount;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getExpectedDiscount() {
        return expectedDiscount;
    }

    public void setExpectedDiscount(String expectedDiscount) {
        this.expectedDiscount = expectedDiscount;
    }
}