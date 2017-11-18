package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import adapters.OrderAdapter;
import adapters.OrderSearchAdapter;
import adapters.ShowAdapter;
import adapters.ShowSearchAdapter;
import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.Seat;
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;

public class TestSearch {

	@Test
	public void testShowSearch() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		ShowAdapter sa0 = new ShowAdapter(show0);
		Show show1 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKong", "www.movie.com");
		thalia.add(show1);
		ShowAdapter sa1 = new ShowAdapter(show1);
		ArrayList<ShowAdapter> saal = ShowSearchAdapter.searchShows("King");
		assertEquals(saal.get(0), sa0);
		assertNotEquals(saal.get(0), sa1);
		
		saal = ShowSearchAdapter.searchShows("Kong");
		assertEquals(saal.get(0), sa1);
		assertNotEquals(saal.get(0), sa0);
		
		saal = ShowSearchAdapter.searchShows("MartinLuther");
		assertEquals(saal.get(0), sa0);
		assertEquals(saal.get(1), sa1);
		
		saal = ShowSearchAdapter.searchShows("Martin Luther King");
		assertEquals(saal.size(), 0);
	}
	@Test
	public void testOrderSearch() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		
		Seat seat01 = theatre1[0].findSeatByCid("0");
		Seat seat02 = theatre1[0].findSeatByCid("1");
		String wid = show0.getWid();
		String sid = "123";
		Seat[] seats0 = new Seat[]{seat01,seat02};
		Order o1 = Order.confirmOrder(wid, sid, p1, seats0);
		OrderAdapter oa1 = new OrderAdapter(o1);
		Show show1 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKong", "www.movie.com");
		wid = show1.getWid();
		thalia.add(show1);
		Seat seat03 = theatre1[0].findSeatByCid("2");
		Seat seat04 = theatre1[0].findSeatByCid("3");
		Seat[] seats1 = new Seat[] {seat03,seat04};
		Order o2 = Order.confirmOrder(wid, sid, p1, seats1);
		thalia.add(o2);
		OrderAdapter oa2 = new OrderAdapter(o2);
//		System.out.println(oa2);
		ArrayList<OrderAdapter> oaal = OrderSearchAdapter.searchOrders("King");
		assertEquals(oaal.get(0), oa1);
		assertNotEquals(oaal.get(0), oa2);
		oaal = OrderSearchAdapter.searchOrders("Kong");
		assertEquals(oaal.get(0), oa2);
		assertNotEquals(oaal.get(0), oa1);
		
	}
	

}
