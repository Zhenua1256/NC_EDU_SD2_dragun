package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataUserRepository extends JpaRepository<DataUser, Long> {
}
