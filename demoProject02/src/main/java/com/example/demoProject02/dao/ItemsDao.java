package com.example.demoProject02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Items;
import com.example.demoProject02.repository.Repository_Items;

@Repository
public class ItemsDao {
	@Autowired
	Repository_Items repository_Items;
	
	public Items saveItems(Items items) {
		return repository_Items.save(items);
	}

	public Items getItemssById(int id) {
		return repository_Items.findById(id).get();
	}

	public Items deleteItem(int id) {
		Items items=getItemssById(id);
		 repository_Items.delete(items);
		 return items;
	}

	public List<Items> getAllItems() {
		return repository_Items.findAll();
	}

	public Items updateItems(Items items,int id) {
		if(repository_Items.findById(id).isEmpty()) {
			return null;
		}
		else {
			items.setId(id);
			return repository_Items.save(items);
		}
	}
}
