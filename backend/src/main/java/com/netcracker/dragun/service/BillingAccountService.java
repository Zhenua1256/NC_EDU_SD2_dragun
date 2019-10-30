package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.BillingAccount;
import com.netcracker.dragun.repository.BillingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingAccountService {
    private final BillingAccountRepository BillingAccountRepository;

    @Autowired
    public BillingAccountService (BillingAccountRepository BillingAccountRepository){
        this.BillingAccountRepository = BillingAccountRepository;
    }
    public BillingAccount get(Long id) {
        return BillingAccountRepository.findById(id).get();
    }
    public List<BillingAccount> getAll(){
        return BillingAccountRepository.findAll();
    }
}
