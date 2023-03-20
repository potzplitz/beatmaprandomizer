package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;


import com.oopsjpeg.osu4j.OsuBeatmap;
import com.oopsjpeg.osu4j.OsuBeatmapSet;
import com.oopsjpeg.osu4j.backend.EndpointBeatmapSet;
import com.oopsjpeg.osu4j.backend.EndpointBeatmapSet.Arguments;
import com.oopsjpeg.osu4j.backend.EndpointBeatmaps;
import com.oopsjpeg.osu4j.backend.Osu;
import com.oopsjpeg.osu4j.exception.OsuAPIException;

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

	private String id;
	
	
	
	@SuppressWarnings("unused")
	public void BeatmapInfo() throws IllegalStateException, IOException{
		
		MapInfo info = new MapInfo();
		
		// API-Key
		String apikey = "3c29279d7f702fdd1094900daa128d898812b8d8";
		
		
		// API-Reader
		id = info.getMapID();
		String url = "https://osu.ppy.sh/api/get_beatmaps?s=" + id + "&k=" + apikey;
		URL apireq = new URL(url);
		URLConnection con = apireq.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		String arrin = inputLine + "";
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
				
				int genreint = Integer.parseInt(genre) - 1;
				genre = genreint + "";
				
				int langint = Integer.parseInt(language) - 1;
				language = langint + "";
				
			

	}

	public String getAR() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return ar;
			
	}
	
	public String getCS() throws IllegalStateException, IOException {

		BeatmapInfo();
		
		return cs;
		
	}
	
	public String getSR() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return sr;
		
	}
	
	public String getMapper() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return mapper;
		
	}
	
	public String getDuration() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return length;
		
	}
	
	public String getBPM() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return bpm;
		
	}
	
	public String getOD() throws IllegalStateException, IOException {

		BeatmapInfo();
		
		return od;
		
	}
	
	public String getDiffCount() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return diffs;
		
	}
	
	public String getPlays() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return plays;
		
	}
	
	public String getLikes() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return likes;
		
	}
	
	public String getGenre() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return genre;
		
	}
	
	public String getLanguage() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return language;
		
	}
	
	public String getRating() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return rating;
		
	}
	
	public String getUploadDate() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return uploaddate;
		
	}
	
	public String getName() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return name;
		
	}
	
	public String getArtist() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return artist;
		
	}
	
public String getMapperID() throws IllegalStateException, IOException {
		
		BeatmapInfo();
		
		return mapperid;
		
	}
	
	
	
	public String getMapID() {
		
		
		IDRandomizer id = new IDRandomizer();
		
		String temp = id.getRandom();
		return temp;
		
		
		
		
	}
	
	

}
