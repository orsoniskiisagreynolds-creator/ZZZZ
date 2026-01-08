package com.codenote.service.impl;

import com.codenote.entity.LearningPath;
import com.codenote.mapper.LearningPathMapper;
import com.codenote.service.LearningPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LearningPathServiceImpl implements LearningPathService {
    @Autowired
    private LearningPathMapper mapper;

    public void save(LearningPath learningPath) {
        if (learningPath.getId()==null) mapper.insert(learningPath); else mapper.update(learningPath);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public LearningPath getById(Integer id) { return mapper.findById(id); }
    public List<LearningPath> getAll() { return mapper.findAll(); }
    public List<LearningPath> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
