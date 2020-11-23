package com.sat.web.common.rest;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sat.bean.Ingredient;
import com.sat.component.IpConfiguration;
import com.sat.data.interfaces.IngredientRepository;

import lombok.Data;

@RestController
@RequestMapping(path="/ingredients", produces="application/json")
@CrossOrigin(origins="*")
public class IngredientController {

  private IngredientRepository repo;

  @Autowired
  public IngredientController(IngredientRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public Iterable<Ingredient> allIngredients() {
	System.out.println("Port:" + IpConfiguration.getPort());
    return repo.findAll();
  }
  
  @GetMapping("/{id}")
  public Optional<Ingredient> byId(@PathVariable String id) {
    return repo.findById(id);
  }
  
  @PutMapping("/{id}")
  public void updateIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
    if (!ingredient.getId().equals(id)) {
      throw new IllegalStateException("Given ingredient's ID doesn't match the ID in the path.");
    }
    repo.save(ingredient);
  }
  
  @PostMapping
  public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient ingredient) {
    Ingredient saved = repo.save(ingredient);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(URI.create("http://localhost:"+IpConfiguration.getPort()+"/ingredients/" + ingredient.getId()));
    return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/{id}")
  public void deleteIngredient(@PathVariable String id) {
    repo.deleteById(id);
  }
  
}
