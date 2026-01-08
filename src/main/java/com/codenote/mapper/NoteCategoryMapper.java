package com.codenote.mapper;

import com.codenote.entity.NoteCategory;
import java.util.List;

public interface NoteCategoryMapper {
    int insert(NoteCategory obj);
    int deleteById(Integer id);
    int update(NoteCategory obj);
    NoteCategory findById(Integer id);
    List<NoteCategory> findAll();
    List<NoteCategory> findByUserId(Integer userId);
    int countAll();
}
