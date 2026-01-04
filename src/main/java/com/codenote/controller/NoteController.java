package com.codenote.controller;

import com.codenote.entity.Note;
import com.codenote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", noteService.getAll()); return "note/list"; }

    @GetMapping("/create")
    public String create() { return "note/create"; }

    @PostMapping("/save")
    public String save(Note note) { noteService.save(note); return "redirect:/note/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("note", noteService.getById(id)); return "note/edit"; }

    @PostMapping("/update")
    public String update(Note note) { noteService.save(note); return "redirect:/note/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { noteService.delete(id); return "redirect:/note/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<Note> getAll() { return noteService.getAll(); }
}
