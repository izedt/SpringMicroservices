package com.minsait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//habilata el server de Eureka
public class MicroserviceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEurekaApplication.class, args);
	}

}
