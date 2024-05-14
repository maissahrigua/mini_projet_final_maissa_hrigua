package com.maissa.songs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maissa.songs.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}