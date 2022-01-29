package com.gamestore;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HomePageServerlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameDBUtil gameDatabaseUtilities = new GameDBUtil();
		ArrayList<Game> pcgamelist = gameDatabaseUtilities.fetchAllPcGames();  
		ArrayList<Game> mobileGamelist = gameDatabaseUtilities.fetchAllMobileGames();
		request.setAttribute("pcgames", pcgamelist);
		request.setAttribute("mobilegames", mobileGamelist);                 
	}

}
