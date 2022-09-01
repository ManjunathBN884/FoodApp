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

import com.example.demoProject02.dto.Branch;
import com.example.demoProject02.service.BranchService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BranchController {
	@Autowired
	BranchService branchService;
@PostMapping("/saveBranch")
public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody  Branch branch) {
	return branchService.saveBranch(branch);
}

@GetMapping("/getbranch/{id}")
public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable  int id) {
	return branchService.getBranchById(id);
}

@DeleteMapping("/deleteBranch/{id}")
public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int id) {
	return branchService.deleteBranch(id);
}

@PutMapping("/updateBranch/{id}")
public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@PathVariable int id) {
	return branchService.updateBranch(branch, id);
}

@GetMapping("/getAllBranch")
public ResponseEntity<ResponseStructure<List<Branch>>> getAllABranch() {
	return branchService.getAllBranch();
}
}
