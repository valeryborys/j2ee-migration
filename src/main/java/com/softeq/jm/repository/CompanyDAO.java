package com.softeq.jm.repository;

import com.softeq.jm.model.Company;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAO implements CompanyRepository{

    private static final String HQL_FROM_COMPANY = "from Company";

    private final SessionFactory sessionFactory;
    @Autowired
    public CompanyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(Company company) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.saveOrUpdate(company);
    }

    @Override
    public List<Company> findAll() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createQuery(HQL_FROM_COMPANY, Company.class).getResultList();
    }
}
