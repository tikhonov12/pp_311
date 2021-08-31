package com.jm.pp_311.pp_311.service.impl;

import com.jm.pp_311.pp_311.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jm.pp_311.pp_311.repository.RoleRepository;
import com.jm.pp_311.pp_311.service.RoleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super();
        this.roleRepository = roleRepository;
    }

    @Override
    public Role addRole(Role user) {
        return roleRepository.save(user);
    }
    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role findByName(String name) {
        return getAllRoles().stream().filter(s->s.getRoleName().equals(name)).findAny().orElse(new Role());
    }

    @Override
    public Set<Role> getAllRoles() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.addAll(roleRepository.findAll());
        return roleSet;
    }
}
