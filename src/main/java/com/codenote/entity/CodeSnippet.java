package com.codenote.entity;

import java.util.Date;

public class CodeSnippet {
    private Integer id;
    private String title;
    private String code;
    private String language;
    private String description;
    private Integer userId;
    private Integer isFavorite;
    private Integer useCount;
    private Date createTime;
    private Date updateTime;

    public CodeSnippet() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getIsFavorite() { return isFavorite; }
    public void setIsFavorite(Integer isFavorite) { this.isFavorite = isFavorite; }
    public Integer getUseCount() { return useCount; }
    public void setUseCount(Integer useCount) { this.useCount = useCount; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}
