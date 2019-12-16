package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Subscription;
import com.netcracker.dragun.repository.SubscriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription get(Long id) {
        return subscriptionRepository.findById(id).get();
    }

    public ResponseEntity<Subscription> save(Subscription subscription) {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        for (Subscription subscription1 : subscriptions) {
            if (subscription1.getUserId().equals(subscription.getUserId()) &&
                    subscription1.getProduct().getId().equals(subscription.getProduct().getId())) {
                return new ResponseEntity<>(subscription, HttpStatus.BAD_REQUEST);
            }
        }
        Subscription createSubscription = subscriptionRepository.save(subscription);
        return new ResponseEntity<>(createSubscription, HttpStatus.OK);
    }

    public List<Subscription> getSubscriptionUser(Long id) {
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

    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }
}
