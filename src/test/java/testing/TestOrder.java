package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.Seat;
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;

public class TestOrder {

	@Test
	public void testConfirmOrder() {
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
		Order o = Order.confirmOrder(wid, sid, p1, seats0);
		assertEquals(o.getOid(),"0");
		assertEquals(o.getNumber_of_tickets(), seats0.length);
		
		sid = "124";
		o = Order.confirmOrder(wid, sid, p1, seats0);
		
		assertNull(o);
		
		wid = "1";
		sid = "123";
		o = Order.confirmOrder(wid, sid, p1, seats0);
		assertNull(o);
		
		seat01 = theatre1[0].findSeatByCid("100");
		seats0[0] = seat01;
		o = Order.confirmOrder(wid, sid, p1, seats0);
		assertNull(o);
	}
	@Test
	public void testViewOrders() {
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
		assertTrue(theatre1[0].checkSeat(seat01));
		Order o1 = Order.confirmOrder(wid, sid, p1, seats0);
		
		assertFalse(theatre1[0].checkSeat(seat01));
		Order o3 = Order.viewOrder("1");
		assertNull(o3);
		
		Order o2 = Order.viewOrder("0");
		assertEquals(o2, o1);
		
	}
	
	@Test
	public void testViewOrdersByDate() {
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
		Show show1 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKong", "www.movie.com");
		wid = show1.getWid();
		thalia.add(show1);
		Seat seat03 = theatre1[0].findSeatByCid("2");
		Seat seat04 = theatre1[0].findSeatByCid("3");
		Seat[] seats1 = new Seat[] {seat03,seat04};
		Order o2 = Order.confirmOrder(wid, sid, p1, seats1);
		thalia.add(o2);
		
		LocalDateTime testdate1 = LocalDateTime.of(2017, 11, 01, 11, 11);
		LocalDateTime testdate2 = LocalDateTime.of(2017, 12, 01, 11, 11);
		thalia.getOrders().get(0).setDate_ordered(testdate1);
		thalia.getOrders().get(1).setDate_ordered(testdate2);
		LocalDate lt1 = LocalDate.of(2017, 10, 10);		
		LocalDate lt2 = LocalDate.of(2017, 12, 12);		
		LocalDate lt3 = LocalDate.of(2017, 11, 15); 
		
		
		ArrayList<Order> listofOrders = thalia.viewOrdersByDate(lt1, lt2);
		assertEquals(listofOrders.get(0), o1);
		assertEquals(listofOrders.get(1), o2);
		
		listofOrders = thalia.viewOrdersByDate(lt1, lt3);
		assertEquals(listofOrders.get(0), o1);
		assertEquals(listofOrders.size(), 1);
		
		listofOrders = thalia.viewOrdersByDate(lt3, lt2);
		assertEquals(listofOrders.get(0), o2);
		
		listofOrders = thalia.viewOrdersByDate(lt2, lt2);
		assertNull(listofOrders);
		
		listofOrders = thalia.viewOrdersByDate(lt1, lt1);
		assertNull(listofOrders);
	}


}
