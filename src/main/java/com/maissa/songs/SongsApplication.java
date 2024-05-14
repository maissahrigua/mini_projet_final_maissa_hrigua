package com.maissa.songs;

import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maissa.songs.entities.Role;
import com.maissa.songs.entities.Song;
import com.maissa.songs.entities.User;
import com.maissa.songs.service.SongService;
import com.maissa.songs.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SongsApplication implements CommandLineRunner {

	@Autowired
	SongService songService;
	
	@Autowired
	PasswordEncoder BCryptPasswordEncoder;
	
	@Autowired
	UserService userService;

	
	//@Autowired
	//private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
	SpringApplication.run(SongsApplication.class, args);
	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"maissa","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	
	userService.addRoleToUser("maissa", "USER");
	userService.addRoleToUser("maissa", "AGENT");
	
	userService.addRoleToUser("user1", "USER");
	}*/
	
	
	@Override
	public void run(String... args) throws Exception {
		//repositoryRestConfiguration.exposeIdsFor(Song.class);
		
		//System.out.println("Password Encoded BCRYPT :******************** ");
		// System.out.println(BCryptPasswordEncoder.encode("123"));
	}


}
