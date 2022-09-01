package com.example.demoProject02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject02.dao.CustomerDao;
import com.example.demoProject02.dto.Customer;
import com.example.demoProject02.service.CustomerService;

@RestController
public class CustomerController {
@Autowired
CustomerService service;
@PostMapping("/saveCustomer/{id}")
public Customer saveCustomer(@RequestBody Customer customer,@PathVariable int id) {
	return service.savCustomer(customer, id);	
}
}

