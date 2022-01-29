package com.gamestore;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DeleteServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		int gameID = Integer.parseInt(request.getParameter("id"));
		GameDBUtil db = new GameDBUtil();
		boolean isSuccess = db.deleteGame(gameID);
		
		
		if(isSuccess) {
			response.sendRedirect("index.jsp?deleted=true");
		}else {
			response.sendRedirect("GameDetailsServerlet?id=" + gameID + "&deleted=false"); 
		}
	}

}
