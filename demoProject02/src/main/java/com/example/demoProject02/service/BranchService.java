package com.example.demoProject02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.BranchDao;
import com.example.demoProject02.dto.Branch;
import com.example.demoProject02.exception.IdNotFound;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		structure.setMessage("Branch Created Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Optional<Branch> optional=branchDao.getBranchById(id);
		if(optional.isEmpty()) {
			throw new IdNotFound();
		}
		else {
		
		structure.setMessage("Branch Found Successfull y");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(optional.get());
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK) ;
	}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		structure.setMessage("Branch Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchDao.deleteBranch(id));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		ResponseStructure<List<Branch>> structure=new ResponseStructure<List<Branch>>();
		structure.setMessage("Branch Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchDao.getAllBranch());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.CREATED);

		}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch,int id) {
		 Branch dao=branchDao.updateBranch(branch, id);
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		if(dao!=null) {
		structure.setMessage("Branch Updated Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao);
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		}
		else {
			structure.setMessage("Branch Failed To Update Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(null);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		}

		
	}
}
