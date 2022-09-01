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

import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.BranchManager;
import com.example.demoProject02.service.BranchManagerService;
import com.example.demoProject02.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BranchManagerController {
	@Autowired
	BranchManagerService branchService;

	@PostMapping("/saveBranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranch(@RequestBody BranchManager branch) {
		return branchService.saveBranchManager(branch);
	}

	@GetMapping("/getbranchManager/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}

	@DeleteMapping("/deleteBranchManager/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranch(@PathVariable int id) {
		return branchService.deleteBranchManager(id);
	}

	@PutMapping("/updateBranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranch(@RequestBody BranchManager branch,
			@RequestParam int id) {
		return branchService.updateBranch(branch, id);
	}

	@GetMapping("/getAllBranchManager")
	public ResponseEntity<ResponseStructure<List<BranchManager>>> getAllABranch() {
		return branchService.getAllBranch();
	}
	
	@PostMapping("/loginManager")
	public BranchManager get(@RequestBody BranchManager manager) throws Exception {
		return branchService.getEmailnPass(manager);
	}
}
