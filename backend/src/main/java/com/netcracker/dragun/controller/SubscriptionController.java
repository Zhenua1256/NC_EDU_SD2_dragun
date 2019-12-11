package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.Subscription;
import com.netcracker.dragun.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<Subscription> getAll() {
        return subscriptionService.getAll();
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    @GetMapping(value = "/user/{id}")
    public List<Subscription> getSubscriptionUser(@PathVariable(name = "id")Long id){
        return subscriptionService.getSubscriptionUser(id);
    }
    @GetMapping(value = "/unsubscribe/{id}")
    public Subscription unSubscribe(@PathVariable(name = "id") Long id){
        return subscriptionService.unSubscribe(id);
    }
    @GetMapping(value = "/onsubscribe/{id}")
    public Subscription onSubscribe(@PathVariable(name = "id") Long id){
        return subscriptionService.onSubscribe(id);
    }
    @GetMapping(value = "/{id}")
    public Subscription get(@PathVariable(name = "id") Long id) {
        return subscriptionService.get(id);
    }
}
