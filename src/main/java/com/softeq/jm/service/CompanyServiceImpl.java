package com.softeq.jm.service;

import com.softeq.jm.model.Company;
import com.softeq.jm.repository.CompanyRepositoryImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CompanyServiceImpl implements CompanyService{

    @Inject
    private CompanyRepositoryImpl repo;

    public void persist(Company company) {
        repo.persist(company);
    }

    public List<Company> findAll() {
        return repo.findAll();
    }
}
