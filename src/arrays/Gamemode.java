package arrays;

import java.util.ArrayList;

public class Gamemode {
	
	public ArrayList<String> mode = new ArrayList<String>();
	
public void addList() {
	
		mode.add("Standard");
		mode.add("Taiko");
		mode.add("Catch");
		mode.add("Mania");
	
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getGameMode() {

	return mode;
	
	}

}
