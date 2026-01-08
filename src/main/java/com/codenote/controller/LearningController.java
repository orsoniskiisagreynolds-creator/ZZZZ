package com.codenote.controller;

import com.codenote.entity.LearningPath;
import com.codenote.service.LearningPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/learning")
public class LearningController {
    @Autowired
    private LearningPathService learningPathService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", learningPathService.getAll()); return "learning/list"; }

    @GetMapping("/create")
    public String create() { return "learning/create"; }

    @PostMapping("/save")
    public String save(LearningPath learningPath) { learningPathService.save(learningPath); return "redirect:/learning/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("learningPath", learningPathService.getById(id)); return "learning/edit"; }

    @PostMapping("/update")
    public String update(LearningPath learningPath) { learningPathService.save(learningPath); return "redirect:/learning/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { learningPathService.delete(id); return "redirect:/learning/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<LearningPath> getAll() { return learningPathService.getAll(); }
}
