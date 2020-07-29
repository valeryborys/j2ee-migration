package com.softeq.jm.repository;

import com.softeq.jm.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User getUser(String email, String password) {
        try {
            User user = em.createQuery("select u from User u where u.email = :email and u.password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    public User findById(Integer userId) {
        try {
            User user = em.createQuery("select u from User u where u.id = :userId", User.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
