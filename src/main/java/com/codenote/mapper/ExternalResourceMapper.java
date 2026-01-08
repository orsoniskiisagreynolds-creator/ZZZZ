package com.codenote.mapper;

import com.codenote.entity.ExternalResource;
import java.util.List;

public interface ExternalResourceMapper {
    int insert(ExternalResource obj);
    int deleteById(Integer id);
    int update(ExternalResource obj);
    ExternalResource findById(Integer id);
    List<ExternalResource> findAll();
    List<ExternalResource> findByUserId(Integer userId);
    int countAll();
}
