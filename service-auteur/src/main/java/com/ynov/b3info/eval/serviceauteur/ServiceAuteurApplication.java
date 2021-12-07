package com.ynov.b3info.eval.serviceauteur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class ServiceAuteurApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAuteurApplication.class, args);
	}

}