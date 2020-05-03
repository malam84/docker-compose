package com.docker.compose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.compose.bean.Role;

/**
 * 
 * @author    Alam    
 * @2020
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
