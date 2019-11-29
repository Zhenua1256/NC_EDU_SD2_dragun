package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findUserByDataUser_Id(Long id);
    User findUserByDataUser_Login(String login);
}
