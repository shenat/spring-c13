package com.sat.web.custom.hareoas.rest;

import org.springframework.hateoas.RepresentationModel;

import com.sat.bean.Ingredient;
import com.sat.bean.Ingredient.Type;

import lombok.Getter;

public class IngredientModel extends RepresentationModel{
	
	@Getter
	private String name;
	
	@Getter
	private Type type;
	
	public IngredientModel(Ingredient ingredient) {
		this.name = ingredient.getName();
		this.type = ingredient.getType();
	}
	
	
}
