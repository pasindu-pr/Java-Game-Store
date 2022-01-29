package com.gamestore;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AddGameServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameDBUtil db = new GameDBUtil();
		boolean isSuccess;
		
		String gameName = request.getParameter("gamename");
		String image = request.getParameter("image");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		String releasedate = request.getParameter("releasedate");
		String platform = request.getParameter("platform");
		String description = request.getParameter("description");
		String androidVersion = request.getParameter("androidVersion");
		String iosVersion = request.getParameter("iosVersion");
		String mobileReleaseDate = request.getParameter("mobileReleaseDate");
		
		
//		Validate required data data
		if(gameName.length() == 0 || image.length() == 0 || platform.length() == 0 || description.length() == 0) {
			isSuccess = false;
			request.setAttribute("validateError", true);
		} else if(platform.equals("Mobile")) {
			isSuccess = db.insertGame(gameName, image, developer, publisher, releasedate, platform, description, androidVersion, iosVersion, mobileReleaseDate);
		}else {
			isSuccess = db.insertGame(gameName, image, developer, publisher, releasedate, platform, description);
		}
	
		
	
		if(isSuccess) {
			RequestDispatcher d1 = request.getRequestDispatcher("admin.jsp");
			d1.forward(request, response);
		}else if(platform.equals("Mobile")) {
			RequestDispatcher d2 = request.getRequestDispatcher("addgame.jsp");
			d2.forward(request, response);	
		}else {
			RequestDispatcher d3 = request.getRequestDispatcher("addMobileGame.jsp");
			d3.forward(request, response);		
		}
		
		
	}

}
