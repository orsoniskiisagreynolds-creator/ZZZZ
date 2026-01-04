package com.codenote.controller;

import com.codenote.entity.Step;
import com.codenote.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepService stepService;

    @GetMapping("/all")
    @ResponseBody
    public List<Step> getAll() { return stepService.getAll(); }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Step get(@PathVariable Integer id) { return stepService.getById(id); }
}
