package com.gamestore;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	static String url = "jdbc:mysql://localhost:3306/games?useSSL=false";
	static String dbuser = "root";
	static String dbpassword = "1234";
	private static Connection con;
	
	public static Connection getDbConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con  = DriverManager.getConnection(url, dbuser, dbpassword);
		}catch(Exception e) {
			System.out.println("DB not connected!");
		}
		
		return con;
	}
	
}
