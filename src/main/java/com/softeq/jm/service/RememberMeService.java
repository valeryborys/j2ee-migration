package com.softeq.jm.service;

import com.softeq.jm.commons.core.AppUser;
import com.softeq.jm.commons.util.CookieUtil;
import com.softeq.jm.model.RememberMe;
import com.softeq.jm.repository.RememberMeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Stateless
public class RememberMeService {

    private static final String COOKIE_NAME = "RememberMeCookie";

    @Inject
    private RememberMeRepository repo;

    @Inject
    private HttpServletResponse response;

    public void rememberUser(AppUser appUser) {
        String token = UUID.randomUUID().toString();
        save(appUser.getId(), token);
        CookieUtil.addCookie(response, COOKIE_NAME, token, 604800);
    }

    private void save(Integer userId, String token) {
        RememberMe rememberMe = repo.findByuser(userId);
        if (rememberMe == null) {
            rememberMe = new RememberMe();
            rememberMe.setUserId(userId);
        }
        rememberMe.setToken(token);
        repo.save(rememberMe);
    }
}
