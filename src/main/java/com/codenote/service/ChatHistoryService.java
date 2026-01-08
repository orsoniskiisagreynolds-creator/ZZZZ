package com.codenote.service;

import com.codenote.entity.ChatHistory;
import java.util.List;

public interface ChatHistoryService {
    void save(ChatHistory chatHistory);
    void delete(Integer id);
    ChatHistory getById(Integer id);
    List<ChatHistory> getAll();
    List<ChatHistory> getByUserId(Integer userId);
    int getCount();
}
