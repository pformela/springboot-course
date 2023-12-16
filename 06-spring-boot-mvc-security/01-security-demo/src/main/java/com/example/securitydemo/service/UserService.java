package com.example.securitydemo.service;

import com.example.securitydemo.entity.User;
import com.example.securitydemo.model.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);

    void save(WebUser webUser);
}
