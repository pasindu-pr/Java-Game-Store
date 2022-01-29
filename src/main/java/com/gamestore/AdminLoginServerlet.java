package com.gamestore;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

 
public class AdminLoginServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDBUtil db = new AdminDBUtil();
		
		boolean isAdmin = db.validateAdmin(username, password); 
		
		if(isAdmin) {
			session.setAttribute("isAdmin", true);
			
			RequestDispatcher r1 = request.getRequestDispatcher("admin.jsp");
			r1.forward(request, response);
		}else {
			RequestDispatcher r2 = request.getRequestDispatcher("adminlogin.jsp");
			r2.forward(request, response);
		} 
	}

}
