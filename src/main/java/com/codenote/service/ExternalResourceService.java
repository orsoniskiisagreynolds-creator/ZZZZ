package com.codenote.service;

import com.codenote.entity.ExternalResource;
import java.util.List;

public interface ExternalResourceService {
    void save(ExternalResource externalResource);
    void delete(Integer id);
    ExternalResource getById(Integer id);
    List<ExternalResource> getAll();
    List<ExternalResource> getByUserId(Integer userId);
    int getCount();
}
