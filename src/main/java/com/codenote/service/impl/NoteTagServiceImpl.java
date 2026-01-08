package com.codenote.service.impl;

import com.codenote.entity.NoteTag;
import com.codenote.mapper.NoteTagMapper;
import com.codenote.service.NoteTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteTagServiceImpl implements NoteTagService {
    @Autowired
    private NoteTagMapper mapper;

    public void save(NoteTag noteTag) {
        if (noteTag.getId()==null) mapper.insert(noteTag); else mapper.update(noteTag);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public NoteTag getById(Integer id) { return mapper.findById(id); }
    public List<NoteTag> getAll() { return mapper.findAll(); }
    public List<NoteTag> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
