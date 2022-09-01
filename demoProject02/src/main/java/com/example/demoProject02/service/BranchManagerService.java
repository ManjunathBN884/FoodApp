package com.example.demoProject02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.BranchManagerDao;
import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.BranchManager;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class BranchManagerService {
	@Autowired
	BranchManagerDao branchManagerDao;
	
	public ResponseEntity <ResponseStructure<BranchManager>> saveBranchManager(BranchManager branch) {
		ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
		structure.setMessage("BranchManager created Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDao.saveBranchManager( branch));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK) ;
	}

	public ResponseEntity<ResponseStructure<BranchManager>> getBranchById(int id) {
		ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
		structure.setMessage("BranchManager Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDao.getBranchById(id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(int id) {
		ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
		structure.setMessage("BranchManager Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDao.deleteBranchManager(id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<List<BranchManager>>> getAllBranch() {
		ResponseStructure<List <BranchManager>> structure=new ResponseStructure<List <BranchManager>>();
		structure.setMessage("BranchManager Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDao.getAllBranch());
		return new ResponseEntity<ResponseStructure<List<BranchManager>>>(structure,HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<BranchManager>> updateBranch(BranchManager branch,int id) {
		BranchManager branchManager=branchManagerDao.updateBranch(branch, id);
		ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
		if(branchManager!=null) {
			structure.setMessage("BranchManager updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(branchManager);
			return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK);
			
		}
		else {
			structure.setMessage("BranchManager updated Successfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(branchManager);
			return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	public BranchManager getEmailnPass(BranchManager manager) throws Exception {
		return branchManagerDao.findEmailnPass(manager);
	}

}
