package com.example.spsp2.dao;


import com.example.spsp2.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String> {
    Optional<MyUser> findByUsername(String username);
}