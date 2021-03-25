package com.softeq.jm.controller;


import com.softeq.jm.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cm")
public class SpringHomeController {

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }

}
