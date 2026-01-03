package com.codenote.service.impl;

import com.codenote.entity.User;
import com.codenote.mapper.UserMapper;
import com.codenote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    public void save(User user) {
        if (user.getId()==null) mapper.insert(user); else mapper.update(user);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public User getById(Integer id) { return mapper.findById(id); }
    public List<User> getAll() { return mapper.findAll(); }
    public List<User> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
    public User login(String username, String password) {
        User user = mapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
