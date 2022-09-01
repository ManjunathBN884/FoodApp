package com.example.demoProject02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject02.dto.Customer;
import com.example.demoProject02.util.EmailService;

@RestController
public class EmailController {
	@Autowired
	EmailService service;
	@GetMapping("/sendemail/{id}")
	public String sendEmail(@RequestBody Customer customer,@PathVariable int id) {
		return service.sendEmail(customer, id);
	}

}
