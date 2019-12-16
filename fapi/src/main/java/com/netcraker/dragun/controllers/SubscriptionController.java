package com.netcraker.dragun.controllers;

import com.netcraker.dragun.converter.SubscriptionConverter;
import com.netcraker.dragun.converter.SubscriptionDto;
import com.netcraker.dragun.model.Subscription;
import com.netcraker.dragun.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriptions")
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

    @GetMapping("/{id}")
    public Subscription get(@PathVariable(name = "id") Long id) {
        return subscriptionService.get(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SubscriptionDto subscriptionDto) {
        SubscriptionConverter subscriptionConverter = new SubscriptionConverter();
        return subscriptionService.create(subscriptionConverter.fromDto(subscriptionDto));

    }

    @GetMapping("/unsubscribe/{id}")
    public Subscription unSubscribe(@PathVariable(name = "id") Long id) {
        return subscriptionService.unSubscribe(id);
    }

    @GetMapping("/subscribe/{id}")
    public Subscription onSubscribe(@PathVariable(name = "id") Long id) {
        return subscriptionService.onSubscribe(id);
    }

    @GetMapping("/user/{id}")
    public List<SubscriptionDto> getSubscriptionUser(@PathVariable(name = "id") Long id) {
        SubscriptionConverter subscriptionConverter = new SubscriptionConverter();
        return subscriptionConverter.toListDto(subscriptionService.getSubscriptionUser(id));
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
