package com.sat.restTemplate.consum;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Profile("rest")
@Controller
@RequestMapping("/ingredients")
public class IngredientRestController {
	
	private IngredientRestServiceClient client;
	
	public IngredientRestController(IngredientRestServiceClient client) {
		this.client = client;
	}
	
	@GetMapping
	public String ingredientList(Model model) {
		model.addAttribute("ingredients", client.getAllIngredients());
		return "ingredientList";
	}
	
	@GetMapping("/{id}")
	public String ingredientDetailPage(@PathVariable("id") String id,Model model) {
		model.addAttribute("ingredient", client.getIngredientById(id));
		return "ingredientDetail";
	}
}
