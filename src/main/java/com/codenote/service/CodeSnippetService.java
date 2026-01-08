package com.codenote.service;

import com.codenote.entity.CodeSnippet;
import java.util.List;

public interface CodeSnippetService {
    void save(CodeSnippet codeSnippet);
    void delete(Integer id);
    CodeSnippet getById(Integer id);
    List<CodeSnippet> getAll();
    List<CodeSnippet> getByUserId(Integer userId);
    int getCount();
}
