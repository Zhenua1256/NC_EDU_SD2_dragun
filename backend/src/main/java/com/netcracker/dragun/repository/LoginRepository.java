package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login , Long> {
}
