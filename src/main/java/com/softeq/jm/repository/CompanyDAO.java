package com.softeq.jm.repository;

import com.softeq.jm.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAO implements CompanyRepository{

    private static final String HQL_FROM_COMPANY = "FROM company";

    private final SessionFactory sessionFactory;
    @Autowired
    public CompanyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(company);
    }

    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Company> list = (List<Company>) session.createQuery(HQL_FROM_COMPANY, Company.class).getResultList();
        return list;
    }
}
