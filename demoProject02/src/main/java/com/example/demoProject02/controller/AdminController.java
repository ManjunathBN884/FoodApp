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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.repository.Repository_Admin;
import com.example.demoProject02.service.AdminService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@PathVariable int id) {
		return adminService.deleteAdmin(id);
	}

	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin, @PathVariable int id) {
		return updateAdmin(admin, id);
	}

	@GetMapping("/getAllAdmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	@PostMapping("/login")
	public Admin get(@RequestBody Admin admin) throws Exception {
		return adminService.getEmailnPass(admin);
	}
}
