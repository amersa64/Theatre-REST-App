package utility;

public class SeatIDGenerator {
	private static SeatIDGenerator instance = null;
	int idCounter;

	protected SeatIDGenerator() {
		idCounter=0;
		// Exists only to defeat instantiation.
	}
	public synchronized int getNext(){
		return idCounter++;
	}
	public static void reset() {
		getInstance().idCounter = 0;
	}
	public static synchronized SeatIDGenerator getInstance() {
		if (instance == null) {
			instance = new SeatIDGenerator();
		}
		return instance;
	}
	public static void revert() {
		getInstance().idCounter -= 102;
	}
}
