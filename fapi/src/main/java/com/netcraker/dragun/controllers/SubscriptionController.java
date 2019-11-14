package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.Subscription;
import com.netcraker.dragun.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController (SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }
    @GetMapping
    public List<Subscription> getAll() {
        return subscriptionService.getAll();
    }
    @GetMapping("/{id}")
    public Subscription get(@PathVariable(name = "id") Long id) {
        return subscriptionService.get(id);
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription subscription) {
        return subscriptionService.create(subscription);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody Subscription subscription,
                       @PathVariable(name = "id") Long id) {
        subscriptionService.update(subscription, id);
    }
    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        subscriptionService.delete(id);
    }
}
