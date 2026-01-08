package com.codenote.controller;

import com.codenote.entity.CodeSnippet;
import com.codenote.service.CodeSnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/snippet")
public class SnippetController {
    @Autowired
    private CodeSnippetService codeSnippetService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", codeSnippetService.getAll()); return "snippet/list"; }

    @GetMapping("/create")
    public String create() { return "snippet/create"; }

    @PostMapping("/save")
    public String save(CodeSnippet codeSnippet) { codeSnippetService.save(codeSnippet); return "redirect:/snippet/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("codeSnippet", codeSnippetService.getById(id)); return "snippet/edit"; }

    @PostMapping("/update")
    public String update(CodeSnippet codeSnippet) { codeSnippetService.save(codeSnippet); return "redirect:/snippet/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { codeSnippetService.delete(id); return "redirect:/snippet/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<CodeSnippet> getAll() { return codeSnippetService.getAll(); }
}
