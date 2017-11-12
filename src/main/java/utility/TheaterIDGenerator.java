package utility;

public class TheaterIDGenerator {
	private static TheaterIDGenerator instance = null;
	int idCounter;

	protected TheaterIDGenerator() {
		idCounter=0;
		
		// Exists only to defeat instantiation.
	}
	public int getNext(){
		return idCounter++;
	}

	public static TheaterIDGenerator getInstance() {
		if (instance == null) {
			instance = new TheaterIDGenerator();
		}
		return instance;
	}
}
