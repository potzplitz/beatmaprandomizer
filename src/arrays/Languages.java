package arrays;

import java.util.ArrayList;

public class Languages {
	
	public ArrayList<String> languages = new ArrayList<String>();
	
	public void addLanguages() {
		
		languages.add("Unspecified");
		languages.add("English");
		languages.add("Japanese");
		languages.add("Chinese");
		languages.add("Instrumental");
		languages.add("Korean");
		languages.add("French");
		languages.add("German");
		languages.add("Swedish");
		languages.add("Spanish");
		languages.add("Italian");
		languages.add("Russian");
		languages.add("Polish");
		languages.add("Other");
	
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getLanguages() {
		
		return languages;
		
	}
	

}
