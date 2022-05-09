package com.test.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableEurekaClient
public class ServiceNewsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServiceNewsApplication.class, args);
	}
	public void run(String... args) throws Exception{

		System.out.println("Tous les rest controllers ont étés exposés ...");
		
	    }

}
