package com.codenote.service.impl;

import com.codenote.entity.NoteShare;
import com.codenote.mapper.NoteShareMapper;
import com.codenote.service.NoteShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteShareServiceImpl implements NoteShareService {
    @Autowired
    private NoteShareMapper mapper;

    public void save(NoteShare noteShare) {
        if (noteShare.getId()==null) mapper.insert(noteShare); else mapper.update(noteShare);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public NoteShare getById(Integer id) { return mapper.findById(id); }
    public List<NoteShare> getAll() { return mapper.findAll(); }
    public List<NoteShare> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
