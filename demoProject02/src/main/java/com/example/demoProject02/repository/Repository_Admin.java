package com.example.demoProject02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demoProject02.dto.Admin;

public interface Repository_Admin extends JpaRepository<Admin, Integer>{
	//@Query("SELECT u FROM Admin u WHERE u.email=?1" )
	Admin  findByEmailAndPassword(String email,String password);

	//Admin findByEmail(String tempEmail);
	
	
}
