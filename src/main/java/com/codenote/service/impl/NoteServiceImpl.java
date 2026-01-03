package com.codenote.service.impl;

import com.codenote.entity.Note;
import com.codenote.mapper.NoteMapper;
import com.codenote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper mapper;

    public void save(Note note) {
        if (note.getId()==null) mapper.insert(note); else mapper.update(note);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public Note getById(Integer id) { return mapper.findById(id); }
    public List<Note> getAll() { return mapper.findAll(); }
    public List<Note> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
