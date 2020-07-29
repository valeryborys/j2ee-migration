package com.softeq.jm.commons.web.auth;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import com.softeq.jm.commons.core.UserCtx;
import com.softeq.jm.commons.web.interceptor.RememberMeInterceptor;
import com.softeq.jm.controller.LoginController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Intercepts(after = RememberMeInterceptor.class)
@RequestScoped
public class AuthenticationInterceptor {

    @Inject
    private UserCtx userCtx;

    @Inject
    private Result result;

    @Accepts
    public boolean accepts(ControllerMethod method) {
        return !method.getMethod().isAnnotationPresent(PublicResource.class);
    }

    @BeforeCall
    public void checkAuth() {
        if (!userCtx.isLoggedIn()) {
            forwardToLoginPage();
        }
    }

    private void forwardToLoginPage() {
        result.forwardTo(LoginController.class).login();
    }
}
