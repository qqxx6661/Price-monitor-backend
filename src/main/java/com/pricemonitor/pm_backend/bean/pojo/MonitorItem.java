package com.pricemonitor.pm_backend.bean.pojo;

import java.io.Serializable;
import java.util.Date;

public class MonitorItem implements Serializable {
    private Integer id;

    private Integer userId;

    private String userPrice;

    private Long itemId;

    private Long categoryId;

    private String name;

    private String subtitle;

    private String price;

    private String plusPrice;

    private String maxPrice;

    private String minPrice;

    private String discount;

    private String lastPrice;

    private String note;

    private String sale;

    private String label;

    private String storeName;

    private Boolean isZiying;

    private Boolean isAlert;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public MonitorItem(Integer id, Integer userId, String userPrice, Long itemId, Long categoryId, String name, String subtitle, String price, String plusPrice, String maxPrice, String minPrice, String discount, String lastPrice, String note, String sale, String label, String storeName, Boolean isZiying, Boolean isAlert, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.userId = userId;
        this.userPrice = userPrice;
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.name = name;
        this.subtitle = subtitle;
        this.price = price;
        this.plusPrice = plusPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.discount = discount;
        this.lastPrice = lastPrice;
        this.note = note;
        this.sale = sale;
        this.label = label;
        this.storeName = storeName;
        this.isZiying = isZiying;
        this.isAlert = isAlert;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public MonitorItem() {
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

    public String getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(String userPrice) {
        this.userPrice = userPrice == null ? null : userPrice.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPlusPrice() {
        return plusPrice;
    }

    public void setPlusPrice(String plusPrice) {
        this.plusPrice = plusPrice == null ? null : plusPrice.trim();
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice == null ? null : maxPrice.trim();
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice == null ? null : minPrice.trim();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice == null ? null : lastPrice.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale == null ? null : sale.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Boolean getIsZiying() {
        return isZiying;
    }

    public void setIsZiying(Boolean isZiying) {
        this.isZiying = isZiying;
    }

    public Boolean getIsAlert() {
        return isAlert;
    }

    public void setIsAlert(Boolean isAlert) {
        this.isAlert = isAlert;
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
        sb.append(", userPrice=").append(userPrice);
        sb.append(", itemId=").append(itemId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", name=").append(name);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", price=").append(price);
        sb.append(", plusPrice=").append(plusPrice);
        sb.append(", maxPrice=").append(maxPrice);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", discount=").append(discount);
        sb.append(", lastPrice=").append(lastPrice);
        sb.append(", note=").append(note);
        sb.append(", sale=").append(sale);
        sb.append(", label=").append(label);
        sb.append(", storeName=").append(storeName);
        sb.append(", isZiying=").append(isZiying);
        sb.append(", isAlert=").append(isAlert);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}