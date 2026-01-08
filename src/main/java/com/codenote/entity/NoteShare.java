package com.codenote.entity;

import java.util.Date;

public class NoteShare {
    private Integer id;
    private Integer noteId;
    private String shareCode;
    private String shareUrl;
    private String password;
    private Date expireTime;
    private Integer viewCount;
    private Integer status;
    private Date createTime;

    public NoteShare() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getNoteId() { return noteId; }
    public void setNoteId(Integer noteId) { this.noteId = noteId; }
    public String getShareCode() { return shareCode; }
    public void setShareCode(String shareCode) { this.shareCode = shareCode; }
    public String getShareUrl() { return shareUrl; }
    public void setShareUrl(String shareUrl) { this.shareUrl = shareUrl; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Date getExpireTime() { return expireTime; }
    public void setExpireTime(Date expireTime) { this.expireTime = expireTime; }
    public Integer getViewCount() { return viewCount; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
