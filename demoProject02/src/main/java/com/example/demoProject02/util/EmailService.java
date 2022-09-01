package com.example.demoProject02.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.CustomerDao;
import com.example.demoProject02.dao.FoodOrderDao;
import com.example.demoProject02.dto.Customer;
import com.example.demoProject02.dto.FoodOrder;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailSender;
//	@Autowired
//	CustomerDao customerDao;
	@Autowired
	FoodOrderDao dao;
	
	public String sendEmail(Customer customer,int id) {
		SimpleMailMessage message=new SimpleMailMessage();
		FoodOrder foodOrder=dao.getFoodOrderById(id);
		customer.setGST(0.18);
		customer.setServiceCost(10);
		double total=foodOrder.getPrice();
		customer.setCost(total+(total*customer.getGST())+total*customer.getServiceCost());
		message.setFrom("manju8105635884@gmail.com");
		message.setTo(customer.getEmail());
		message.setSubject("Test Subject");
		message.setText("Your Order Id is=" +foodOrder.getId()+"\n" + " Your Food Price is="+foodOrder.getPrice()+"\n"+" GST=1%,Service=1%."+"\n" +"Total Price="+customer.getCost());
		javaMailSender.send(message);
		return message.getText();
		
	}
	
	

}
