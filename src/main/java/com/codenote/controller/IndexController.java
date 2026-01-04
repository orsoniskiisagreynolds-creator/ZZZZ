package com.codenote.controller;

import com.codenote.entity.User;
import com.codenote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() { return "guide"; }
    @GetMapping("/guide")
    public String guide() { return "guide"; }
    @GetMapping("/login")
    public String login() { return "login"; }
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/guide";
        }
        return "redirect:/login?error=1";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/login";
    }
}
