package com.sat.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

//feign不会自动装配，所以要添加注解到配置类上
@Profile("feign")
@EnableFeignClients("com.sat")//注意这边一定要加feign接口所在的包
@Configuration
@Slf4j
public class FeignConfig {
	 @Bean
	  public CommandLineRunner startup() {
	    return args -> {
	      log.info("**************************************");
	      log.info("        Configuring with Feign");
	      log.info("**************************************");
	    };
	  }
}