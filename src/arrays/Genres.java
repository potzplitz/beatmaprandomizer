package arrays;

import java.util.ArrayList;

public class Genres {
	
	public ArrayList<String> genres = new ArrayList<String>();
	
	public void addList() {
		
		
		genres.add("Unspecified");
		genres.add("Video Game");
		genres.add("Anime");
		genres.add("Rock");
		genres.add("Pop");
		genres.add("Other");
		genres.add("Novelty");
		genres.add("Hip Hop");
		genres.add("Electronic");
		genres.add("Metal");
		genres.add("Classical");
		genres.add("Folk");
		genres.add("Jazz");

		
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getGenres() {
		
		
		
		return genres;
		
	}
	

}
