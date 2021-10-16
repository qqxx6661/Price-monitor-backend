package com.pricemonitor.pm_backend.bean.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private Boolean isActive;

    private Boolean isSuperuser;

    private Boolean isOlduser;

    private Date gmtCreate;

    private Date gmtModified;

    private String serverJiang;

    private static final long serialVersionUID = 1L;

    public User(Integer id, String name, String email, String phone, String password, Boolean isActive, Boolean isSuperuser, Boolean isOlduser, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isActive = isActive;
        this.isSuperuser = isSuperuser;
        this.isOlduser = isOlduser;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Boolean getIsOlduser() {
        return isOlduser;
    }

    public void setIsOlduser(Boolean isOlduser) {
        this.isOlduser = isOlduser;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getServerJiang() {
        return serverJiang;
    }

    public void setServerJiang(String serverJiang) {
        this.serverJiang = serverJiang;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", isSuperuser=" + isSuperuser +
                ", isOlduser=" + isOlduser +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", serverJiang='" + serverJiang + '\'' +
                '}';
    }
}