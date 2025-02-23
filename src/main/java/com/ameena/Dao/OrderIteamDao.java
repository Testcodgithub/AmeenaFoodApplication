package com.ameena.Dao;

import java.util.ArrayList;

import com.ameena.model.OrderIteam;

public interface OrderIteamDao {
	int addOderIteam(OrderIteam ot);
	ArrayList<OrderIteam> getAllOderIteams();
	OrderIteam getSpecificOrderIteam(int orderId);
}
