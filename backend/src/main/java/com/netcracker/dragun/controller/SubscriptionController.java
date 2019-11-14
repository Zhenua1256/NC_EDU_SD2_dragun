package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.Subscription;
import com.netcracker.dragun.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/subcription")
public class SubscriptionController {

    private  final SubscriptionService subscriptionService;

     @Autowired
     public SubscriptionController(SubscriptionService subscriptionService){
         this.subscriptionService = subscriptionService;
     }
     @GetMapping
     public List<Subscription> getAll(){
         return subscriptionService.getAll();
     }
     @PostMapping
     public Subscription createSubscription (@RequestBody Subscription subscription){
        return subscriptionService.save(subscription);
     }
     @GetMapping(value = "/{id}")
     public Subscription get (@PathVariable(name = "id")Long id ){
         return subscriptionService.get(id);
     }
}
