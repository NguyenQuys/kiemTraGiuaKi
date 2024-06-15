package com.example.Kiemtragiuaki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Kiemtragiuaki.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
