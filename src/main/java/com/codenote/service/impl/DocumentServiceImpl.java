package com.codenote.service.impl;

import com.codenote.entity.Document;
import com.codenote.mapper.DocumentMapper;
import com.codenote.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper mapper;

    public void save(Document document) {
        if (document.getId()==null) mapper.insert(document); else mapper.update(document);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public Document getById(Integer id) { return mapper.findById(id); }
    public List<Document> getAll() { return mapper.findAll(); }
    public List<Document> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
