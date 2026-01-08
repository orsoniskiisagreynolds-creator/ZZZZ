package com.codenote.controller;

import com.codenote.entity.ExportLog;
import com.codenote.service.ExportLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private ExportLogService exportLogService;

    @GetMapping("/list")
    public String list(Model m) { m.addAttribute("list", exportLogService.getAll()); return "export/list"; }

    @GetMapping("/create")
    public String create() { return "export/create"; }

    @PostMapping("/save")
    public String save(ExportLog exportLog) { exportLogService.save(exportLog); return "redirect:/export/list"; }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) { m.addAttribute("exportLog", exportLogService.getById(id)); return "export/edit"; }

    @PostMapping("/update")
    public String update(ExportLog exportLog) { exportLogService.save(exportLog); return "redirect:/export/list"; }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) { exportLogService.delete(id); return "redirect:/export/list"; }

    @GetMapping("/all")
    @ResponseBody
    public List<ExportLog> getAll() { return exportLogService.getAll(); }
}
