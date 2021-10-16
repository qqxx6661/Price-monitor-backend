package com.pricemonitor.pm_backend.bean.action.request;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author yzd
 */
public class UserRequest {

    @ApiModelProperty(value="用户昵称（可为空）")
    private String name;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="手机号（可为空）")
    private String phone;

    @ApiModelProperty(value="旧密码（更新密码用，可为空）")
    private String oldPassword;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="server酱")
    private String serverJiang;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getServerJiang() {
        return serverJiang;
    }

    public void setServerJiang(String serverJiang) {
        this.serverJiang = serverJiang;
    }
}