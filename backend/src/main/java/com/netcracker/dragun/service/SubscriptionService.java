package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Subscription;
import com.netcracker.dragun.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService (SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }
    public Subscription get(Long id){
        return subscriptionRepository.findById(id).get();
    }
    public Subscription save(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }
    public List<Subscription> getSubscriptionUser(Long id){
        return subscriptionRepository.findSubscriptionByUserId(id);
    }
    public Subscription unSubscribe(Long id) {
        Subscription subscription = subscriptionRepository.findSubscriptionById(id);
        subscription.setStatus(false);
        return subscriptionRepository.save(subscription);
    }
    public Subscription onSubscribe(Long id) {
        Subscription subscription = subscriptionRepository.findSubscriptionById(id);
        subscription.setStatus(true);
        return subscriptionRepository.save(subscription);
    }
    public List<Subscription> getAll(){
        return subscriptionRepository.findAll();
    }
}
