package com.example.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import security.PasswordManager;

@SpringBootApplication
public class UsersApplication {

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public PasswordManager passwordManager() {
		return new PasswordManager();
	}
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
