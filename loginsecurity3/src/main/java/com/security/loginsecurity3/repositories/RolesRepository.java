package com.security.loginsecurity3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.loginsecurity3.models.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{
    
    Roles findByName(String name);
    
}
