package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.Login;
import com.netcracker.dragun.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {
    private final LoginService LoginService;

    public LoginController(LoginService LoginService) {
        this.LoginService = LoginService;
    }

    @GetMapping
    public List<Login> getAll() {
        return LoginService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Login get(@PathVariable(name = "id") Long id) {
        return LoginService.get(id);
    }
}
