package com.softeq.jm.controller;

import com.softeq.jm.model.Company;
import com.softeq.jm.service.SpringCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cm")
public class SpringCompanyController {

    private final SpringCompanyService springCompanyService;

    @Autowired
    public SpringCompanyController(SpringCompanyService springCompanyService) {
        this.springCompanyService = springCompanyService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Company> all = springCompanyService.findAll();
        model.addAttribute("companies", all);
        return "springcompanies";
    }

    @PostMapping
    public String addCompany(@ModelAttribute("companies") Company company){
        springCompanyService.persist(company);
        return "springcompanies";
    }
}
