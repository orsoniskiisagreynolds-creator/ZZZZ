package com.codenote.mapper;

import com.codenote.entity.NoteShare;
import java.util.List;

public interface NoteShareMapper {
    int insert(NoteShare obj);
    int deleteById(Integer id);
    int update(NoteShare obj);
    NoteShare findById(Integer id);
    List<NoteShare> findAll();
    List<NoteShare> findByUserId(Integer userId);
    int countAll();
}
