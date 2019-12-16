package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataUserRepository extends JpaRepository<DataUser, Long> {
    DataUser findDataUserByLogin (String login);
}
