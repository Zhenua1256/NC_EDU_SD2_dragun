package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select login from datausers", nativeQuery = true)
    List<String> findAllLogin();

    User findUserByDataUser_Id(Long id);

    User findUserByDataUser_Login(String login);
}
