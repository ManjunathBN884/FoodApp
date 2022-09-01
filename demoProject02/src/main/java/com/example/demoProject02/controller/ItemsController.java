package com.example.demoProject02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject02.dto.Items;
import com.example.demoProject02.service.ItemService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
public class ItemsController {
@Autowired
ItemService itemService;
@PostMapping("/saveItems")
public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
	return itemService.saveItems(items);
}
@GetMapping("/getItem")
public ResponseEntity<ResponseStructure<Items>> getItemssById(int id) {
	return itemService.getItemssById(id);
}
@DeleteMapping("/deleteItem/{id}")
public ResponseEntity<ResponseStructure<Items>> deleteItem(@PathVariable int id) {
	return itemService.deleteItem(id);
}
@GetMapping("/getAllItem")
public ResponseEntity<ResponseStructure<List<Items>>> getAllItems() {
	return itemService.getAllItems();
}
@PutMapping("/updateItem")
public ResponseEntity<ResponseStructure<Items>> updateItems(Items items,int id) {
	return itemService.updateItems(items, id);
}
}
