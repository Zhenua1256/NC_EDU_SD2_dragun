package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Company;
import com.netcracker.dragun.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
   /* public Company save(Company company) {
        return companyRepository.save(company);
    }*/
    public ResponseEntity<Company> save(Company company) {
        List<String> logins;
        logins = companyRepository.findAllLogin();
        for (String login: logins) {
            if (login.equals(company.getDataUser().getLogin())){
                return new ResponseEntity<>(company , HttpStatus.BAD_REQUEST);
            }
        }
        Company createdUser = companyRepository.save(company);
        return new ResponseEntity<>(createdUser , HttpStatus.OK);
    }
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
