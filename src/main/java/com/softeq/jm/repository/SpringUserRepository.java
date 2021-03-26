package com.softeq.jm.repository;


import com.softeq.jm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Repository
@Transactional
public class SpringUserRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public SpringUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        User user;
        try {
            user = session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
        return user;
    }

    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}