package com.codenote.controller;

import com.codenote.entity.ChatHistory;
import com.codenote.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatHistoryService chatHistoryService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", chatHistoryService.getAll()); return "chat/list"; }

    @GetMapping("/create")
    public String create() { return "chat/create"; }

    @PostMapping("/save")
    public String save(ChatHistory chatHistory) { chatHistoryService.save(chatHistory); return "redirect:/chat/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("chatHistory", chatHistoryService.getById(id)); return "chat/edit"; }

    @PostMapping("/update")
    public String update(ChatHistory chatHistory) { chatHistoryService.save(chatHistory); return "redirect:/chat/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { chatHistoryService.delete(id); return "redirect:/chat/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<ChatHistory> getAll() { return chatHistoryService.getAll(); }
}
