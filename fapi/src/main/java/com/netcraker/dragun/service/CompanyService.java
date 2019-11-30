package com.netcraker.dragun.service;

import com.netcraker.dragun.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyService {
    private RestTemplate restTemplate;
    @Value("${backend.url}")
    private String backendURL;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CompanyService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Company get(Long id) {
        return restTemplate.getForObject(backendURL + "companies/" + id, Company.class);
    }
    public Company getCompanyByLogin (String login) {
        return restTemplate.getForObject(backendURL + "companies/login/" + login, Company.class);
    }

    public List<Company> getAll() {
        return Arrays.asList(restTemplate.getForObject(backendURL + "companies/", Company[].class));
    }

    public Company create(Company company) {
        company.setPassword(bCryptPasswordEncoder.encode(company.getPassword()));
        return restTemplate.postForObject(backendURL + "companies/", company, Company.class);
    }

    public void update(Company company, Long id) {
        restTemplate.put(backendURL + "companies/" + id, company);
    }

    public void delete(Long id) {
        restTemplate.delete(backendURL + "companies/" + id);
    }
}
