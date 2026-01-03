package com.codenote.service.impl;

import com.codenote.entity.Step;
import com.codenote.mapper.StepMapper;
import com.codenote.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StepServiceImpl implements StepService {
    @Autowired
    private StepMapper mapper;

    public void save(Step step) {
        if (step.getId()==null) mapper.insert(step); else mapper.update(step);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public Step getById(Integer id) { return mapper.findById(id); }
    public List<Step> getAll() { return mapper.findAll(); }
    public List<Step> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
