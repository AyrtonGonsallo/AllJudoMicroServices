package com.Alljudo.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class GestionnaireDeConfigurationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireDeConfigurationsApplication.class, args);
	}

}
