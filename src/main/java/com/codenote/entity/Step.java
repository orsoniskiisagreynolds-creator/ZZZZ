package com.codenote.entity;

import java.util.Date;

public class Step {
    private Integer id;
    private String title;
    private String description;
    private String code;
    private String layer;
    private Integer fileIndex;
    private Integer sortOrder;

    public Step() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getLayer() { return layer; }
    public void setLayer(String layer) { this.layer = layer; }
    public Integer getFileIndex() { return fileIndex; }
    public void setFileIndex(Integer fileIndex) { this.fileIndex = fileIndex; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
}
