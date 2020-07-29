package com.softeq.jm.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.softeq.jm.model.Company;
import com.softeq.jm.service.CompanyService;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class CompanyController {

    @Inject
    private Validator validator;

    @Inject
    private CompanyService companyService;

    @Inject
    private Result result;

    @Get
    public void companies() {
        result.include("companies", companyService.findAll());
    }

    @Post
    public void add(@Valid Company company) {
        validator.onErrorForwardTo(this).companies();
        companyService.persist(company);
        result.redirectTo(this).companies();
    }
}
