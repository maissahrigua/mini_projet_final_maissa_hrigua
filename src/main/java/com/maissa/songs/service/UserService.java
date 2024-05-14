package com.maissa.songs.service;

import com.maissa.songs.entities.Role;
import com.maissa.songs.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
