package com.codenote.mapper;

import com.codenote.entity.ExportLog;
import java.util.List;

public interface ExportLogMapper {
    int insert(ExportLog obj);
    int deleteById(Integer id);
    int update(ExportLog obj);
    ExportLog findById(Integer id);
    List<ExportLog> findAll();
    List<ExportLog> findByUserId(Integer userId);
    int countAll();
}
