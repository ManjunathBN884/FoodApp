package com.example.demoProject02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.FoodOrderDao;
import com.example.demoProject02.dto.Admin;
import com.example.demoProject02.dto.FoodOrder;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder order) {
		ResponseStructure<FoodOrder >  structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder Created Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(foodOrderDao.saveFoodOrder(order));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		ResponseStructure<FoodOrder >  structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodOrderDao.getFoodOrderById(id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		ResponseStructure<FoodOrder >  structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodOrderDao.deleteFoodOrder(id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);	
	}

	public   ResponseEntity<ResponseStructure<List<FoodOrder>>> getAllFoodOrder() {
		ResponseStructure<List<FoodOrder >>  structure=new ResponseStructure<List<FoodOrder>>();
		structure.setMessage("FoodOrder Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodOrderDao.getAllFoodOrder());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure,HttpStatus.CREATED);	
		
		
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder order,int id) {
		FoodOrder dao=foodOrderDao.updateFoodOrder(order, id);
		ResponseStructure<FoodOrder >  structure=new ResponseStructure<FoodOrder>();
		if(dao!=null) {
			structure.setMessage("FoodOrder updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(dao);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);
		}
		else {
		structure.setMessage("FoodOrder Failed to Update Successfully");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.NOT_FOUND);
		}
	}
}
