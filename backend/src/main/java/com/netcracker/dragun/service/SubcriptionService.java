package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Subcription;
import com.netcracker.dragun.repository.SubcriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcriptionService {
    private final SubcriptionRepository SubcriptionRepository;
    public SubcriptionService (SubcriptionRepository SubcriptionRepository) {
        this.SubcriptionRepository = SubcriptionRepository;
    }
    public Subcription get(Long id){
        return SubcriptionRepository.findById(id).get();
    }
    public List<Subcription> getAll(){
        return SubcriptionRepository.findAll();
    }
}
