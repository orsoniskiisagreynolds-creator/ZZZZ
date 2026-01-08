package com.codenote.service;

import com.codenote.entity.NoteCategory;
import java.util.List;

public interface NoteCategoryService {
    void save(NoteCategory noteCategory);
    void delete(Integer id);
    NoteCategory getById(Integer id);
    List<NoteCategory> getAll();
    List<NoteCategory> getByUserId(Integer userId);
    int getCount();
}
