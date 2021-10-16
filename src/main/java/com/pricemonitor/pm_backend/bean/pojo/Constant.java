package com.pricemonitor.pm_backend.bean.pojo;

import java.io.Serializable;

public class Constant implements Serializable {
    private String type;

    private String title;

    private String description;

    private String url;

    private static final long serialVersionUID = 1L;

    public Constant(String type, String title, String description, String url) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Constant() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}