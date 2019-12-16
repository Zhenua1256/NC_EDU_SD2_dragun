package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    @Query(value = "select login from datausers", nativeQuery = true)
    List<String> findAllLogin();
    Company findCompanyByDataUser_Login(String login);
}
