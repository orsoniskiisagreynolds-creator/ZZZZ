package com.codenote.service;

import com.codenote.entity.NoteTagRelation;
import java.util.List;

public interface NoteTagRelationService {
    void save(NoteTagRelation noteTagRelation);
    void delete(Integer id);
    NoteTagRelation getById(Integer id);
    List<NoteTagRelation> getAll();
    List<NoteTagRelation> getByUserId(Integer userId);
    int getCount();
}
