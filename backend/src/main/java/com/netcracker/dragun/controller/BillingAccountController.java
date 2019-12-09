package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.BillingAccount;
import com.netcracker.dragun.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/billingaccount")
public class BillingAccountController {
    private final BillingAccountService billingAccountService;

    @Autowired
    public BillingAccountController (BillingAccountService billingAccountService){
        this.billingAccountService = billingAccountService;
    }
    @PostMapping
    public BillingAccount createBillingAccount (@RequestBody BillingAccount billingAccount){
        return billingAccountService.save(billingAccount);
    }
    @GetMapping
    public List<BillingAccount> getAll(){
        return billingAccountService.getAll();
    }
    @GetMapping(value = "/{id}")
    public BillingAccount get (@PathVariable(name = "id") Long id){
        return billingAccountService.get(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void refill(@PathVariable Long id, @RequestBody String amount) {
        billingAccountService.refill(id, amount);
    }
    @GetMapping("/baByUserId/{id}")
    public List<BillingAccount> getAllByUser(@PathVariable Long id) {
        return billingAccountService.getAllByUser(id);
    }
}
