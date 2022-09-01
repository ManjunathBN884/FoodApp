package com.example.demoProject02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.FoodProducts;
import com.example.demoProject02.repository.Repository_FoodProducts;

@Repository
public class FoodProductsDao {
	@Autowired
	Repository_FoodProducts foodProducts;
	
	public FoodProducts saveFoodProducts(FoodProducts products) {
		return foodProducts.save(products);
	}

	public FoodProducts getFoodProductsById(int id) {
		return foodProducts.findById(id).get();
	}

	public FoodProducts deleteFoodProducts(int id) {
		FoodProducts products=getFoodProductsById(id);
		 foodProducts.delete(products);
		 return products;
	}

	public List<FoodProducts> getAllFoodProducts() {
		return foodProducts.findAll();
	}

	public FoodProducts updateFoodProducts(FoodProducts products,int id) {
		if(foodProducts.findById(id).isEmpty()) {
			return null;
		}
		else {
			products.setId(id);
			return foodProducts.save(products);
		}
	}
}
