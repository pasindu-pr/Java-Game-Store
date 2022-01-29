package com.gamestore;


import java.sql.*;
import java.util.ArrayList;



public class GameDBUtil implements DBOperations {
	private Connection con = DBConfig.getDbConnection();
	ArrayList<Game> gamelist = new ArrayList<Game>();
	ArrayList<Game> mobileGamelist = new ArrayList<Game>();
	
	@Override
	public ArrayList<Game> fetchAllPcGames() {
		
		String sql = "select * from games where type= 'PC'";
	    
		try (Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	  
	    	int gameID = rs.getInt("gameid");
	    	String gameName = rs.getString("name");
	    	String description = rs.getString("description");
	    	String image = rs.getString("image");
	    	String developer = rs.getString("developer");
	    	String publisher = rs.getString("publisher");
	    	String releaseDate = rs.getString("releasedate");
	    	String platform = rs.getString("platform");
	    	String type = rs.getString("type");
	    	
	    	description = description.substring(0, 50) + "...";
	    	
	    	Game g1 = new Game(gameID, gameName, image, description, developer, publisher, releaseDate, platform, type);	    	
	    	gamelist.add(g1);
	      }
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
	    
	    return gamelist;
	}
	
//	Get Mobile Games
	public ArrayList<Game> fetchAllMobileGames() {
		
		String sql = "select * from games where type= 'Mobile'";
	    
		try (Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	  
	    	int gameID = rs.getInt("gameid");
	    	String gameName = rs.getString("name");
	    	String description = rs.getString("description");
	    	String image = rs.getString("image");
	    	String developer = rs.getString("developer");
	    	String publisher = rs.getString("publisher");
	    	String releaseDate = rs.getString("releasedate");
	    	String platform = rs.getString("platform");
	    	String androidVersion = rs.getString("androidVersion"); 
	    	String iosVersion = rs.getString("iosVersion"); 
	    	String mobileReleasedDate = rs.getString("mobileReleasedDate");
	    	String type = rs.getString("type");
	    
	    	description = description.substring(0, 30);
	    	
	    	
	    	Game g1 = new MobileGame(gameID, gameName, image, description, developer, publisher, releaseDate, platform, androidVersion, iosVersion, mobileReleasedDate, type);	    	
	    	mobileGamelist.add(g1);
	      }
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
	    
	    return mobileGamelist;
	}
	
	
	
	@Override
	public boolean insertGame(String gameName, String image, String developer, String publisher, String releaseDate, String platform, String description) {
		boolean isAdded = false;
		
		System.out.println(releaseDate);
		
		String sql = "INSERT INTO GAMES(gameid, name, description, image, developer, publisher, releasedate, platform, type) VALUES(?, ?, ? , ?, ?, ?, ?, ?, ?)";

		 
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
		   
		   stmt.setInt(1, 0);
		   stmt.setString(2, gameName);
		   stmt.setString(3, description);
		   stmt.setString(4, image);
		   stmt.setString(5, developer);
		   stmt.setString(6, publisher);
		   stmt.setString(7, releaseDate);
		   stmt.setString(8, platform);
		   stmt.setString(9, "PC");
		   
	       int value = stmt.executeUpdate();
	       
	       if(value > 0) {
	    	   isAdded = true;
	       }else {
	    	   isAdded = false;
	       }
	       
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
		
		
		return isAdded;
	}
	

