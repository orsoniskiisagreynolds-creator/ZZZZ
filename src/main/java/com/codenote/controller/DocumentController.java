package com.codenote.controller;

import com.codenote.entity.Document;
import com.codenote.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", documentService.getAll()); return "document/list"; }

    @GetMapping("/create")
    public String create() { return "document/create"; }

    @PostMapping("/save")
    public String save(Document document) { documentService.save(document); return "redirect:/document/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("document", documentService.getById(id)); return "document/edit"; }

    @PostMapping("/update")
    public String update(Document document) { documentService.save(document); return "redirect:/document/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { documentService.delete(id); return "redirect:/document/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<Document> getAll() { return documentService.getAll(); }
}
