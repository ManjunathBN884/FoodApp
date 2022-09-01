package com.example.demoProject02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.StaffDao;
import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.Menu;
import com.example.demoProject02.dto.Staff;
import com.example.demoProject02.exception.IdNotFound;
import com.example.demoProject02.util.Encryp;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class StaffService {
	@Autowired
	StaffDao staffDao;
//	@Autowired
//	Encryp encryp;
	
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		//encryp.setPassword(Encryp.encrypt(encryp.getPassword(), "any"));
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		structure.setMessage("Staff Created Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(staffDao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(int id) {
		Optional<Staff> optional=staffDao.getStaffById(id);
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		if(optional.isEmpty()) {
			throw new IdNotFound();
		}
		else {
		structure.setMessage("Staff Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(optional.get());
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int id) {
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		structure.setMessage("Staff Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(staffDao.deleteStaff(id));
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);	
	}

	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaffs() {
		ResponseStructure<List<Staff>> structure=new ResponseStructure<List<Staff>>();
		structure.setMessage("Staff Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(staffDao.getAllStaffs());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(structure,HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff,int id) {
	Staff dao=	staffDao.updateStaff(staff, id);
	ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
	if(dao!=null) {
		
		structure.setMessage("Staff Updated Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao);
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);	
	}
	else {
		structure.setMessage("Staff Failed To Update Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(null);
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);	
	}

	}
	public Staff getEmailnPass(Staff staff) throws Exception {
		return staffDao.findEmailnPass(staff);
	}
	
}
