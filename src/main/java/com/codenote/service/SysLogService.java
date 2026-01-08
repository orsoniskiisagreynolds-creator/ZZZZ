package com.codenote.service;

import com.codenote.entity.SysLog;
import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog);
    void delete(Integer id);
    SysLog getById(Integer id);
    List<SysLog> getAll();
    List<SysLog> getByUserId(Integer userId);
    int getCount();
}
