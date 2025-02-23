package com.ameena.Dao;

import java.util.ArrayList;

import com.ameena.model.Restaurant;

public interface RestaruantDao {
	int addResturant(Restaurant r);
	 ArrayList<Restaurant> getAllResturant();
	 Restaurant getSpecificResturant(int resturantId);
	int updateResturant(Restaurant r);
	int deleteResturant(int resturantId);
}
