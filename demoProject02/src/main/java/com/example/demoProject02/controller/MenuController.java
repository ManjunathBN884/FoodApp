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
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject02.dto.Menu;
import com.example.demoProject02.service.MenuService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {
	@Autowired
	MenuService menuService;
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}
	@GetMapping("/getMenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);
	}
	@DeleteMapping("/deleteMenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@PathVariable int  id) {
		return menuService.deleteMenu(id);
	}
	@GetMapping("/getAllMenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenu() {
		return menuService.getAllMenu();
	}
	@PutMapping("/updateMenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu,@PathVariable int id) {
		return menuService.updateMenu(menu, id);
	}
}
