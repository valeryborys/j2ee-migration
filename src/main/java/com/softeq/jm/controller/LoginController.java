package com.softeq.jm.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.softeq.jm.commons.core.AppUser;
import com.softeq.jm.commons.core.UserCtx;
import com.softeq.jm.commons.web.auth.PublicResource;
import com.softeq.jm.mapper.UserMapper;
import com.softeq.jm.model.User;
import com.softeq.jm.service.RememberMeService;
import com.softeq.jm.service.UserService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@Controller
public class LoginController implements Serializable {

    @Inject
    private UserService userService;

    @Inject
    private Result result;

    @Inject
    private UserCtx userCtx;

    @Inject
    private HttpServletResponse response;

    @Inject
    private RememberMeService rememberMeService;

    @Get
    public void login() {
        result.include("user", new User());
    }

    @Post
    @PublicResource
    public void signin(String email, String password, boolean rememberme) {
        User user = userService.getUser(email, password);
        if (user == null) {
            result.include("errorMessage", "incorrect email or password");
            result.redirectTo(this).login();
        }
        AppUser appUser = UserMapper.getAppUser(user);
        userCtx.login(appUser);
        rememberMeService.rememberUser(appUser);
        result.redirectTo(HomeController.class).index();
    }
}
