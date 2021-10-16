package com.pricemonitor.pm_backend.bean.action.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yzd
 */
public class MonitorItemRequest {

    @ApiModelProperty(value="数据库自增id（插入新商品时为空）")
    private Integer id;

    @ApiModelProperty(value="用户期望价格")
    private String userPrice;

    @ApiModelProperty(value="商品id")
    private Long itemId;

    @ApiModelProperty(value="是否开启监控")
    private Boolean isAlert;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(String userPrice) {
        this.userPrice = userPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Boolean getAlert() {
        return isAlert;
    }

    public void setAlert(Boolean alert) {
        isAlert = alert;
    }
}