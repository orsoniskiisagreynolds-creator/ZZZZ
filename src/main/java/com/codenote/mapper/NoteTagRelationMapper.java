package com.codenote.mapper;

import com.codenote.entity.NoteTagRelation;
import java.util.List;

public interface NoteTagRelationMapper {
    int insert(NoteTagRelation obj);
    int deleteById(Integer id);
    int update(NoteTagRelation obj);
    NoteTagRelation findById(Integer id);
    List<NoteTagRelation> findAll();
    List<NoteTagRelation> findByUserId(Integer userId);
    int countAll();
}
