package com.example.Kiemtragiuaki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Kiemtragiuaki.model.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
