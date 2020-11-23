package com.sat.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Profile("rest")
@Configuration
public class RestTemplateConfig {
	
	
	//配置注册服务消费者之查找服务第一种方式
	@Profile("rest")
	@Bean
	@LoadBalanced//负载均衡的RestTemplate
	public RestTemplate restTemplare() {
		return new RestTemplate();
	}
	
}
