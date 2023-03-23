package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;

public class UserInfo {
	
	private String rank;
	private String country;
	
	
	private String id;
	
	
	public void PlayerInfo() throws IOException {
		
		MapInfo info = new MapInfo();
		id = info.getMapperID();
		
		// API-Key
		String apikey = "no";
		
		
		// API-Reader
		
		String url = "https://osu.ppy.sh/api/get_user?u=" + id + "&k=" + apikey;
		URL apireq = new URL(url);
		URLConnection con = apireq.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		String arrin = inputLine + "";
		JSONArray a = new JSONArray(arrin);
		
		
		// JSON-Reader
		int i = 0;
		
		rank = a.getJSONObject(i).getString("pp_rank");
		
		
		
	}
	
	public String getPlayerRank() throws IOException {
		
		PlayerInfo();
		
		return rank;
		
	}
	

}
