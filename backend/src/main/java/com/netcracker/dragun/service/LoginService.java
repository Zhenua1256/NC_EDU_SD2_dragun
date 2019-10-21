package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Login;
import com.netcracker.dragun.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LoginService {

    private final LoginRepository LoginRepository;

    public LoginService (LoginRepository LoginRepository) {
        this.LoginRepository = LoginRepository;
    }
    public Login get(Long id) {
        return LoginRepository.findById(id).get();
    }
    public List<Login> getAll() {
        return LoginRepository.findAll();
    }
}
