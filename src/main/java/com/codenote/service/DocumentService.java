package com.codenote.service;

import com.codenote.entity.Document;
import java.util.List;

public interface DocumentService {
    void save(Document document);
    void delete(Integer id);
    Document getById(Integer id);
    List<Document> getAll();
    List<Document> getByUserId(Integer userId);
    int getCount();
}
