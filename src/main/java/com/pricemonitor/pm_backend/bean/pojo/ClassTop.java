package com.pricemonitor.pm_backend.bean.pojo;

import java.io.Serializable;
import java.util.Date;

public class ClassTop implements Serializable {
    private Integer classTopId;

    private String classTopName;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public ClassTop(Integer classTopId, String classTopName, Date gmtCreate, Date gmtModified) {
        this.classTopId = classTopId;
        this.classTopName = classTopName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public ClassTop() {
        super();
    }

    public Integer getClassTopId() {
        return classTopId;
    }

    public void setClassTopId(Integer classTopId) {
        this.classTopId = classTopId;
    }

    public String getClassTopName() {
        return classTopName;
    }

    public void setClassTopName(String classTopName) {
        this.classTopName = classTopName == null ? null : classTopName.trim();
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
        sb.append(", classTopId=").append(classTopId);
        sb.append(", classTopName=").append(classTopName);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}