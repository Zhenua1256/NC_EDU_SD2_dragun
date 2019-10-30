package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.SubscriptionTypes;
import com.netcracker.dragun.service.SubscriptionTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/subscriptionTypes")
public class SubscriptionTypesController {
    private final SubscriptionTypesService SubscriptionTypesService;

    @Autowired
    public SubscriptionTypesController (SubscriptionTypesService SubscriptionTypesService){
        this.SubscriptionTypesService = SubscriptionTypesService;
    }

    @GetMapping
    public List<SubscriptionTypes> getALL(){
        return SubscriptionTypesService.getAll();
    }

    @GetMapping(value = "/{id}")
    public SubscriptionTypes get (@PathVariable (name = "id")Long id){
        return SubscriptionTypesService.get(id);
    }
}
