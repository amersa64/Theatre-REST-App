package utility;

public class TicketIDGenerator {
	private static TicketIDGenerator instance = null;
	int idCounter;

	protected TicketIDGenerator() {
		idCounter=0;
		// Exists only to defeat instantiation.
	}
	public int getNext(){
		return idCounter++;
	}

	public static TicketIDGenerator getInstance() {
		if (instance == null) {
			instance = new TicketIDGenerator();
		}
		return instance;
	}
	public static void reset() {
		getInstance().idCounter = 0;
	}
}
