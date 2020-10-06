package com.example.test5.controller;


import com.example.test5.dao.UserRepo;
import com.example.test5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserRepo repo;
    @RequestMapping("/")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/getUser")
    public ModelAndView getUser(@RequestParam int id) {
        ModelAndView mv=new ModelAndView("userLogin");

        User user = repo.findById(id).orElse(new User());

        mv.addObject(user);
        return mv;
    }
}
