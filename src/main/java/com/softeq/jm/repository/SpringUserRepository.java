package com.softeq.jm.repository;


import com.softeq.jm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SpringUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserByEmail(String email){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where email = :email", User.class)
                .setParameter("email", email).getSingleResult();
    }
}