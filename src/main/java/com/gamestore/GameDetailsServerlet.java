package com.gamestore;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GameDetailsServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gameid = request.getParameter("id");
		Game g1;
		
		try {
			
			GameDBUtil gamedb = new GameDBUtil();
			g1 = gamedb.getGameDetail(gameid);
			System.out.println("G1 Type: This is game details serverlet " +  g1.type);
			request.setAttribute("game", g1);	
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher d1 = request.getRequestDispatcher("gameinner.jsp");
		d1.forward(request, response);
	}


}
