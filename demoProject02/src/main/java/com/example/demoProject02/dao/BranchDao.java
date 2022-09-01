package com.example.demoProject02.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Branch;
import com.example.demoProject02.repository.Repository_Branch;

@Repository
public class BranchDao {
	@Autowired
	Repository_Branch repository_Branch;
	
	public Branch saveBranch(Branch branch) {
		return repository_Branch.save(branch);
	}
	
	public Optional<Branch> getBranchById(int id) {
		return repository_Branch.findById(id);
	}
	
	public Branch deleteBranch(int id) {
		Branch branch=getBranchById(id).get();
		 repository_Branch.deleteById(id);
		 return branch;
	}
	
	public List<Branch> getAllBranch() {
		return repository_Branch.findAll();
	}
	
	public Branch updateBranch(Branch branch,int id) {
		if(repository_Branch.findById(id).isEmpty()) {
			return null;
		}
		else {
			branch.setId(id);
			return repository_Branch.save(branch);
		}
	}
	
}
