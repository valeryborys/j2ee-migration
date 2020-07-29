package com.softeq.jm.commons.core;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@SessionScoped
public class UserCtx implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private HttpSession session;

    private AppUser appUser;

    private boolean isInitialized = false;

    public void login(AppUser user) {
        this.appUser = user;
        initialize();
    }

    public void initialize() {
        isInitialized = true;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public boolean isLoggedIn() {
        return appUser != null;
    }
}
