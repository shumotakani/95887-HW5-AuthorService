package edu.shuwang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import edu.shuwang.SeedData;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class AuthorApplication {

	@Autowired
    private SeedData seedData;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorApplication.class, args);
	}
}
