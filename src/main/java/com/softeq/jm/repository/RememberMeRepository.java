package com.softeq.jm.repository;

import com.softeq.jm.model.RememberMe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RememberMeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(RememberMe rememberMe) {
        em.persist(rememberMe);
    }

    public RememberMe findByuser(Integer userId) {
        try {
            RememberMe rememberMe = em.createQuery("select r from RememberMe r where r.userId = :userId", RememberMe.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
            if (rememberMe != null) {
                return rememberMe;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public Integer finduserIdByToken(String token) {
        try {
            RememberMe rememberMe = em.createQuery("select r from RememberMe r where r.token = :token", RememberMe.class)
                    .setParameter("token", token)
                    .getSingleResult();
            if (rememberMe == null) {
                return null;
            } else {
                return rememberMe.getUserId();
            }
        } catch (Exception e) {
            return null;
        }
    }
}
