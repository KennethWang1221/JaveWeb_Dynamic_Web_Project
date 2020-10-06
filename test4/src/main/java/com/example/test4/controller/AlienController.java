package com.example.test4.controller;


import com.example.test4.dao.AlienRepo;
import com.example.test4.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlienController {

    @Autowired
    AlienRepo reop;

    @RequestMapping("/")
    public String home() {
        return "home.html";
    }


    @RequestMapping("/userLogin")
    public String userLogin(Alien alien) {
        return "userLogin.html";


    }
}
