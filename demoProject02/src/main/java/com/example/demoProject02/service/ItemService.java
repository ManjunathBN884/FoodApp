package com.example.demoProject02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.ItemsDao;
import com.example.demoProject02.dto.Items;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class ItemService {
	@Autowired
	ItemsDao itemsDao;
	
	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> structure=new ResponseStructure<Items>();
		structure.setMessage("Items Created Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(itemsDao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> getItemssById(int id) {
		ResponseStructure<Items> structure=new ResponseStructure<Items>();
		structure.setMessage("Items Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(itemsDao.getItemssById(id));
		return new ResponseEntity<ResponseStructure<Items>>(structure,HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Items>> deleteItem(int id) {
		ResponseStructure<Items> structure=new ResponseStructure<Items>();
		structure.setMessage("Items Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(itemsDao.deleteItem(id));
		return new ResponseEntity<ResponseStructure<Items>>(structure,HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<List<Items>>> getAllItems() {
		ResponseStructure<List<Items>> structure=new ResponseStructure<List<Items>>();
		structure.setMessage("Items Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(itemsDao.getAllItems());
		return new ResponseEntity<ResponseStructure<List<Items>>>(structure,HttpStatus.OK);
		
		
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items,int id) {
		Items dao=itemsDao.updateItems(items, id);
		ResponseStructure<Items> structure=new ResponseStructure<Items>();
		if(dao!=null) {
		structure.setMessage("Items Updated Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao);
		return new ResponseEntity<ResponseStructure<Items>>(structure,HttpStatus.OK);
		}
		else {
			structure.setMessage("Items Failed To Update Successfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(null);
			return new ResponseEntity<ResponseStructure<Items>>(structure,HttpStatus.NOT_FOUND);
			
		}

	}
}
