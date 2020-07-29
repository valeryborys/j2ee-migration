package com.softeq.jm.service;

import com.softeq.jm.model.User;
import com.softeq.jm.repository.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {

    @Inject
    private UserRepository repo;

    public void save(User user) {
        repo.save(user);
    }

    public User getUser(String email, String password) {
        return repo.getUser(email, password);
    }
}
