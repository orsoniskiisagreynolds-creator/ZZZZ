package com.codenote.service.impl;

import com.codenote.entity.NoteHistory;
import com.codenote.mapper.NoteHistoryMapper;
import com.codenote.service.NoteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteHistoryServiceImpl implements NoteHistoryService {
    @Autowired
    private NoteHistoryMapper mapper;

    public void save(NoteHistory noteHistory) {
        if (noteHistory.getId()==null) mapper.insert(noteHistory); else mapper.update(noteHistory);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public NoteHistory getById(Integer id) { return mapper.findById(id); }
    public List<NoteHistory> getAll() { return mapper.findAll(); }
    public List<NoteHistory> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
