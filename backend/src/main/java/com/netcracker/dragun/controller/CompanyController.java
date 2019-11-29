package com.netcracker.dragun.controller;

import com.netcracker.dragun.dto.CompanyDto;
import com.netcracker.dragun.dto.Converter;
import com.netcracker.dragun.entity.Company;
import com.netcracker.dragun.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PostMapping
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto) {
        Company company = companyService.save(Converter.fromDto(companyDto));
        return companyDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserbyId(@PathVariable Long id) {
        companyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public Company get(@PathVariable(name = "id") Long id) {
        return companyService.get(id);
    }
}
