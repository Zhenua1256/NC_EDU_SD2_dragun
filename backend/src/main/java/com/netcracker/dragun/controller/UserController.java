package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.User;
import com.netcracker.dragun.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping
    public List<User> getAll() {
        return UserService.getAll();
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        return UserService.get(id);
    }
}
