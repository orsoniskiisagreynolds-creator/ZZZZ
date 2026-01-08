package com.codenote.entity;

import java.util.Date;

public class NoteHistory {
    private Integer id;
    private Integer noteId;
    private String title;
    private String content;
    private Integer version;
    private Date createTime;

    public NoteHistory() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getNoteId() { return noteId; }
    public void setNoteId(Integer noteId) { this.noteId = noteId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
