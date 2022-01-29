package com.gamestore;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;

public class GameUpdateServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameDBUtil db = new GameDBUtil();
		boolean isSuccess;
		
		int gameid = Integer.parseInt(request.getParameter("gameid"));
		String gameName = request.getParameter("gamename");
		String image = request.getParameter("image");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		String releasedate = request.getParameter("releasedate");
		String platform = request.getParameter("platform");
		String description = request.getParameter("description");
		String androidVersion = request.getParameter("androidVersion");
		String iosVersion = request.getParameter("iosVersion");
		String mobileReleasedDate = request.getParameter("mobileReleasedDate");
		
		
	
		if(platform.equals("Mobile")) {
			isSuccess = db.updateGame(gameid,gameName, image, developer, publisher, releasedate, platform, description, androidVersion, iosVersion, mobileReleasedDate);			
		}else {
			isSuccess = db.updateGame(gameid,gameName, image, developer, publisher, releasedate, platform, description);			
		}

	
		if(isSuccess) {
			response.sendRedirect("GameDetailsServerlet?id=" + gameid);
		}else {
			response.sendRedirect("GameDetailsServerlet?id=" + gameid); 
		}
	
	}

}
