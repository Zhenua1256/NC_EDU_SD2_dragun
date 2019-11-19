package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.BillingAccount;
import com.netcracker.dragun.repository.BillingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingAccountService {
    private final BillingAccountRepository billingAccountRepository;

    @Autowired
    public BillingAccountService (BillingAccountRepository billingAccountRepository){
        this.billingAccountRepository = billingAccountRepository;
    }

    public BillingAccount get(Long id)
    {
        return billingAccountRepository.findById(id).get();
    }
    public BillingAccount save (BillingAccount billingAccount) {
        return billingAccountRepository.save(billingAccount);
    }
    public List<BillingAccount> getAll(){
        return billingAccountRepository.findAll();
    }
}
