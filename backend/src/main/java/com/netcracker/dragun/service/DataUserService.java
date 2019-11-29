package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.DataUser;
import com.netcracker.dragun.repository.DataUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DataUserService {

    private final DataUserRepository DataUserRepository;

    public DataUserService(DataUserRepository DataUserRepository) {
        this.DataUserRepository = DataUserRepository;
    }

    public DataUser get(Long id) {
        return DataUserRepository.findById(id).get();
    }


    public List<DataUser> getAll() {
        return DataUserRepository.findAll();
    }
}
