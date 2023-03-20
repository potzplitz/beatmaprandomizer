package randomizer;

import java.util.Random;

public class IDRandomizer {

	
	 
	private static String randNumber;
	public void Random() {
		
		@SuppressWarnings("unused")
		
	
		Random rand = new Random();
		
		int intnumb =  rand.nextInt(999999) + 100000;

		randNumber = 1 + "" + Integer.toString(intnumb);	
		
		System.out.println(randNumber);
	
	}
	

		
		
	
	
	public String getRandom() {

		System.out.println(randNumber);
		
		return randNumber;
		
		}
	
}

