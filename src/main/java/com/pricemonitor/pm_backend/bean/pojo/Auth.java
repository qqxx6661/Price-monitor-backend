package com.pricemonitor.pm_backend.bean.pojo;

import java.io.Serializable;
import java.util.Date;

public class Auth implements Serializable {
    private Integer id;

    private Integer userId;

    private String appType;

    private String appUserId;

    private String accessToken;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Auth(Integer id, Integer userId, String appType, String appUserId, String accessToken, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.userId = userId;
        this.appType = appType;
        this.appUserId = appUserId;
        this.accessToken = accessToken;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Auth() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId == null ? null : appUserId.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", appType=").append(appType);
        sb.append(", appUserId=").append(appUserId);
        sb.append(", accessToken=").append(accessToken);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}