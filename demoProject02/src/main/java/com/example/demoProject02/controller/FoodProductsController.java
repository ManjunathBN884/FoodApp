package com.example.demoProject02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoProject02.dto.FoodProducts;
import com.example.demoProject02.service.FoodProductsService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodProductsController {
	@Autowired
	FoodProductsService foodProductsService;
@PostMapping("/saveFoodProduct")
public ResponseEntity<ResponseStructure<FoodProducts>> saveProduct(@RequestBody  FoodProducts products) {
	return foodProductsService.saveFoodProducts(products);
}

@GetMapping("/getFoodProduct/{id}")
public ResponseEntity<ResponseStructure<FoodProducts>> getProductById(@PathVariable  int id) {
	return foodProductsService.getFoodProductsById(id);
}

@DeleteMapping("/deleteFoodProduct/{id}")
public ResponseEntity<ResponseStructure<FoodProducts>> deleteFoodProduct(@PathVariable int id) {
	return foodProductsService.deleteFoodProducts(id);
}

@PutMapping("/updateFoodProduct/{id}")
public ResponseEntity<ResponseStructure<FoodProducts>> updateFoodProduct(@RequestBody FoodProducts products,@PathVariable int id) {
	return foodProductsService.updateFoodProducts(products, id);
}

@GetMapping("/getAllFoodProduct")
public ResponseEntity<ResponseStructure<List<FoodProducts>>> getAllFoodProduct() {
	return foodProductsService.getAllFoodProducts();
}
}
