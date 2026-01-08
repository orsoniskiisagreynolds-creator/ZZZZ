package com.codenote.mapper;

import com.codenote.entity.Document;
import java.util.List;

public interface DocumentMapper {
    int insert(Document obj);
    int deleteById(Integer id);
    int update(Document obj);
    Document findById(Integer id);
    List<Document> findAll();
    List<Document> findByUserId(Integer userId);
    int countAll();
}
