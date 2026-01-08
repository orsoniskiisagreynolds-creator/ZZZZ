package com.codenote.service.impl;

import com.codenote.entity.NoteTagRelation;
import com.codenote.mapper.NoteTagRelationMapper;
import com.codenote.service.NoteTagRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteTagRelationServiceImpl implements NoteTagRelationService {
    @Autowired
    private NoteTagRelationMapper mapper;

    public void save(NoteTagRelation noteTagRelation) {
        if (noteTagRelation.getId()==null) mapper.insert(noteTagRelation); else mapper.update(noteTagRelation);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public NoteTagRelation getById(Integer id) { return mapper.findById(id); }
    public List<NoteTagRelation> getAll() { return mapper.findAll(); }
    public List<NoteTagRelation> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
