package com.codenote.mapper;

import com.codenote.entity.Step;
import java.util.List;

public interface StepMapper {
    int insert(Step obj);
    int deleteById(Integer id);
    int update(Step obj);
    Step findById(Integer id);
    List<Step> findAll();
    List<Step> findByUserId(Integer userId);
    int countAll();
}
