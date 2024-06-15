package com.example.Kiemtragiuaki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Kiemtragiuaki.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}
