package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.SubcriptionTypes;
import com.netcraker.dragun.service.SubcriptionTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcriptionstypes")
public class SubcriptionTypesController {
    private final SubcriptionTypesService subcriptionTypesService;

    @Autowired
    public SubcriptionTypesController (SubcriptionTypesService subcriptionTypesService){
        this.subcriptionTypesService = subcriptionTypesService;
    }
    @GetMapping
    public List<SubcriptionTypes> getAll() {
        return subcriptionTypesService.getAll();
    }
    @GetMapping("/{id}")
    public SubcriptionTypes get(@PathVariable(name = "id") Long id) {
        return subcriptionTypesService.get(id);
    }

    @PostMapping
    public SubcriptionTypes create(@RequestBody SubcriptionTypes subcriptionTypes) {
        return subcriptionTypesService.create(subcriptionTypes);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody SubcriptionTypes subcriptionTypes,
                       @PathVariable(name = "id") Long id) {
        subcriptionTypesService.update(subcriptionTypes, id);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        subcriptionTypesService.delete(id);
    }
}
