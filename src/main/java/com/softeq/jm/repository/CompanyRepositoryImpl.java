package com.softeq.jm.repository;

import com.softeq.jm.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CompanyRepositoryImpl{
    @PersistenceContext
    private EntityManager em;

    public void persist(Company company) {
        em.persist(company);
    }

    public List<Company> findAll() {
        return em.createQuery("select c from Company c order by c.id").getResultList();
    }
}
