package com.sat.web.custom.hareoas.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

import com.sat.bean.Taco;

@Configuration
public class CustomHateoasRestConfig {
	
	@Bean
	public RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> tacoProcessor(EntityLinks links){
		return new RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> () {

			@Override
			public PagedModel<EntityModel<Taco>> process(PagedModel<EntityModel<Taco>> model) {
				// TODO Auto-generated method stub
				model.add(
					//意思是在tacos链接下加一个recents名的指向.../tacos/recent的链接
					links.linkFor(Taco.class)
						 .slash("recent")
						 .withRel("recents"));
				return model;
			}
			
		};
	}
}
