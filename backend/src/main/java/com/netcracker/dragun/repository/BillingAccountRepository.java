package com.netcracker.dragun.repository;


import com.netcracker.dragun.entity.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long> {
    @Query(value = "select * from billingaccounts where user_id = ? order by id", nativeQuery = true)
    List<BillingAccount> findBillingAccountsByUserId(Long id);
    @Query(value = "select * from billingaccounts where company_id = ? order by id", nativeQuery = true)
    List<BillingAccount> findBillingAccountsByCompanyId(Long id);
    @Query(value = "select * from billingaccounts where id = ? order by id", nativeQuery = true)
    BillingAccount findBillingAccountById(Long id);
    @Query(value = "select * from billingaccounts where id = ? order by id", nativeQuery = true)
    BillingAccount findBillingAccountByCompanyId (Long id);
}
