package com.codenote.service.impl;

import com.codenote.entity.NoteCategory;
import com.codenote.mapper.NoteCategoryMapper;
import com.codenote.service.NoteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteCategoryServiceImpl implements NoteCategoryService {
    @Autowired
    private NoteCategoryMapper mapper;

    public void save(NoteCategory noteCategory) {
        if (noteCategory.getId()==null) mapper.insert(noteCategory); else mapper.update(noteCategory);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public NoteCategory getById(Integer id) { return mapper.findById(id); }
    public List<NoteCategory> getAll() { return mapper.findAll(); }
    public List<NoteCategory> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
