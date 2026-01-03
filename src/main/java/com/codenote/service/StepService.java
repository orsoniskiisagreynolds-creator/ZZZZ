package com.codenote.service;

import com.codenote.entity.Step;
import java.util.List;

public interface StepService {
    void save(Step step);
    void delete(Integer id);
    Step getById(Integer id);
    List<Step> getAll();
    List<Step> getByUserId(Integer userId);
    int getCount();
}
