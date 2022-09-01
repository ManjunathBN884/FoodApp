package com.example.demoProject02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject02.dto.Staff;

public interface Repository_Staff extends JpaRepository<Staff, Integer> {
	Staff findByEmailAndPassword(String email,String password);
}
