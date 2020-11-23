package com.sat.feign.consum;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sat.domain.Ingredient;

@Profile("feign")
@FeignClient("ingredient-api")//消费服务的注册名称
public interface IngredientFeignClient {
	@GetMapping("/ingredients/{id}")
	Ingredient getIngredient(@PathVariable("id") String id);
	
	@GetMapping("/ingredients")
	Iterable<Ingredient> getAllIngredients();
}
