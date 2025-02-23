package com.ameena.Dao;

import java.util.ArrayList;

import com.ameena.model.Menu;

public interface MenuDao {
	int addMenu(Menu m);
	void getAllMenu();
	ArrayList<Menu> getSpecificMenu(int menuId);
	int updateMenuIteam(Menu m);
	int deleteMenuIteam(String menuName);
	
	
	ArrayList<Menu>  getMenuOnRestaurantId(int id);
}
