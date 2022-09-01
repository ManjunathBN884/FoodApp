package com.example.demoProject02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Customer;
import com.example.demoProject02.repository.Repository_Customer;

@Repository
public class CustomerDao {
	@Autowired
Repository_Customer repository_Customer;
	
	public Customer saveCustomer(Customer customer) {
		return repository_Customer.save(customer);
	}
}
