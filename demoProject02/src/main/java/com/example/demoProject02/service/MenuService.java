package com.example.demoProject02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.MenuDao;
import com.example.demoProject02.dto.Items;
import com.example.demoProject02.dto.Menu;
import com.example.demoProject02.util.ResponseStructure;

@Service
public class MenuService {
	@Autowired
	MenuDao menuDao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
		structure.setMessage("Menu Created Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
		structure.setMessage("Menu Found Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(menuDao.getMenuById(id));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
		structure.setMessage("Menu Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(menuDao.deleteMenu(id));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenu() {
		ResponseStructure<List<Menu>> structure=new ResponseStructure<List<Menu>>();
		structure.setMessage("Menu Found All Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT( menuDao.getAllMenu());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu,int id) {
		Menu dao=menuDao.updateMenu(menu, id);
		ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
		if(dao!=null) {
		structure.setMessage("Menu Updated Successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(menuDao.deleteMenu(id));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.CREATED);
		}
		else {
			structure.setMessage("Menu Updated Successfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(menuDao.deleteMenu(id));
			return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.NOT_FOUND);
		}
	}
}
