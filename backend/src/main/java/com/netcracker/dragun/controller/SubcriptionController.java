package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.Subcription;
import com.netcracker.dragun.service.SubcriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/subcription")
public class SubcriptionController {

    private  final SubcriptionService SubcriptionService;

     public SubcriptionController(SubcriptionService SubcriptionService){
         this.SubcriptionService = SubcriptionService;
     }
     @GetMapping
    public List<Subcription> getAll(){
         return SubcriptionService.getAll();
     }
     @GetMapping(value = "/{id}")
     public Subcription get (@PathVariable(name = "id")Long id ){
         return SubcriptionService.get(id);
     }

}
