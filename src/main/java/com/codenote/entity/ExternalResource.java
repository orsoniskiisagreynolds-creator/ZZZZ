package com.codenote.entity;

import java.util.Date;

public class ExternalResource {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private String category;
    private String favicon;
    private Integer userId;
    private Integer isFavorite;
    private Integer visitCount;
    private Date lastVisitTime;
    private Date createTime;

    public ExternalResource() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getFavicon() { return favicon; }
    public void setFavicon(String favicon) { this.favicon = favicon; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getIsFavorite() { return isFavorite; }
    public void setIsFavorite(Integer isFavorite) { this.isFavorite = isFavorite; }
    public Integer getVisitCount() { return visitCount; }
    public void setVisitCount(Integer visitCount) { this.visitCount = visitCount; }
    public Date getLastVisitTime() { return lastVisitTime; }
    public void setLastVisitTime(Date lastVisitTime) { this.lastVisitTime = lastVisitTime; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
