package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.service.DataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/datausers")
public class DataUserController {
    private final DataUserService dataUserService;

    @Autowired
    public DataUserController(DataUserService dataUserService) {
        this.dataUserService = dataUserService;
    }

    @GetMapping
    public List<DataUser> getAll() {
        return dataUserService.getAll();
    }

    @GetMapping(value = "/{id}")
    public DataUser get(@PathVariable(name = "id") Long id) {
        return dataUserService.get(id);
    }
}
