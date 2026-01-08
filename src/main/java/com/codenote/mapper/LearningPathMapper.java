package com.codenote.mapper;

import com.codenote.entity.LearningPath;
import java.util.List;

public interface LearningPathMapper {
    int insert(LearningPath obj);
    int deleteById(Integer id);
    int update(LearningPath obj);
    LearningPath findById(Integer id);
    List<LearningPath> findAll();
    List<LearningPath> findByUserId(Integer userId);
    int countAll();
}
