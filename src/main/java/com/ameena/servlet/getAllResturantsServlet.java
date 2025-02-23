package com.ameena.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.ameena.Dao.RestaruantDao;
import com.ameena.DaoImpl.RestaurantDaoImpl;
import com.ameena.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/getAllResturantsServlet")
public class getAllResturantsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaruantDao allres = new RestaurantDaoImpl();
		
		ArrayList<Restaurant> restaurantList = allres.getAllResturant();
		 HttpSession session =req.getSession();
		 session.setAttribute("restaurantList", restaurantList);
		 
		 resp.sendRedirect("home.jsp");

	}
}