	//	Overloaded Insert Method to add Mobile game
	public boolean insertGame(String gameName, String image, String developer, String publisher, String releaseDate, String platform, String description, String androidVersion,String iosVersion, String mobileReleaseDate) {
		boolean isAdded = false;
		
		System.out.println(mobileReleaseDate);
		
		String sql = "INSERT INTO GAMES VALUES(?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		 
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
	       
			stmt.setInt(1, 0);
			stmt.setString(2, gameName);
			stmt.setString(3, description);
			stmt.setString(4, image);
			stmt.setString(5, developer);
			stmt.setString(6, publisher);
			stmt.setString(7, releaseDate);
			stmt.setString(8, platform);	
			stmt.setString(9, androidVersion);	
			stmt.setString(10, iosVersion);	
			stmt.setString(11, mobileReleaseDate);	
			stmt.setString(12, "Mobile");
			
			int value = stmt.executeUpdate();
	       
	       if(value > 0) {
	    	   isAdded = true;
	       }else {
	    	   isAdded = false;
	       }
	       
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
		
		
		return isAdded;
	}
	
	
	public Game getGameDetail(String gid) {
		Game g1 = null;
		int gameid = Integer.parseInt(gid);
		
		String sql = "select * from games where gameid = '"+ gameid +"'";
		
		try (Statement stmt = con.createStatement()) {
		      ResultSet rs = stmt.executeQuery(sql);
		      while (rs.next()) {
		    	  
		    	int gameID = rs.getInt("gameid");
		    	String gameName = rs.getString("name");
		    	String description = rs.getString("description");
		    	String image = rs.getString("image");
		    	String developer = rs.getString("developer");
		    	String publisher = rs.getString("publisher");
		    	String releaseDate = rs.getString("releasedate");
		    	String platform = rs.getString("platform");
		    	String androidVersion = rs.getString("androidVersion"); 
		    	String iosVersion = rs.getString("iosVersion"); 
		    	String mobileReleasedDate = rs.getString("mobileReleasedDate");
		    	String type = rs.getString("type");
		    	
		    	System.out.println(type);
		    	
		    	if(type.equals("PC")) {
		    		g1 = new Game(gameID, gameName, image, description, developer, publisher, releaseDate, platform, type);
		    	}else {
		    		g1 = new MobileGame(gameID, gameName, image, description, developer, publisher, releaseDate, platform, androidVersion, iosVersion, mobileReleasedDate, type);	 
		    	}
		    	
		    	return g1;
		      }
		    } catch (SQLException e) {
		      System.out.println(e.getMessage());
		    }
		
			return g1;
		}


	@Override
	public boolean updateGame(int gameid,String gameName, String image, String developer, String publisher, String releaseDate,
			String platform, String description) {
		boolean isUpdated = false;
		
		System.out.println(releaseDate);
		
		String sql = "UPDATE GAMES SET name= ?, image= ?, description= ?, developer= ?, publisher= ?, releasedate= ?, platform= ? WHERE gameid= ?";

		 
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			
			
			stmt.setString(1, gameName);
			stmt.setString(2, image);
			stmt.setString(3, description);
			stmt.setString(4, developer);
			stmt.setString(5, publisher);
			stmt.setString(6, releaseDate);
			stmt.setString(7, platform);
			stmt.setInt(8, gameid);
			
	       int value = stmt.executeUpdate();
	       
	       if(value > 0) {
	    	   isUpdated = true;
	       }else {
	    	   isUpdated = false;
	       }
	       
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
		return isUpdated;
	}


//	Overloaded Method to update the mobile game
	public boolean updateGame(int gameid,String gameName, String image, String developer, String publisher, String releaseDate, String platform, String description, String androidVersion,String iosVersion, String mobileReleaseDate) {
		boolean isUpdated = false;
		
		System.out.println("Mobile Release Date" +  mobileReleaseDate);
		
		String sql = "UPDATE GAMES SET name= ?, image= ?, description= ?, developer= ?, publisher= ?, releasedate= ?, platform= ?, androidVersion= ?, iosVersion= ?, mobileReleasedDate= ?, type= ?  WHERE gameid= ?";

		 
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, gameName);
			stmt.setString(2, image);
			stmt.setString(3, description);
			stmt.setString(4, developer);
			stmt.setString(5, publisher);
			stmt.setString(6, releaseDate);
			stmt.setString(7, platform);
			stmt.setString(8, androidVersion);
			stmt.setString(9, iosVersion);
			stmt.setString(10, mobileReleaseDate);
			stmt.setString(11, "Mobile");
			stmt.setInt(12, gameid);
			
	       int value = stmt.executeUpdate();
	       
	       if(value > 0) {
	    	   isUpdated = true;
	       }else {
	    	   isUpdated = false;
	       }
	       
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
		return isUpdated;
	}
	

	@Override
	public boolean deleteGame(int gameID) {
		boolean isDeleted = false;
		
		String sql = "DELETE FROM games where gameid='"+gameID+"'";

		 
		try (Statement stmt = con.createStatement()) {
	       int value = stmt.executeUpdate(sql);
	       
	       if(value > 0) {
	    	   isDeleted = true;
	       }else {
	    	   isDeleted = false;
	       }
	       
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
		return isDeleted;
	}
	
}
