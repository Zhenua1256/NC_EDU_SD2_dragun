package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.User;
import com.netcracker.dragun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }
}
