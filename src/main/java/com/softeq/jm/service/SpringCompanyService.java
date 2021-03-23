package com.softeq.jm.service;

import com.softeq.jm.model.Company;

import com.softeq.jm.repository.CompanyDAO;
import com.softeq.jm.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringCompanyService implements CompanyService {

    private final CompanyDAO companyRepository;

    @Autowired
    public SpringCompanyService(CompanyDAO companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public void persist(Company company) {
        companyRepository.persist(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
