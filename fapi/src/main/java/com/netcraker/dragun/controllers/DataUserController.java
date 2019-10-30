package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.DataUser;
import com.netcraker.dragun.service.DataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/datausers")
public class DataUserController {

    private final DataUserService dataUserService;

    @Autowired
    public DataUserController (DataUserService dataUserService){
        this.dataUserService = dataUserService;
    }
    @GetMapping
    public List<DataUser> getAll() {
        return dataUserService.getAll();
    }
    @GetMapping("/{id}")
    public DataUser get(@PathVariable(name = "id") Long id) {
        return dataUserService.get(id);
    }

    @PostMapping
    public DataUser create(@RequestBody DataUser dataUser) {
        return dataUserService.create(dataUser);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody DataUser dataUser,
                       @PathVariable(name = "id") Long id) {
        dataUserService.update(dataUser, id);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        dataUserService.delete(id);
    }
}
