package com.example.demoProject02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.CustomerDao;
import com.example.demoProject02.dao.FoodOrderDao;
import com.example.demoProject02.dto.Customer;
import com.example.demoProject02.dto.FoodOrder;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public Customer savCustomer(Customer customer,int id) {
		customer.setGST(0.18);
		customer.setServiceCost(10);
		FoodOrder order=foodOrderDao.getFoodOrderById(id);
		double total=order.getPrice();
		customer.setCost(total+(total*customer.getGST())+total*customer.getServiceCost());
		return customerDao.saveCustomer(customer); 
		
	
	}

}
