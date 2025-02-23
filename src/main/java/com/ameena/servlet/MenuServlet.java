package com.ameena.servlet;

import java.util.ArrayList;

import com.ameena.model.Menu;
import com.ameena.Dao.MenuDao;
import com.ameena.DaoImpl.MenuDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)  {
		try {
			int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
			
			MenuDao menuDao= new  MenuDaoImpl();
			ArrayList<Menu> menuList=menuDao.getMenuOnRestaurantId(restaurantId);
			
			
			 HttpSession session =req.getSession();
			 session.setAttribute("menuList", menuList);
			 
			 resp.sendRedirect("menu.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
