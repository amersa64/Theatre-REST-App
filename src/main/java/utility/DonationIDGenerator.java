package utility;

public class DonationIDGenerator {
	private static DonationIDGenerator instance = null;
	int idCounter;

	protected DonationIDGenerator() {
		idCounter=0;
		
		// Exists only to defeat instantiation.
	}
	public synchronized int getNext(){
		return idCounter++;
	}

	public static synchronized DonationIDGenerator getInstance() {
		if (instance == null) {
			instance = new DonationIDGenerator();
		}
		return instance;
	}
}
