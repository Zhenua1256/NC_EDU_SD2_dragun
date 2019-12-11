package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.BillingAccount;
import com.netcracker.dragun.entity.Product;
import com.netcracker.dragun.entity.Subscription;
import com.netcracker.dragun.repository.BillingAccountRepository;
import com.netcracker.dragun.repository.ProductRepository;
import com.netcracker.dragun.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BillingService {

    private final BillingAccountRepository billingAccountRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BillingService(BillingAccountRepository billingAccountRepository,
                          SubscriptionRepository subscriptionRepository,
                          ProductRepository productRepository) {
        this.billingAccountRepository = billingAccountRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.productRepository = productRepository;
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void Billing(){
        List<Subscription> sub = subscriptionRepository.findAll();
        if(sub.size() != 0) {
            for (int i = 0; i < sub.size(); i++) {
                Product product = sub.get(i).getProductId();
                Long billingAccountCompanyId = product.getCompanyId();
                Long billingAccountId = sub.get(i).getBillingAccountId();
                BillingAccount billingAccount = billingAccountRepository.findById(billingAccountId).orElse(null);
                if(billingAccount.getBalance()<= 0 || sub.get(i).getStatus() == false ){
                    sub.get(i).setStatus(false);
                } else {
                billingAccount.setBalance(billingAccount.getBalance() - product.getPrice());
                BillingAccount billingAccountCompany = billingAccountRepository.findById(billingAccountCompanyId).orElse(null);
                billingAccountCompany.setBalance(billingAccountCompany.getBalance() + product.getPrice());
                billingAccountRepository.save(billingAccount);
                billingAccountRepository.save(billingAccountCompany);
                }
            }
        }
    }
}
