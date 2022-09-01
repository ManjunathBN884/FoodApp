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
import com.example.demoProject02.dto.Staff;
import com.example.demoProject02.service.StaffService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
public class StaffController {
	@Autowired
	StaffService service;
	@PostMapping("/saveStaff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}
	@GetMapping("/getstaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@PathVariable int id) {
		return service.getStaffById(id);
	}
	@DeleteMapping("/deletestaffByid/{id}")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@PathVariable int id) {
		return service.deleteStaff(id);
	}
	@GetMapping("/getAllStaff")
	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaffs() {
		return service.getAllStaffs();
	}
	@PutMapping("/updatestaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff,@PathVariable int id) {
		return service.updateStaff(staff, id);
	}
	@PostMapping("/loginStaff")
	public Staff getstaff(@RequestBody Staff staff) throws Exception {
		return service.getEmailnPass(staff);
	}
	
}
