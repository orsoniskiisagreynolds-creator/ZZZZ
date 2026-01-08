package com.codenote.mapper;

import com.codenote.entity.NoteHistory;
import java.util.List;

public interface NoteHistoryMapper {
    int insert(NoteHistory obj);
    int deleteById(Integer id);
    int update(NoteHistory obj);
    NoteHistory findById(Integer id);
    List<NoteHistory> findAll();
    List<NoteHistory> findByUserId(Integer userId);
    int countAll();
}
