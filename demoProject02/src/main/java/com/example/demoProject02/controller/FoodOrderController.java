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

import com.example.demoProject02.dto.FoodOrder;
import com.example.demoProject02.service.FoodOrderService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodOrderController {
	@Autowired
	FoodOrderService foodOrderService;
@PostMapping("/saveFoodOrder")
public ResponseEntity<ResponseStructure<FoodOrder>> saveoOrder(@RequestBody  FoodOrder order) {
	return foodOrderService.saveFoodOrder(order);
}

@GetMapping("/getFoodOrder/{id}")
public ResponseEntity<ResponseStructure<FoodOrder>> getOrderById(@PathVariable  int id) {
	return foodOrderService.getFoodOrderById(id);
}

@DeleteMapping("/deleteFoodOrder/{id}")
public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@PathVariable int id) {
	return foodOrderService.deleteFoodOrder(id);
}

@PutMapping("/updateFoodOrder/{id}")
public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder order,@PathVariable int id) {
	return foodOrderService.updateFoodOrder(order, id);
}

@GetMapping("/getAllFoodOrder")
public ResponseEntity<ResponseStructure<List<FoodOrder>>> getAllFoodOrder() {
	return foodOrderService.getAllFoodOrder();
}

}
