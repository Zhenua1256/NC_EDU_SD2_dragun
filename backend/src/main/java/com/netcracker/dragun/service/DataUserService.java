package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.repository.DataUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataUserService {

    private final DataUserRepository dataUserRepository;

    public DataUserService(DataUserRepository dataUserRepository) {
        this.dataUserRepository = dataUserRepository;
    }

    public DataUser get(Long id) {
        return dataUserRepository.findById(id).get();
    }

    public List<DataUser> getAll() {
        return dataUserRepository.findAll();
    }
}
