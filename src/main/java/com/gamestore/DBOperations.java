package com.gamestore;
import java.util.List;

public interface DBOperations {
	public List<Game> fetchAllPcGames();
	public boolean insertGame(String gameName, String image, String developer, String publisher, String releaseDate, String platform, String description);
	public boolean updateGame(int gameid, String gameName, String image, String developer, String publisher, String releaseDate, String platform, String description);
	public boolean deleteGame(int gameID);
}
