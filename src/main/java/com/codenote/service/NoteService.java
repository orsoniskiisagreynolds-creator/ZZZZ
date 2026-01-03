package com.codenote.service;

import com.codenote.entity.Note;
import java.util.List;

public interface NoteService {
    void save(Note note);
    void delete(Integer id);
    Note getById(Integer id);
    List<Note> getAll();
    List<Note> getByUserId(Integer userId);
    int getCount();
}
