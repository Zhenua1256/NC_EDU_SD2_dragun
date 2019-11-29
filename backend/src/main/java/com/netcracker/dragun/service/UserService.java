package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.entity.User;
import com.netcracker.dragun.repository.DataUserRepository;
import com.netcracker.dragun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;
    private final DataUserRepository dataUserRepository;

    @Autowired
    public UserService(UserRepository UserRepository, DataUserRepository dataUserRepository) {
        this.userRepository = UserRepository;
        this.dataUserRepository = dataUserRepository;
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public DataUser getByLogin(String login) {
        return dataUserRepository.findDataUserByLogin(login);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
