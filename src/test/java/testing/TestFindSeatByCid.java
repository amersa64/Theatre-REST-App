package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.StaticSectionSetup;
import seating.Seat;
import seating.Section;

public class TestFindSeatByCid {

	@Test
	public void test() {
		Section[] theatre1 = new Section[3];
		StaticSectionSetup.random=true; 
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		Seat seat01 = theatre1[0].findSeatByCid("51");
		Seat seat02 = theatre1[0].getRows()[0].getSeats()[0];
		assertTrue(seat01.equals(seat02));
	}

}
