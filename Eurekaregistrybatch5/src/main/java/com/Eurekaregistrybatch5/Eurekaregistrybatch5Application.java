package com.Eurekaregistrybatch5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaregistrybatch5Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaregistrybatch5Application.class, args);
	}

}
