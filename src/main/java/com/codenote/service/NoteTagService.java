package com.codenote.service;

import com.codenote.entity.NoteTag;
import java.util.List;

public interface NoteTagService {
    void save(NoteTag noteTag);
    void delete(Integer id);
    NoteTag getById(Integer id);
    List<NoteTag> getAll();
    List<NoteTag> getByUserId(Integer userId);
    int getCount();
}
