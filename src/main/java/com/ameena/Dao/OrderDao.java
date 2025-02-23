package com.ameena.Dao;

import java.util.ArrayList;

import com.ameena.model.Ordertable;

public interface OrderDao {
	int addOrder(Ordertable o);
	ArrayList<Ordertable> getAllOrders();
	Ordertable getSpecificRestuarant(int restaurantId);
}
