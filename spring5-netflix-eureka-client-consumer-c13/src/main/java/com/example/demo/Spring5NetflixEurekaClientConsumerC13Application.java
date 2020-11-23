package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.sat"})
//@EnableJpaRepositories(basePackages = "com.sat")
@EntityScan(basePackages = "com.sat")
@SpringBootApplication
public class Spring5NetflixEurekaClientConsumerC13Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring5NetflixEurekaClientConsumerC13Application.class, args);
	}

}
