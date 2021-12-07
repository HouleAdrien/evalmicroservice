package com.ynov.b3info.eval.servicelivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class ServiceLivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLivreApplication.class, args);
	}

}
