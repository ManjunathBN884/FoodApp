package com.example.demoProject02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.BranchManager;
import com.example.demoProject02.repository.Repository_BranchManager;
@Repository
public class BranchManagerDao {
@Autowired
Repository_BranchManager repository_BranchManager;


public BranchManager saveBranchManager(BranchManager branch) {
	return repository_BranchManager.save(branch);
}

public BranchManager getBranchById(int id) {
	return repository_BranchManager.findById(id).get();
}

public BranchManager deleteBranchManager(int id) {
	BranchManager branch=getBranchById(id);
	 repository_BranchManager.deleteById(id);
	 return branch;
}

public List<BranchManager> getAllBranch() {
	return repository_BranchManager.findAll();
}

public BranchManager updateBranch(BranchManager branch,int id) {
	if(repository_BranchManager.findById(id).isEmpty()) {
		return null;
	}
	else {
		branch.setId(id);
		return repository_BranchManager.save(branch);
	}
}
public BranchManager findEmailnPass(BranchManager manager) throws Exception {
	String email =manager.getEmail() ;
	String password = manager.getPassword();
	BranchManager obj = null;
	if(email != null && password != null) {
		obj = repository_BranchManager.findByEmailAndPassword(email,password);
	}
	if (obj == null) {
		throw new Exception("invalid");

	}
	return obj;
}
}
