package utility;

public class OrderIDGenerator {
	private static OrderIDGenerator instance = null;
	int idCounter;

	protected OrderIDGenerator() {
		idCounter=0;
		// Exists only to defeat instantiation.
	}
	public int getNext(){
		return idCounter++;
	}
	public void reset(){
		idCounter =0;
	}

	public static OrderIDGenerator getInstance() {
		if (instance == null) {
			instance = new OrderIDGenerator();
		}
		return instance;
	}
}
