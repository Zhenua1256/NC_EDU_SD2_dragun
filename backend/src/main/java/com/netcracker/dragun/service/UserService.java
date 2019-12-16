package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.entity.User;
import com.netcracker.dragun.repository.DataUserRepository;
import com.netcracker.dragun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;/*
    private final DataUserRepository dataUserRepository;*/

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public ResponseEntity<User> save(User user) {
        List<String> logins;
        logins = userRepository.findAllLogin();
        for (String login: logins) {
            if (login.equals(user.getDataUser().getLogin())){
                return new ResponseEntity<>(user , HttpStatus.BAD_REQUEST);
            }
        }
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser , HttpStatus.OK);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
