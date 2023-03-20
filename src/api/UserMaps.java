package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class UserMaps {
	
	private String allmaps;
	private String status;
	
	private String rankedmaps;
	private String lovedmaps;
	private String pendingmaps;
	private String graveyardmaps;
	private String nominatedmaps;
	
	
	
	private String id;
	
	
	public void getUserMaps() throws IllegalStateException, IOException, InterruptedException {
		
		// API-Key
		String apikey = "3c29279d7f702fdd1094900daa128d898812b8d8";
		
		
		MapInfo info = new MapInfo();
		id = info.getMapperID();
		// API-Reader
		
		String url = "https://osu.ppy.sh/api/get_beatmaps?u=" + id + "&k=" + apikey;
		URL apireq = new URL(url);
		URLConnection con = apireq.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		String arrin = inputLine + "";
		
		System.out.println(url);
		JSONArray a = new JSONArray(arrin);
		
		
		// JSON reader
		
		
		
		
		
		
		// Map Sorter
	/*	
		ArrayList<String> arr4 = new ArrayList<String>();
		ArrayList<String> arr3 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr0 = new ArrayList<String>();
		ArrayList<String> arr_1 = new ArrayList<String>();
		ArrayList<String> arr4_2 = new ArrayList<String>();
		
		
		arr4.add(a.getJSONObject(i).getString(""));
		
		*/
		 
		 int arr4 = 0;
		 int arr3 = 0;
		 int arr2 = 0;
		 int arr1 = 0;
		 int arr0 = 0;
		 int arr_1 = 0;
		 int arr_2 = 0;
		
		
		 
		for(int i = 0; i < a.length(); i++) {
			
			Thread.sleep(5);
			
			status = a.getJSONObject(i).getString("approved");

			int mapstatus = Integer.parseInt(status);
			
			System.out.println(mapstatus);
			
			switch(mapstatus) {
			
			case 4:
				arr4++;
				break;
			
			case 3:
				arr3++;
				break;
			
			case 2:
				arr2++;
				break;
				
			case 1:
				arr1++;
				break;
				
			case 0:
				arr0++;
				break;
				
			case -1:
				arr_1++;
				break;
				
			case -2:
				arr_2++;
				break;
			}
			
			
		}
		
		System.out.println(" loved: " + arr4 + " qualified: " + arr3 + " approved: " + arr2 + " ranked: " + arr1 + " pending: " + arr0 + " WIP: " + arr_1 + " graveyard: " + arr_2);
	            
	            
		
	}
	
	public String getMaps() {
		
		return allmaps;
		
	}
	

}
