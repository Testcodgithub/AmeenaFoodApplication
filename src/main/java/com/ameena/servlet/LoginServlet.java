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
import jakarta.servlet.http.HttpSession;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private HttpSession session;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        session= req.getSession();
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUser(email);
        session.setAttribute("user", user);
        System.out.println("User at 30 login servlet: " + user);

        if (user == null) {
            req.setAttribute("Errormessage", "Invalid Email or Password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (password.equals(user.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedIn", user);
            resp.sendRedirect("getAllResturantsServlet");
        } else {
            req.setAttribute("Errormessage", "Invalid Email or Password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
