package com.pricemonitor.pm_backend.bean.action;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yzd
 */
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 7821516218534470005L;
    @ApiModelProperty(value="返回状态(1=正常，2=错误，3=未登录，4=自定义错误（直接抛出errorMes）)")
    private int status;
    @ApiModelProperty(value="返回类型")
    private String type;
    @ApiModelProperty(value="返回数据")
    private T obj;
    @ApiModelProperty(value="错误返回说明")
    private String errorMes;

    public ResponseData() {
        type = "json";
        errorMes = "";
        status = 1;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getErrorMes() {
        return errorMes;
    }

    public void setErrorMes(String errorMes) {
        this.errorMes = errorMes;
    }

    public void jsonFill(int status, String errorMsg, T obj) {
        this.status = status;
        this.errorMes = errorMsg;
        this.obj = obj;
    }

}