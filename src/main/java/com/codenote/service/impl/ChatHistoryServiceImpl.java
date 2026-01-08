package com.codenote.service.impl;

import com.codenote.entity.ChatHistory;
import com.codenote.mapper.ChatHistoryMapper;
import com.codenote.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {
    @Autowired
    private ChatHistoryMapper mapper;

    public void save(ChatHistory chatHistory) {
        if (chatHistory.getId()==null) mapper.insert(chatHistory); else mapper.update(chatHistory);
    }
    public void delete(Integer id) { mapper.deleteById(id); }
    public ChatHistory getById(Integer id) { return mapper.findById(id); }
    public List<ChatHistory> getAll() { return mapper.findAll(); }
    public List<ChatHistory> getByUserId(Integer userId) { return mapper.findByUserId(userId); }
    public int getCount() { return mapper.countAll(); }
}
