package com.ameena.servlet;

import java.io.IOException;

import com.ameena.DaoImpl.UserDaoImpl;
import com.ameena.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		User u = new User(username, email, phonenumber, password, address);
		UserDaoImpl userDao= new UserDaoImpl();
		 
		int status= userDao.addUser1(u);
		
		if(status==0) {
			resp.sendRedirect("Failure.jsp");
		}
		else {
			resp.sendRedirect("login.jsp");
		}
	}
}
