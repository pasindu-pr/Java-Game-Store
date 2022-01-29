package com.gamestore;

public class Game {
	protected int gameID;
	protected String gameName;
	protected String image;
	protected String description;
	protected String developer;
	protected String publisher;
	protected String releaseDate;
	protected String platform;
	protected String type;
	
	
	public Game(int gameID, String gameName, String image, String description, String developer, String publisher,
			String releaseDate, String platform, String type) {
		this.gameID = gameID;		
		this.gameName = gameName;
		this.image = image;
		this.description = description;
		this.developer = developer;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
		this.platform = platform;
		this.type = type;
	}


	public int getGameID() {
		return gameID;
	}


	public String getGameName() {
		return gameName;
	}


	public String getImage() {
		return image;
	}


	public String getDescription() {
		return description;
	}


	public String getDeveloper() {
		return developer;
	}


	public String getPublisher() {
		return publisher;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public String getPlatform() {
		return platform;
	}


	public String getType() {
		return type;
	}
	
	
}
