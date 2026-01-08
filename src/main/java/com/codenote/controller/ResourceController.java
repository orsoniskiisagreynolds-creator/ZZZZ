package com.codenote.controller;

import com.codenote.entity.ExternalResource;
import com.codenote.service.ExternalResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ExternalResourceService externalResourceService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", externalResourceService.getAll()); return "resource/list"; }

    @GetMapping("/create")
    public String create() { return "resource/create"; }

    @PostMapping("/save")
    public String save(ExternalResource externalResource) { externalResourceService.save(externalResource); return "redirect:/resource/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("externalResource", externalResourceService.getById(id)); return "resource/edit"; }

    @PostMapping("/update")
    public String update(ExternalResource externalResource) { externalResourceService.save(externalResource); return "redirect:/resource/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { externalResourceService.delete(id); return "redirect:/resource/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<ExternalResource> getAll() { return externalResourceService.getAll(); }
}
