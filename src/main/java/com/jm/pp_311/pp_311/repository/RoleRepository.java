package com.jm.pp_311.pp_311.repository;


import com.jm.pp_311.pp_311.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
