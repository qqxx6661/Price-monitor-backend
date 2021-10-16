package com.pricemonitor.pm_backend.bean.action.request;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author yzd
 */
public class ResetRequest {

    @ApiModelProperty(value="token")
    private String token;

    @ApiModelProperty(value="密码")
    private String password;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}