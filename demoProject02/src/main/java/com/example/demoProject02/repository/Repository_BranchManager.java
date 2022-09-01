package com.example.demoProject02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.BranchManager;

public interface Repository_BranchManager extends JpaRepository<BranchManager, Integer> {
	BranchManager  findByEmailAndPassword(String email,String password);
}
