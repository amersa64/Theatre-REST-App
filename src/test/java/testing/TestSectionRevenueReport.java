package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import reporting.SectionRevenueReport;
import seating.Seat;
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;
public class TestSectionRevenueReport {

	@Test
	public void testGetSection_revenue() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre1[0].setPrice(50);
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		Seat seat01 = theatre1[0].findSeatByCid("51");
		Seat seat02 = theatre1[0].findSeatByCid("52");
		Seat seat03 = theatre1[0].findSeatByCid("53");
		Seat[] seats0 = new Seat[]{seat01,seat02,seat03};
		Order ord0 = new Order(show0, theatre1[0], p1, seats0);
		thalia.add(show0);
		thalia.add(ord0);
		SectionRevenueReport srr = new SectionRevenueReport(theatre1[0]);
		assertEquals(150, srr.getSection_revenue(),0);
	}

}
