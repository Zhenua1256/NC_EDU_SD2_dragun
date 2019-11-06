package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.Company;
import com.netcraker.dragun.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController (CompanyService companyService){
        this.companyService = companyService;
    }
    @GetMapping
    public List<Company> getAll() {
        return companyService.getAll();
    }
    @GetMapping("/{id}")
    public Company get(@PathVariable(name = "id") Long id) {
        return companyService.get(id);
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return companyService.create(company);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody Company company,
                       @PathVariable(name = "id") Long id) {
        companyService.update(company, id);
    }
    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        companyService.delete(id);
    }
}
