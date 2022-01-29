package com.gamestore;

public class MobileGame extends Game {
	protected String androidVersion; 
	protected String iosVersion;
	protected String mobileReleasedDate;
	
	
	public MobileGame(int gameID, String gameName, String image, String description, String developer, String publisher,
			String releaseDate, String platform, String androidVersion, String iosVersion, String mobileReleasedDate,  String type) {
		
		super(gameID, gameName, image, description, developer, publisher, releaseDate, platform, type);
		this.androidVersion = androidVersion;
		this.iosVersion = iosVersion;
		this.mobileReleasedDate = mobileReleasedDate;
	
	}


	public String getAndroidVersion() {
		return androidVersion;
	}


	public String getIosVersion() {
		return iosVersion;
	}


	public String getMobileReleasedDate() {
		return mobileReleasedDate;
	}
	
	
}
