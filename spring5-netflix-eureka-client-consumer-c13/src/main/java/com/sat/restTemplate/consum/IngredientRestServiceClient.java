package com.sat.restTemplate.consum;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sat.domain.Ingredient;

/**
 * 
 * @ClassName: IngredientServiceClient
 * @Description: 消费注册服务，采用负载均衡的RestTemplate的形式
 * @author: sat
 * @date: 2020年11月19日 下午4:10:06
 * @param:
 */
@Profile("rest")
@Service
public class IngredientRestServiceClient {
	
	private RestTemplate restTemplate;
//	private Traverson traverson;
	
	
	//将负载均衡的reatTemplate引入进来
	public IngredientRestServiceClient(@LoadBalanced RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
//	public IngredientServiceClient(Traverson traverson) {
//		this.traverson = traverson;
//	}
//	
//	public Iterable<Ingredient> getAllIngredients(){
//		//spring框架实现的从在运行是捕获泛型,返回为集合的时候需要用到这个,注意大括号
//		ParameterizedTypeReference<CollectionModel<Ingredient>> ingredientType = 
//				new ParameterizedTypeReference<CollectionModel<Ingredient>>() {};
//		//follow就是hareoas rest中的rel名称
//		CollectionModel<Ingredient> ingredientModels = 
//				traverson.follow("ingredients").toObject(ingredientType);
//		Collection<Ingredient> ingredients = ingredientModels.getContent();
//		return ingredients;
//	}
	
	public Ingredient getIngredientById(String ingredientId) {
		//注意这里的uri是用的注册服务名ingredient-api替代服务基础路径
		return restTemplate.getForObject("http://ingredient-api/ingredients/{id}",
				Ingredient.class,ingredientId);
	}
	
	public Iterable<Ingredient> getAllIngredients(){
		Ingredient[] ingredients = restTemplate.getForObject("http://ingredient-api/ingredients",
				Ingredient[].class);
		return Arrays.asList(ingredients);
	}
	
	
	
	
	
}
