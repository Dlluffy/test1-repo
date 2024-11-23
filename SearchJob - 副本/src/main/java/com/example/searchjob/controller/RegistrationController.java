package com.example.searchjob.controller;

import ch.qos.logback.core.model.Model;
import com.example.searchjob.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String register
            (
                    @RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("email") String email,
                    @RequestParam("fullName") String fullName,
                    @RequestParam("phoneNumber") String phoneNumber,
                    @RequestParam("address") String address,
                    Model model
            ){
        User user = new User(username, password, email, fullName, phoneNumber, address);
        return "register";
    }
}
