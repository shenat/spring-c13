package com.sat.web.custom.hareoas.rest;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.sat.bean.Taco;
import com.sat.data.interfaces.TacoRepository;

@RepositoryRestController
//@RequestMapping(path="/tacos", 
//				produces="application/hal+json") //只处理accept是json的请求，多个值隔开
@CrossOrigin(origins="*")//允许那些地址可以跨域请求这个服务，这里是任何地址都可以
public class TacoRestController {
	private TacoRepository tacoRepo;
	
	
//	EntityLinks entityLinkl;
	
	public TacoRestController(TacoRepository tacoRepo) {
		this.tacoRepo = tacoRepo;
	}
	
	/**
	 * 查找资源
	 */
	
	//与此相关注解还有个@Relation实在model类上的，指定json中数据名称
	//注意这边请求路径的/tacos/,因为data-rest自动生成的Repository API的路径加了实体类在路径中的
	@GetMapping("/tacos/recent")
	public ResponseEntity<CollectionModel<TacoModel>> recentTacos(){
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		List<Taco> tacos = tacoRepo.findAll(page).getContent();
		
		//toCollectionModel方法会循环所有的Taco对象，调用我们在TacoModelAssembler中重写的toModel()方法来创建TacoModel对象的列表。
		CollectionModel<TacoModel> tacoCollectionModel = 
				new TacoModelAssembler().toCollectionModel(tacos);
		//这种方法其实不是标准的hateoas，它少了本身的数据url
		//这里写这个就是一个完整的hateoas响应了，里面有recents的一个自身链接
		tacoCollectionModel.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TacoRestController.class).recentTacos())
				 	.withRel("recents"));
		return new ResponseEntity<>(tacoCollectionModel, HttpStatus.OK);
	}
	
	
}
