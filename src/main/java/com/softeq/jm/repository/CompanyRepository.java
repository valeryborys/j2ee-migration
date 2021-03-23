package com.softeq.jm.repository;

import com.softeq.jm.model.Company;

import java.util.List;

public interface CompanyRepository {
    void persist(Company company);
    List<Company> findAll();
}
