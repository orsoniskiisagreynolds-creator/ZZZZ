package com.codenote.service;

import com.codenote.entity.NoteHistory;
import java.util.List;

public interface NoteHistoryService {
    void save(NoteHistory noteHistory);
    void delete(Integer id);
    NoteHistory getById(Integer id);
    List<NoteHistory> getAll();
    List<NoteHistory> getByUserId(Integer userId);
    int getCount();
}
