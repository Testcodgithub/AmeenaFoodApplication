package com.ameena.Dao;

import java.util.ArrayList;

import com.ameena.model.Orderhistory;

public interface OderHistoryDao {
	int addHistory(Orderhistory oh);
	ArrayList<Orderhistory> getAllOderHistoryIteams(int userId);
	Orderhistory getSpecificHistoryIteam(int userId);
	 
	
	ArrayList<Orderhistory> getOrderHistoryByUserId(int userId);
}
