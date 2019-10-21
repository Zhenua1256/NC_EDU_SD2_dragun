package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.SubscriptionTypes;
import com.netcracker.dragun.repository.SubscriptionTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypesService {

    private final SubscriptionTypesRepository SubscriptionTypesRepository;

    public SubscriptionTypesService (SubscriptionTypesRepository SubscriptionTypesRepository){
        this.SubscriptionTypesRepository = SubscriptionTypesRepository;
    }

    public SubscriptionTypes get(Long id){
        return SubscriptionTypesRepository.findById(id).get();
    }
    public List<SubscriptionTypes> getAll(){
        return SubscriptionTypesRepository.findAll();
    }
}
