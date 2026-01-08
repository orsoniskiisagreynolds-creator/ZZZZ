package com.codenote.service.impl;

import com.codenote.entity.CodeSnippet;
import com.codenote.mapper.CodeSnippetMapper;
import com.codenote.service.CodeSnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CodeSnippetServiceImpl implements CodeSnippetService {
    @Autowired
    private CodeSnippetMapper mapper;

    public void save(CodeSnippet codeSnippet) {
        if (codeSnippet.getId()==null) mapper.insert(codeSnippet); else mapper.update(codeSnippet);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public CodeSnippet getById(Integer id) { return mapper.findById(id); }
    public List<CodeSnippet> getAll() { return mapper.findAll(); }
    public List<CodeSnippet> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
