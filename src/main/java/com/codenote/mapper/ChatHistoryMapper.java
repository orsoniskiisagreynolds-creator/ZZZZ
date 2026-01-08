package com.codenote.mapper;

import com.codenote.entity.ChatHistory;
import java.util.List;

public interface ChatHistoryMapper {
    int insert(ChatHistory obj);
    int deleteById(Integer id);
    int update(ChatHistory obj);
    ChatHistory findById(Integer id);
    List<ChatHistory> findAll();
    List<ChatHistory> findByUserId(Integer userId);
    int countAll();
}
