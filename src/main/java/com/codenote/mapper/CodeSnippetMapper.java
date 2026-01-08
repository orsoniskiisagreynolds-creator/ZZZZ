package com.codenote.mapper;

import com.codenote.entity.CodeSnippet;
import java.util.List;

public interface CodeSnippetMapper {
    int insert(CodeSnippet obj);
    int deleteById(Integer id);
    int update(CodeSnippet obj);
    CodeSnippet findById(Integer id);
    List<CodeSnippet> findAll();
    List<CodeSnippet> findByUserId(Integer userId);
    int countAll();
}
