package utility;

public class ShowIDGenerator {
	private static ShowIDGenerator instance = null;
	int idCounter;

	protected ShowIDGenerator() {
		idCounter=0;
		
		// Exists only to defeat instantiation.
	}
	public int getNext(){
		return idCounter++;
	}

	public static ShowIDGenerator getInstance() {
		if (instance == null) {
			instance = new ShowIDGenerator();
		}
		return instance;
	}
}
