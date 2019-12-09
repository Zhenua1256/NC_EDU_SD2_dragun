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
    private String id = "2";

    @Autowired
    public BillingService(BillingAccountRepository billingAccountRepository,
                          SubscriptionRepository subscriptionRepository,
                          ProductRepository productRepository) {
        this.billingAccountRepository = billingAccountRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.productRepository = productRepository;
    }

    @Scheduled(cron = "0/1000 * * * * ?")
    public void Billing(){
        List<Subscription> sub = subscriptionRepository.findAll();
        for (int i = 0; i <= sub.size(); i++){
            Long productId = sub.get(i).getProductId();
            Product product = productRepository.findById(productId).get();
            Long billingAccountId = sub.get(i).getBillingAccountId();
            BillingAccount billingAccount = billingAccountRepository.findById(billingAccountId).orElse(null);
            billingAccount.setBalance(billingAccount.getBalance() - product.getPrice());
            billingAccountRepository.save(billingAccount);
        }
    }
}
