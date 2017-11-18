package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import reporting.TheatreRevenueReport;
import seating.Seat;
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;

public class TestTheatreRevenueReport {

	@Test
	public void testGetOverall_revenue() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Section[] theatre1 = new Section[1];
		Section[] theatre2 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[0] = StaticSectionSetup.section_setup.get("Main left");
		theatre1[0].setPrice(50);
		theatre2[0].setPrice(100);
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		Show show1 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre2, "KingKong", "www.kingKong.com");
		Seat seat01 = theatre1[0].findSeatByCid("51");
		Seat seat02 = theatre1[0].findSeatByCid("52");
		Seat seat03 = theatre1[0].findSeatByCid("53");
		Seat[] seats0 = new Seat[]{seat01,seat02,seat03};
		Order ord0 = new Order(show0, theatre1[0], p1, seats0);
		Seat seat11 = theatre2[0].findSeatByCid("87");
		Seat seat12 = theatre2[0].findSeatByCid("88");
		Seat seat13 = theatre2[0].findSeatByCid("89");
		Seat[] seats1 = new Seat[]{seat11,seat12,seat13};
		Order ord1 = new Order(show0, theatre2[0], p1, seats1);
		thalia.add(show0);
		thalia.add(show1);
		thalia.add(ord1);
		thalia.add(ord0);
		thalia.donateTicketByTid("0");
		thalia.donateTicketByTid("3");
		TheatreRevenueReport tor = new TheatreRevenueReport();
		double correctRev = 450;
		assertEquals(correctRev, tor.getOverall_revenue(),0);
	}

}
