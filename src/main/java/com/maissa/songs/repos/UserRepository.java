package com.maissa.songs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maissa.songs.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}
