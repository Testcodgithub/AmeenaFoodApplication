package com.ameena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ameena.DaoImpl.OrderDaoImpl;
import com.ameena.model.Cart;
import com.ameena.model.Ordertable;
import com.ameena.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Orderhistory")
public class OrderHistoryServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	PrintWriter printwriter =resp.getWriter();
	    	
	    	String status ="Pending";
	    	String paymentMode=req.getParameter("paymentMode");
	    	Float totalAmount = Float.parseFloat(req.getParameter("totalAmount"));
	    	HttpSession session = req.getSession();
	    	User User = (User)session.getAttribute("loggedIn");
	    	if(User==null) {
	    		resp.sendRedirect("Failure.jsp");
	    		return;
	    	}
	    	int userId=User.getUserId();
	    	
	    	Cart cart = (Cart) session.getAttribute("cart");
	    	if(cart==null || cart.getItems()==null) {
	    		resp.sendRedirect("cart.jsp");
	    		return;
	    	}
	    	int quality=cart.getItems().values().iterator().next().getQuantity();
	    	float price=(float) cart.getItems().values().iterator().next().getPrice();
	    	int menuId=cart.getItems().values().iterator().next().getMenuId();
	    	int resturantId=cart.getItems().values().iterator().next().getRestaurantId();
	    	
	    	OrderDaoImpl orderDao = new OrderDaoImpl();
	    	
	    	Ordertable Ordertable = new Ordertable (
	    		0,resturantId, userId, paymentMode, totalAmount, status, paymentMode);
	    			
	    	orderDao.addOrder(Ordertable);
	    	
	    	
	    	
	    	
	    	
	    	RequestDispatcher reqdep = req.getRequestDispatcher("OrderConfirmation.jsp");
	    	reqdep.forward(req, resp);
	    	
	    }
}
