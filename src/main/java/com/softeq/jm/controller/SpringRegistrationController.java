package com.softeq.jm.controller;

import com.softeq.jm.model.User;
import com.softeq.jm.service.SpringUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class SpringRegistrationController {
    private final SpringUserService springUserService;

    public SpringRegistrationController(SpringUserService springUserService) {
        this.springUserService = springUserService;
    }

    @GetMapping
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registration( @ModelAttribute("user") @Valid User user, Model model){
       if(!springUserService.saveUser(user)){
           model.addAttribute("emailError", "User with this E-mail already registered");
           return "registration";
       }
        return "redirect:/home/home";
    }

}
