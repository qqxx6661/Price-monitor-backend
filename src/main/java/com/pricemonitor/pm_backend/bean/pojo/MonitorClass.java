package com.pricemonitor.pm_backend.bean.pojo;

import java.io.Serializable;
import java.util.Date;

public class MonitorClass implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer classId;

    private String expectedDiscount;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public MonitorClass(Integer id, Integer userId, Integer classId, String expectedDiscount, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.userId = userId;
        this.classId = classId;
        this.expectedDiscount = expectedDiscount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public MonitorClass() {
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
        this.expectedDiscount = expectedDiscount == null ? null : expectedDiscount.trim();
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
        sb.append(", classId=").append(classId);
        sb.append(", expectedDiscount=").append(expectedDiscount);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}