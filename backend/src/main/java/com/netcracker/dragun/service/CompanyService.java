package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Company;
import com.netcracker.dragun.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public Company get(Long id) {
        return companyRepository.findById(id).get();
    }
    public Company save(Company company) {
        return companyRepository.save(company);
    }
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
