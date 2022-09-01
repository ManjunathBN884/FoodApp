package com.example.demoProject02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.FoodProductsDao;
import com.example.demoProject02.dto.FoodOrder;
import com.example.demoProject02.dto.FoodProducts;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class FoodProductsService {
	@Autowired
	FoodProductsDao foodProducts;
	
	public ResponseEntity<ResponseStructure<FoodProducts>> saveFoodProducts(FoodProducts products) {
		ResponseStructure<FoodProducts >  structure=new ResponseStructure<FoodProducts>();
		structure.setMessage("FoodProducts saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(foodProducts.saveFoodProducts(products));
		return new ResponseEntity<ResponseStructure<FoodProducts>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodProducts>> getFoodProductsById(int id) {
		ResponseStructure<FoodProducts >  structure=new ResponseStructure<FoodProducts>();
		structure.setMessage("FoodProducts Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodProducts.getFoodProductsById(id));
		return new ResponseEntity<ResponseStructure<FoodProducts>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodProducts>> deleteFoodProducts(int id) {
		ResponseStructure<FoodProducts >  structure=new ResponseStructure<FoodProducts>();
		structure.setMessage("FoodProducts Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodProducts.deleteFoodProducts(id));
		return new ResponseEntity<ResponseStructure<FoodProducts>>(structure,HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<List<FoodProducts>>> getAllFoodProducts() {
		ResponseStructure<List<FoodProducts >>  structure=new ResponseStructure<List<FoodProducts>>();
		structure.setMessage("FoodProducts Found ALL Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodProducts.getAllFoodProducts());
		return new ResponseEntity<ResponseStructure<List<FoodProducts>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodProducts>> updateFoodProducts(FoodProducts products,int id) {
		FoodProducts dao	=foodProducts.updateFoodProducts(products, id);
		ResponseStructure<FoodProducts >  structure=new ResponseStructure<FoodProducts>();
		if(dao!=null) {
		
		structure.setMessage("FoodProducts Updated Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao);
		return new ResponseEntity<ResponseStructure<FoodProducts>>(structure,HttpStatus.OK);
		}
		else {
			structure.setMessage("FoodProducts Failed to Update Successfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(null);
			return new ResponseEntity<ResponseStructure<FoodProducts>>(structure,HttpStatus.NOT_FOUND);
		}
	}

}
