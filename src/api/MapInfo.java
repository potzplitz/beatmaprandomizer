package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import randomizer.IDRandomizer;


@SuppressWarnings("unused")
public class MapInfo {
	//specific mapinfo
	private String bpm;
	private String version;
	private String od;
	private String sr;
	private String ar;
	private String cs;
	private String length;
	
	
	//general mapinfo
	private String diffs;
	private String plays;
	private String likes;
	private String mapper;
	private String genre;
	private String language;
	private String rating;
	private String uploaddate;
	private String name;
	private String artist;
	private String mapperid;
	private String mode;


	private String id;
	
	private static String arrin;
	
	
	@SuppressWarnings("unused")
	public void BeatmapInfo() throws IllegalStateException, IOException{	
		JSONArray a = new JSONArray(arrin);
				// JSON-Reader
				int i = 0;
	
				bpm = a.getJSONObject(i).getString("bpm");
				version = a.getJSONObject(i).getString("version");
				od = a.getJSONObject(i).getString("diff_overall");
				sr = a.getJSONObject(i).getString("difficultyrating");
				ar = a.getJSONObject(i).getString("diff_approach");
				cs = a.getJSONObject(i).getString("diff_size");
				mapper = a.getJSONObject(i).getString("creator");
				length = a.getJSONObject(i).getString("total_length");
				diffs = a.length() + "";
				plays = a.getJSONObject(i).getString("playcount");
				likes = a.getJSONObject(i).getString("favourite_count");
				genre = a.getJSONObject(i).getString("genre_id");
				language = a.getJSONObject(i).getString("language_id");
				rating = a.getJSONObject(i).getString("rating");
				uploaddate = a.getJSONObject(i).getString("submit_date");
				name = a.getJSONObject(i).getString("title");
				artist = a.getJSONObject(i).getString("artist");
				mapperid = a.getJSONObject(i).getString("creator_id");
				mode = a.getJSONObject(i).getString("mode");
				
				int genreint = Integer.parseInt(genre) - 1;
				genre = genreint + "";
				
				int langint = Integer.parseInt(language) - 1;
				language = langint + "";
				
				int modeint = Integer.parseInt(mode) - 1;
				mode = langint + "";
	}
	
	public void getApi() throws IOException {
		MapInfo info = new MapInfo();
		
		// API-Key
		String apikey = "3c29279d7f702fdd1094900daa128d898812b8d8";
		
		
		// API-Reader
		id = info.getMapID();
		String url = "https://osu.ppy.sh/api/get_beatmaps?s=" + id + "&m=" + "0" + "&k=" + apikey;
		URL apireq = new URL(url);
		URLConnection con = apireq.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		arrin = inputLine + "";
		System.out.println("api request with link: " + url);
	}

	public String getAR() throws IllegalStateException, IOException {
		return ar;		
	}
	public String getCS() throws IllegalStateException, IOException {	
		return cs;	
	}
	public String getSR() throws IllegalStateException, IOException {	
		return sr;	
	}
	public String getMapper() throws IllegalStateException, IOException {		
		return mapper;		
	}
	public String getDuration() throws IllegalStateException, IOException {	
		return length;	
	}
	public String getBPM() throws IllegalStateException, IOException {	
		return bpm;	
	}
	public String getOD() throws IllegalStateException, IOException {	
		return od;
	}
	public String getDiffCount() throws IllegalStateException, IOException {	
		return diffs;		
	}
	public String getPlays() throws IllegalStateException, IOException {	
		return plays;	
	}
	public String getLikes() throws IllegalStateException, IOException {	
		return likes;	
	}
	public String getGenre() throws IllegalStateException, IOException {	
		return genre;	
	}
	public String getLanguage() throws IllegalStateException, IOException {	
		return language;	
	}
	public String getRating() throws IllegalStateException, IOException {	
		return rating;	
	}
	public String getUploadDate() throws IllegalStateException, IOException {	
		return uploaddate;	
	}
	public String getName() throws IllegalStateException, IOException {	
		return name;	
	}
	public String getArtist() throws IllegalStateException, IOException {
		return artist;	
	}
	public String getMapperID() throws IllegalStateException, IOException {	
		return mapperid;	
	}
	public String getGameMode() throws IllegalStateException, IOException {	
		return mode;	
	}
	
	public String getMapID() {
		IDRandomizer id = new IDRandomizer();
		
		String temp = id.getRandom();
		return temp;
	}
}
