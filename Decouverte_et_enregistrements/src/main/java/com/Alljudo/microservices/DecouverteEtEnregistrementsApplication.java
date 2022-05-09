package com.Alljudo.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DecouverteEtEnregistrementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecouverteEtEnregistrementsApplication.class, args);
	}

}
