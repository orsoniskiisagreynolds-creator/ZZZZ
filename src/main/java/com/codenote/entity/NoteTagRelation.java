package com.codenote.entity;

import java.util.Date;

public class NoteTagRelation {
    private Integer id;
    private Integer noteId;
    private Integer tagId;

    public NoteTagRelation() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getNoteId() { return noteId; }
    public void setNoteId(Integer noteId) { this.noteId = noteId; }
    public Integer getTagId() { return tagId; }
    public void setTagId(Integer tagId) { this.tagId = tagId; }
}
