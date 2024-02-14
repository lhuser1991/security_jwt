package com.security.loginsecurity3;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.loginsecurity3.models.Roles;
import com.security.loginsecurity3.models.Users;
import com.security.loginsecurity3.repositories.UsersRepository;

@SpringBootApplication
public class Loginsecurity3Application implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(Loginsecurity3Application.class, args);

		// SecureRandom random = new SecureRandom();
        // byte[] keyBytes = new byte[32]; // 256 bits (32 bytes) is a common choice for HMAC-SHA256
        // random.nextBytes(keyBytes);
        
        // String secretKey = Base64.getEncoder().encodeToString(keyBytes);
        // System.out.println("Generated SECRET_KEY : " + secretKey);
	}

    public void run(String... args) {
        Users adminAccount = usersRepository.findByRole(Roles.ADMIN);
        if(adminAccount == null) {
            Users users = new Users();
            users.setEmail("admin@monmail.com");
            users.setFirstname("admin");
            users.setSecondname("admin");
            users.setRole(Roles.ADMIN);
            users.setPassword(new BCryptPasswordEncoder().encode("admin"));
            usersRepository.save(users);
        }
    }

}
