package com.example.demoProject02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.AdminDao;
import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.exception.IdNotFound;
import com.example.demoProject02.util.Encryp;
import com.example.demoProject02.util.ResponseStructure;
import java.util.*;
@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	@Autowired
	Encryp encryp;
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		//admin.setPassword(Encryp.encrypt(admin.getPassword(), "any"));
		
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		structure.setMessage("Admin Created Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}
	

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		Optional <Admin>optional=adminDao.getAdminById(id);
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		if(optional.isEmpty()) {
			throw new IdNotFound();
		}
		else {
			structure.setMessage("Admin Found Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK) ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		structure.setMessage("Admin Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(adminDao.deleteAdmin(id)); 
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity< ResponseStructure<List<Admin>>>  getAllAdmin() {
		ResponseStructure<List<Admin>> structure=new ResponseStructure<List<Admin>>();
		structure.setMessage("Found All Admin Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(adminDao.getAllAdmin()); 
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.OK);
		}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin,int id) {
		Admin dao =adminDao.updateAdmin(admin, id);
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		if(dao!=null) {
			structure.setMessage("Admin Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(dao); 
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			
		}
		else {
			structure.setMessage("Admin Failed to Update");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(null); 
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	public Admin getEmailnPass(Admin admin) throws Exception {
		return adminDao.findEmailnPass(admin);
	}

	
}




