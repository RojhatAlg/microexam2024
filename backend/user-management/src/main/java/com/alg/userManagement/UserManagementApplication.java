package com.alg.userManagement;

import com.alg.userManagement.model.Users;
import com.alg.userManagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementApplication {
	private final UserRepository userRepository;

	public UserManagementApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData() {
		return args -> {
			// Create admin users if none exist
			Users admin1 = new Users(null, "admin1@example.com", "admin1password", "admin");
			Users admin2 = new Users(null, "admin2@example.com", "admin2password", "admin");
			userRepository.save(admin1);
			userRepository.save(admin2);
			System.out.println("Admin users created successfully.");
		};
	}
}
