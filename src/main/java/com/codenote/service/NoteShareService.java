package com.codenote.service;

import com.codenote.entity.NoteShare;
import java.util.List;

public interface NoteShareService {
    void save(NoteShare noteShare);
    void delete(Integer id);
    NoteShare getById(Integer id);
    List<NoteShare> getAll();
    List<NoteShare> getByUserId(Integer userId);
    int getCount();
}
