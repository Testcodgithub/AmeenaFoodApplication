package com.ameena.servlet;

import java.io.IOException;
import java.util.List;

import com.ameena.model.Cart;
import com.ameena.model.CartItem;
import com.ameena.model.Menu;
import com.ameena.Dao.MenuDao;
import com.ameena.DaoImpl.MenuDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart= (Cart) session.getAttribute("cart");
		
		if(cart == null) {
			cart= new Cart();
			session.setAttribute("cart", cart);
		}
		String action =req.getParameter("action");
		
        if ("add".equals(action)) {
            addItemToCart(req, cart);
        } else if ("update".equals(action)) {
            updateCartItem(req, cart);
        } else if ("remove".equals(action)) {
            removeCartItem(req, cart);
        }
        resp.sendRedirect("cart.jsp");

	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
	    int menuId = Integer.parseInt(req.getParameter("itemId"));
	    int quantity = Integer.parseInt(req.getParameter("quantity"));
	    
	    System.out.println("Received itemId: " + menuId + ", quantity: " + quantity);
	    
	    MenuDao menuDao = new MenuDaoImpl();
	    List<Menu> menuList = menuDao.getSpecificMenu(menuId);
	    
	    if (menuList != null && !menuList.isEmpty()) {
	        Menu menuItem = menuList.get(0);
	        CartItem item = new CartItem(
	            menuItem.getMenuId(),
	            menuItem.getRestaurantId(),
	            menuItem.getMenuName(),
	            quantity,
	            menuItem.getPrice(),
	            quantity * menuItem.getPrice(),
	            menuItem.getImagePath()
	        );
	        cart.addItem(item);
	    } else {
	        System.out.println("Menu item not found for itemId: " + menuId);
	        // Handle the case where the menu item is not found, e.g., by sending an error message to the client
	    }
	}

	private void updateCartItem(HttpServletRequest req, Cart cart) {
        int menuId = Integer.parseInt(req.getParameter("menuId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        
        cart.updateItem(menuId, quantity);
    }
    
    private void removeCartItem(HttpServletRequest req, Cart cart) {
        int menuId = Integer.parseInt(req.getParameter("menuId"));
        
        cart.removeItem(menuId);
    }
}
