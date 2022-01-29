package com.gamestore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminDBUtil {
	public boolean validateAdmin (String username, String password) {
		Connection con = DBConfig.getDbConnection();
		boolean isAdminFound = false;
		String adminUserName = "";
		
		String sql = "select adminUserName from admin where adminUserName='"+username+"' and adminPassword='"+password+"'";
		
		System.out.println(sql);
		
		try (Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	adminUserName = rs.getString("adminUserName");	    
	      }
	      System.out.println("Admin username:  " + adminUserName);
	      if(adminUserName.length() > 0) {
	    	  isAdminFound = true;
	      }
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }		
		
		return isAdminFound;
	}
}