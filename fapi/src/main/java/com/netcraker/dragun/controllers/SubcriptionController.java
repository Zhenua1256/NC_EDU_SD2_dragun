package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.Subcription;
import com.netcraker.dragun.service.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcriptions")
public class SubcriptionController {
    private final SubcriptionService subcriptionService;

    @Autowired
    public SubcriptionController (SubcriptionService subcriptionService){
        this.subcriptionService = subcriptionService;
    }
    @GetMapping
    public List<Subcription> getAll() {
        return subcriptionService.getAll();
    }
    @GetMapping("/{id}")
    public Subcription get(@PathVariable(name = "id") Long id) {
        return subcriptionService.get(id);
    }

    @PostMapping
    public Subcription create(@RequestBody Subcription subcription) {
        return subcriptionService.create(subcription);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody Subcription subcription,
                       @PathVariable(name = "id") Long id) {
        subcriptionService.update(subcription, id);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        subcriptionService.delete(id);
    }
}
