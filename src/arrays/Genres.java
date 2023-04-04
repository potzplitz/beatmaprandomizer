package arrays;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


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
	
	
	public void getdata(int i) {
		
		System.out.println(genres.get(i));
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList getGenres() {
		
		
		
		return genres;
		
	}
	

}
