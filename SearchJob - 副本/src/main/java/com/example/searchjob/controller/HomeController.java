package com.example.searchjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("to_homePage")
    public String toHomePage(){
        return "homePage";
    }
}
