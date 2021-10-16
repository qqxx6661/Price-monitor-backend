package com.pricemonitor.pm_backend.bean.action;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 该实体类为Spring Securiy使用，方便获取用户其他信息
 * @author yzd
 */
public class MyUserDetails implements UserDetails {

    private Integer id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private Boolean isActive;

    private Boolean isSuperuser;

    private Date gmtCreate;

    private Date gmtModified;

    public MyUserDetails(Integer id, String name, String email, String phone, String password, Boolean isActive, Boolean isSuperuser, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isActive = isActive;
        this.isSuperuser = isSuperuser;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public MyUserDetails() {
        super();
    }

    /**
     * 为Spring Security定制
     * @param id
     * @param name
     * @param email
     * @param phone
     * @param password
     * @param isActive
     * @param isSuperuser
     */
    public MyUserDetails(Integer id, String name, String email, String phone, String password, Boolean isActive, Boolean isSuperuser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isActive = isActive;
        this.isSuperuser = isSuperuser;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}