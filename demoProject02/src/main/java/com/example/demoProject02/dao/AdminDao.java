package com.example.demoProject02.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.repository.Repository_Admin;

@Repository
public class AdminDao {
	@Autowired
	Repository_Admin admin_repo;

	public Admin saveAdmin(Admin admin) {

		return admin_repo.save(admin);
	}

	public Optional<Admin> getAdminById(int id) {

		return admin_repo.findById(id);
	}

	public Admin deleteAdmin(int id) {
		Admin admin = getAdminById(id).get();
		admin_repo.delete(admin);
		return admin;
	}

	public List<Admin> getAllAdmin() {
		return admin_repo.findAll();
	}

	public Admin updateAdmin(Admin admin, int id) {
		if (admin_repo.findById(id).isEmpty()) {
			return null;
		} else {
			admin.setId(id);
			return admin_repo.save(admin);
		}
	}

	public Admin findEmailnPass(Admin admin) throws Exception {
		String email =admin.getEmail() ;
		String password = admin.getPassword();
		Admin obj = null;
		if(email != null && password != null) {
			obj = admin_repo.findByEmailAndPassword(email,password);
		}
		if (obj == null) {
			throw new Exception("invalid");

		}
		return obj;
	}
}
