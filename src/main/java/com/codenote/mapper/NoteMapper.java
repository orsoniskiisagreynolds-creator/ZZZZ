package com.codenote.mapper;

import com.codenote.entity.Note;
import java.util.List;

public interface NoteMapper {
    int insert(Note obj);
    int deleteById(Integer id);
    int update(Note obj);
    Note findById(Integer id);
    List<Note> findAll();
    List<Note> findByUserId(Integer userId);
    int countAll();
}
