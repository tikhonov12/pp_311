package com.jm.pp_311.service;

import com.jm.pp_311.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;


public interface UserService extends UserDetailsService {
    User addUser(User role);

    void deleteById(Long id);

    User findById(Long id);

    User findByName(String name);

    Set<User> getAllUsers();

    void updateUser(User user, Long id, String role);

}
