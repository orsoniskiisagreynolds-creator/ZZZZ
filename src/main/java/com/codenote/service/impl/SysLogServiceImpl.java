package com.codenote.service.impl;

import com.codenote.entity.SysLog;
import com.codenote.mapper.SysLogMapper;
import com.codenote.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper mapper;

    public void save(SysLog sysLog) {
        if (sysLog.getId()==null) mapper.insert(sysLog); else mapper.update(sysLog);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public SysLog getById(Integer id) { return mapper.findById(id); }
    public List<SysLog> getAll() { return mapper.findAll(); }
    public List<SysLog> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
