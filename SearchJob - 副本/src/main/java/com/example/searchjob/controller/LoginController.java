package com.example.searchjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("title", "登录");
        return "index";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 这里可以添加实际的登录逻辑
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/to_homePage";
        } else {
            return "redirect:/?error=true";
        }
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/to_register")
    public String To_Register(Model model) {
        model.addAttribute("title", "注册");
        return "register";
    }

    @GetMapping("/to_login")
    public String To_Login(Model model) {
        model.addAttribute("title", "登录");
        return "index";
    }


}
