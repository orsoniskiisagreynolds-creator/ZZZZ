package com.codenote.service.impl;

import com.codenote.entity.ExportLog;
import com.codenote.mapper.ExportLogMapper;
import com.codenote.service.ExportLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExportLogServiceImpl implements ExportLogService {
    @Autowired
    private ExportLogMapper mapper;

    public void save(ExportLog exportLog) {
        if (exportLog.getId()==null) mapper.insert(exportLog); else mapper.update(exportLog);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public ExportLog getById(Integer id) { return mapper.findById(id); }
    public List<ExportLog> getAll() { return mapper.findAll(); }
    public List<ExportLog> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
