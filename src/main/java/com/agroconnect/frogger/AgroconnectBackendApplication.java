package com.agroconnect.frogger;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AgroconnectBackendApplication {

	public static void main(String[] args) {
		// Load environment variables from the .env file
		Dotenv dotenv = Dotenv.load();

		// You can optionally print the values to verify that they are loaded correctly
		System.out.println("DB URL: " + dotenv.get("DB_URL"));
		System.out.println("DB Username: " + dotenv.get("DB_USERNAME"));
		System.out.println("DB Password: " + dotenv.get("DB_PASSWORD"));

		// Run Spring Boot application
		SpringApplication.run(AgroconnectBackendApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
