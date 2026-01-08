package com.codenote.service;

import com.codenote.entity.LearningPath;
import java.util.List;

public interface LearningPathService {
    void save(LearningPath learningPath);
    void delete(Integer id);
    LearningPath getById(Integer id);
    List<LearningPath> getAll();
    List<LearningPath> getByUserId(Integer userId);
    int getCount();
}
