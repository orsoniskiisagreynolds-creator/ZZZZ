package com.codenote.mapper;

import com.codenote.entity.User;
import java.util.List;

public interface UserMapper {
    int insert(User obj);
    int deleteById(Integer id);
    int update(User obj);
    User findById(Integer id);
    List<User> findAll();
    List<User> findByUserId(Integer userId);
    int countAll();
    User findByUsername(String username);
}
