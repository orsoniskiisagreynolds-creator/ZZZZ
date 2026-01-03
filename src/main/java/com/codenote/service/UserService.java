package com.codenote.service;

import com.codenote.entity.User;
import java.util.List;

public interface UserService {
    void save(User user);
    void delete(Integer id);
    User getById(Integer id);
    List<User> getAll();
    List<User> getByUserId(Integer userId);
    int getCount();
    User login(String username, String password);
}
