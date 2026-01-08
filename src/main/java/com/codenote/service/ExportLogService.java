package com.codenote.service;

import com.codenote.entity.ExportLog;
import java.util.List;

public interface ExportLogService {
    void save(ExportLog exportLog);
    void delete(Integer id);
    ExportLog getById(Integer id);
    List<ExportLog> getAll();
    List<ExportLog> getByUserId(Integer userId);
    int getCount();
}
