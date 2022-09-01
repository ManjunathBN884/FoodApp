package com.example.demoProject02.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.Staff;
import com.example.demoProject02.repository.Repository_Staff;

@Repository
public class StaffDao {
	@Autowired
	Repository_Staff repository_Staff;
	
	public Staff saveStaff(Staff staff) {
		return repository_Staff.save(staff);
	}

	public Optional<Staff> getStaffById(int id) {
		return repository_Staff.findById(id);
	}

	public Staff deleteStaff(int id) {
		Staff staff=getStaffById(id).get();
		 repository_Staff.delete(staff);
		 return staff;
	}

	public List<Staff> getAllStaffs() {
		return repository_Staff.findAll();
	}

	public Staff updateStaff(Staff staff,int id) {
		if(repository_Staff.findById(id).isEmpty()) {
			return null;
		}
		else {
			staff.setId(id);
			return repository_Staff.save(staff);
		}
	}
	public Staff findEmailnPass(Staff staff) throws Exception {
		String email =staff.getEmail() ;
		String password = staff.getPassword();
		Staff obj = null;
		if(email != null && password != null) {
			obj = repository_Staff.findByEmailAndPassword(email,password);
		}
		if (obj == null) {
			throw new Exception("invalid");

		}
		return obj;
	}
}
