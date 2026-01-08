package com.codenote.service.impl;

import com.codenote.entity.ExternalResource;
import com.codenote.mapper.ExternalResourceMapper;
import com.codenote.service.ExternalResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExternalResourceServiceImpl implements ExternalResourceService {
    @Autowired
    private ExternalResourceMapper mapper;

    public void save(ExternalResource externalResource) {
        if (externalResource.getId()==null) mapper.insert(externalResource); else mapper.update(externalResource);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public ExternalResource getById(Integer id) { return mapper.findById(id); }
    public List<ExternalResource> getAll() { return mapper.findAll(); }
    public List<ExternalResource> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
