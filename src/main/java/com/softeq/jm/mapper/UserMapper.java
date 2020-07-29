package com.softeq.jm.mapper;

import com.softeq.jm.commons.core.AppUser;
import com.softeq.jm.model.User;

public class UserMapper {

    public static AppUser getAppUser(User user) {
        AppUser appUser = new AppUser();
        appUser.setId(user.getId());
        appUser.setFirstName(user.getFirstName());
        appUser.setLastName(user.getLastName());
        appUser.setEmail(user.getEmail());
        return appUser;
    }
}
