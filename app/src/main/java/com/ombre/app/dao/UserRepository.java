package com.ombre.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ombre.app.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}