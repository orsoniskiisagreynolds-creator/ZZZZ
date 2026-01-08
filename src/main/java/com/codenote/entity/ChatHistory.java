package com.codenote.entity;

import java.util.Date;

public class ChatHistory {
    private Integer id;
    private String sessionId;
    private String role;
    private String content;
    private Integer tokens;
    private Integer userId;
    private Date createTime;

    public ChatHistory() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Integer getTokens() { return tokens; }
    public void setTokens(Integer tokens) { this.tokens = tokens; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
