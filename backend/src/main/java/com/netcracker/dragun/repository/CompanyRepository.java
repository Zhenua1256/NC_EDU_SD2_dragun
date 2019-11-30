package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    Company findCompanyByDataUser_Login(String login);
}
