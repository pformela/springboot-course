package com.example.securitydemo.dao;

import com.example.securitydemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findRoleByName(String roleEmployee);
}
