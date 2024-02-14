package com.security.loginsecurity3.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.loginsecurity3.models.Roles;
import com.security.loginsecurity3.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    
    Optional<Users> findByEmail(String email);
    
    Users findByRoleId(long idRole);
}
