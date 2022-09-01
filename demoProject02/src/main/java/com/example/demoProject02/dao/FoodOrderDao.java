package com.example.demoProject02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.FoodOrder;
import com.example.demoProject02.repository.Repository_FoodOrder;

@Repository
public class FoodOrderDao {
	
	@Autowired
	Repository_FoodOrder repository_FoodOrder;
	
	public FoodOrder saveFoodOrder(FoodOrder order) {
		return repository_FoodOrder.save(order);
	}

	public FoodOrder getFoodOrderById(int id) {
		return repository_FoodOrder.findById(id).get();
	}

	public FoodOrder deleteFoodOrder(int id) {
		FoodOrder order=getFoodOrderById(id);
		 repository_FoodOrder.delete(order);
		 return order;
	}

	public List<FoodOrder> getAllFoodOrder() {
		return repository_FoodOrder.findAll();
	}

	public FoodOrder updateFoodOrder(FoodOrder order,int id) {
		if(repository_FoodOrder.findById(id).isEmpty()) {
			return null;
		}
		else {
			order.setId(id);
			return repository_FoodOrder.save(order);
		}
	}

}
