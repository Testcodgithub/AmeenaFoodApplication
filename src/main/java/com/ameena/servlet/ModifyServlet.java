package com.ameena.servlet;

import java.io.IOException;

import com.ameena.model.User;
import com.ameena.Dao.UserDao;
import com.ameena.DaoImpl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/modifyServlet")
public class ModifyServlet extends HttpServlet {
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        int id = Integer.parseInt(req.getParameter("userId"));
	        String username = req.getParameter("username");
	        String email = req.getParameter("email");
	        String phonenumber = req.getParameter("phonenumber");
	        String address = req.getParameter("address");
	        
	        // Assuming password is not being modified here
	        User u = new User(id, username, email, phonenumber, null, address);
	        System.out.println("User at ModifyServlet: " + u);
	        
	        UserDao userDao = new UserDaoImpl();
	        int status = userDao.modifyUser(u);
	        
	        if (status == 0) {
	            resp.sendRedirect("failure.jsp");
	        } else {
	            // Update the session attribute with the new user details
	            User updatedUser = userDao.getUser(email);
	            req.getSession().setAttribute("loggedIn", updatedUser);
	            resp.sendRedirect("home.jsp");
	        }
	    }
}
