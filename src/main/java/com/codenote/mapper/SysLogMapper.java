package com.codenote.mapper;

import com.codenote.entity.SysLog;
import java.util.List;

public interface SysLogMapper {
    int insert(SysLog obj);
    int deleteById(Integer id);
    int update(SysLog obj);
    SysLog findById(Integer id);
    List<SysLog> findAll();
    List<SysLog> findByUserId(Integer userId);
    int countAll();
}
