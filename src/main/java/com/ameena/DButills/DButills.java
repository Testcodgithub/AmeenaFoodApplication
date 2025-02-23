package com.ameena.DButills;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButills {
	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/ameena_food";
	private static String username="root";
	private static String password ="root";
    public static  Connection myConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
