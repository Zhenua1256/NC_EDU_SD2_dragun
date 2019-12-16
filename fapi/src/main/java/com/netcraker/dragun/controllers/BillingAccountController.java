package com.netcraker.dragun.controllers;

import com.netcraker.dragun.converter.BillingAccountConverter;
import com.netcraker.dragun.model.BillingAccount;
import com.netcraker.dragun.service.BillingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/billingaccount")
public class BillingAccountController {
    private final BillingAccountService billingAccountService;
    private final BillingAccountConverter billingAccountConverter;

    @GetMapping
    public List<BillingAccount> getAll() {
        return billingAccountService.getAll();
    }

    @GetMapping("/{id}")
    public BillingAccount get(@PathVariable(name = "id") Long id) {
        return billingAccountService.get(id);
    }

    /*@PostMapping
    public BillingAccount create(@RequestBody BillingAccount billingAccount) {
        BillingAccountDto billingAccountDto = billingAccountConverter.converterBillingAccountToDto(billingAccount);
        return billingAccountConverter.converterBillingAccountFromDto(billingAccountService.create(billingAccountDto));
    }*/
    @PostMapping
    public BillingAccount create(@Valid @RequestBody BillingAccount billingAccount) {
        return billingAccountService.create(billingAccount);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody BillingAccount billingAccount,
                       @PathVariable(name = "id") Long id) {
        billingAccountService.update(billingAccount, id);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        billingAccountService.delete(id);
    }

    @PostMapping(value = "/{id}")
    public void refillWallet(@PathVariable Long id,@Valid @RequestBody String amount) {
        billingAccountService.refill(id, amount);
    }

    @RequestMapping(value = "/ba-user/{id}")
    public List<BillingAccount> getAllByUser(@PathVariable Long id){
       return billingAccountService.getAllByUser(id);
    }

    @RequestMapping(value = "/ba-company/{id}")
    public List<BillingAccount> getAllByCompany(@PathVariable Long id){
        return billingAccountService.getAllByCompany(id);
    }
}
