package com.codenote.mapper;

import com.codenote.entity.NoteTag;
import java.util.List;

public interface NoteTagMapper {
    int insert(NoteTag obj);
    int deleteById(Integer id);
    int update(NoteTag obj);
    NoteTag findById(Integer id);
    List<NoteTag> findAll();
    List<NoteTag> findByUserId(Integer userId);
    int countAll();
}
