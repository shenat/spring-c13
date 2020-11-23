package com.sat.config;

import java.net.URI;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;

//由于需要消费的API是hateoas类型，即超媒体自适应API,则消费的时候需要用到Traverson
@Configuration
@Profile("traverson")
public class TraversonConfig {

	@Bean
	public Traverson traverson() {
		return new Traverson(URI.create("http://ingredient-api/api"), MediaTypes.HAL_JSON);
	}
}
