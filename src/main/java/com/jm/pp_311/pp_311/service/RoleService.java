package com.jm.pp_311.pp_311.service;

import com.jm.pp_311.pp_311.model.Role;

import java.util.Set;

public interface RoleService {
    Role addRole(Role role);

    void deleteById(Long id);

    Role findById(Long id);

    Role findByName(String name);

    Set<Role> getAllRoles();
}
