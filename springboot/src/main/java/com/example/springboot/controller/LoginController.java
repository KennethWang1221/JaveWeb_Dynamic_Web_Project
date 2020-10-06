package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public String login(@RequestBody @Valid User user) {
        //postman
        return service.login(user);
    }
}
