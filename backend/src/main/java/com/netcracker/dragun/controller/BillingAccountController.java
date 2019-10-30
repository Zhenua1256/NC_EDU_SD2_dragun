package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.BillingAccount;
import com.netcracker.dragun.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/billingaccounts")
public class BillingAccountController {
    private final BillingAccountService BillingAccountService;

    @Autowired
    public BillingAccountController (BillingAccountService BillingAccountService){
        this.BillingAccountService = BillingAccountService;
    }
    @GetMapping
    public List<BillingAccount> getAll(){
        return BillingAccountService.getAll();
    }
    @GetMapping(value = "/{id}")
    public BillingAccount get (@PathVariable(name = "id") Long id){
        return BillingAccountService.get(id);
    }
}
