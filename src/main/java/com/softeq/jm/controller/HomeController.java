package com.softeq.jm.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

import javax.inject.Inject;
import java.io.Serializable;

@Controller
public class HomeController implements Serializable {

    @Inject
    private Result result;

    @Get
    @Path("")
    public void index() {
        result.redirectTo(this).home();
    }

    @Get
    public void home() {

    }
}
