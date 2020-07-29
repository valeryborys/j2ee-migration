package com.softeq.jm.commons.web.interceptor;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import com.softeq.jm.commons.core.UserCtx;

import javax.inject.Inject;

@Intercepts
public class AppContextInterceptor {

    @Inject
    private UserCtx userCtx;

    @BeforeCall
    public void initContext() {
        if (userCtx.isInitialized()) {
            return;
        }
        userCtx.initialize();
    }
}
