package com.sat.feign.consum;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Profile("feign")
@Controller
@RequestMapping("/ingredients")
public class IngredientFeignController {
	private IngredientFeignClient client;
	
	public IngredientFeignController(IngredientFeignClient client) {
		this.client = client;
	}
	
	@GetMapping
	public String ingredientList(Model model) {
		System.out.println("call feign method");
		model.addAttribute("ingredients", client.getAllIngredients());
		return "ingredientList";
	}
	
	@GetMapping("/{id}")
	public String ingredientDetailPage(@PathVariable("id") String id,Model model) {
		model.addAttribute("ingredient", client.getIngredient(id));
		return "ingredientDetail";
	}
}
