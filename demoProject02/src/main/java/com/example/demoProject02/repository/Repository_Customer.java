package com.example.demoProject02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject02.dto.Customer;

public interface Repository_Customer extends JpaRepository<Customer, Integer> {
	

}
