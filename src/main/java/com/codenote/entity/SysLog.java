package com.codenote.entity;

import java.util.Date;

public class SysLog {
    private Integer id;
    private Integer userId;
    private String module;
    private String operation;
    private String method;
    private String params;
    private String ip;
    private Date createTime;

    public SysLog() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getModule() { return module; }
    public void setModule(String module) { this.module = module; }
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public String getParams() { return params; }
    public void setParams(String params) { this.params = params; }
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
