package com.softeq.jm.commons.web.interceptor;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import com.softeq.jm.commons.core.AppUser;
import com.softeq.jm.commons.core.UserCtx;
import com.softeq.jm.commons.util.CookieUtil;
import com.softeq.jm.commons.web.auth.PublicResource;
import com.softeq.jm.controller.HomeController;
import com.softeq.jm.mapper.UserMapper;
import com.softeq.jm.model.User;
import com.softeq.jm.repository.RememberMeRepository;
import com.softeq.jm.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Intercepts(after = AppContextInterceptor.class)
@RequestScoped
public class RememberMeInterceptor {

    private static final String COOKIE_NAME = "RememberMeCookie";

    @Inject
    private UserCtx userCtx;

    @Inject
    private HttpServletRequest request;

    @Inject
    private RememberMeRepository rememberMeRepo;

    @Inject
    private UserRepository userRepo;

    @Inject
    private Result result;

    @Accepts
    public boolean accepts(ControllerMethod method) {
        return !method.getMethod().isAnnotationPresent(PublicResource.class);
    }

    @BeforeCall
    public void initContext() {
        if (!userCtx.isLoggedIn()) {
            loginRememberedUser();
        }
    }

    private void loginRememberedUser() {
        String token = CookieUtil.getCookieValue(request, COOKIE_NAME);
        if (token != null) {
            AppUser appUser = findUser(token);
            if (appUser != null) {
                userCtx.login(appUser);
                result.redirectTo(HomeController.class).index();
            }
        }
    }

    private AppUser findUser(String token) {
        Integer userId = rememberMeRepo.finduserIdByToken(token);
        if (userId == null) {
            return null;
        }
        return findUserById(userId);
    }

    private AppUser findUserById(Integer userId) {
        User user = userRepo.findById(userId);
        return UserMapper.getAppUser(user);
    }
}
