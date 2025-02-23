package com.ameena.Dao;

import java.util.ArrayList;

import com.ameena.model.User;

public interface UserDao {
	int addUser(User u);
	ArrayList<User> getAllUsers();
	User getUser(String email);
	int updateUser(User u);
	int  deleteUser(String email);
	
	
	int addUser1(User u);
	//ModifyServlet
	int modifyUser(User u);
}
