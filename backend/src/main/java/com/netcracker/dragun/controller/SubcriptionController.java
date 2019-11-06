package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.Subcription;
import com.netcracker.dragun.service.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/subcription")
public class SubcriptionController {

    private  final SubcriptionService subcriptionService;

    @Autowired
     public SubcriptionController(SubcriptionService subcriptionService){
         this.subcriptionService = subcriptionService;
     }
     @GetMapping
    public List<Subcription> getAll(){
         return subcriptionService.getAll();
     }
     @GetMapping(value = "/{id}")
     public Subcription get (@PathVariable(name = "id")Long id ){
         return subcriptionService.get(id);
     }

}
