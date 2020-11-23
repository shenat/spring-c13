package com.sat.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.sat"})
//@EnableJpaRepositories(basePackages = "com.sat")
@EntityScan(basePackages = "com.sat")
@SpringBootApplication
public class ServiceRegisterNetflixEurekaC131Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisterNetflixEurekaC131Application.class, args);
	}

}
