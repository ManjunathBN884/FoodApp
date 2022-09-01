package com.example.demoProject02.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoProject02.dto.Menu;
import com.example.demoProject02.repository.Repository_Menu;

@Repository
public class MenuDao {
	@Autowired
	Repository_Menu repository_Menu;
	
	public Menu saveMenu(Menu menu) {
		return repository_Menu.save(menu);
	}

	public Menu getMenuById(int id) {
		return repository_Menu.findById(id).get();
	}

	public Menu deleteMenu(int id) {
		Menu menu=getMenuById(id);
		 repository_Menu.delete(menu);
		 return menu;
	}

	public List<Menu> getAllMenu() {
		return repository_Menu.findAll();
	}

	public Menu updateMenu(Menu menu,int id) {
		if(repository_Menu.findById(id).isEmpty()) {
			return null;
		}
		else {
			menu.setId(id);
			return repository_Menu.save(menu);
		}
	}
}
