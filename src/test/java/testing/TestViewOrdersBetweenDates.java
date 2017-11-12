package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Test;

import mics.StaticSectionSetup;
import seating.Seat;
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;

public class TestViewOrdersBetweenDates {
	Theatre thalia = Theatre.getInstance();
	LocalDate date1 = LocalDate.of(2017, 11, 4);
	LocalDate date2 = LocalDate.of(2017, 12, 4);
	LocalDate startDate = LocalDate.of(2017, 11, 1);
	LocalDate endDate = LocalDate.of(2017, 12, 1);
	Patron p1;
	Patron p2;
	Seat seat01;
	Seat seat02;
	Seat seat11;
	Seat seat12;
	Show show0;
	Show show1;
	Order ord0;
	Order ord1;
	public static LocalDate randomDate(){
		int month =(int) Math.floor(Math.random()*12);
		int day = (int) Math.floor(Math.random()*30);
		return LocalDate.of(2017,++month,++day);
	}
	public static LocalTime randomTime(){
		int minute = (int) Math.floor(Math.random()*4)*15;
		int hour = (int) Math.floor(Math.random()*24);
		return LocalTime.of(hour++, minute++);
	}



	@Test
	public void testViewShowsBetweenDates(){
		p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		p2 = new Patron("Erica", "Erica@gmail.com", "767878671", "address @ indiana", "123456789762345", "02/26");
		Section[] theatre1 = new Section[3];
		StaticSectionSetup.random=true; 
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		seat01 = theatre1[0].findSeatByCid("154");
		seat02 = theatre1[0].findSeatByCid("153");
		
		Seat[] seats0 = new Seat[]{seat01,seat02};
		theatre1[1] = StaticSectionSetup.section_setup.get("Front left");
		theatre1[2] = StaticSectionSetup.section_setup.get("Front center");
		show0 = new Show(randomTime(), date1, theatre1, "MartinLutherKing", "www.movie.com");
		ord0 = new Order(show0, theatre1[0], p1, seats0);
		StaticSectionSetup._init();
		Section[] theatre2 = new Section[3];
		theatre2[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[1] = StaticSectionSetup.section_setup.get("Main left");
		seat11 = theatre2[1].findSeatByCid("291");
		seat12 = theatre2[1].findSeatByCid("292");
		Seat[] seats1 = {seat11,seat12};
		System.out.println(theatre2[1]);
		theatre2[2] = StaticSectionSetup.section_setup.get("Main center");
		show1 = new Show(randomTime(), date2, theatre2, "Inception", "www.movie.org");
		ord1 = new Order(show0, theatre2[1], p2, seats1);
		thalia.add(show0);
		thalia.add(show1);
		thalia.add(ord0);
		thalia.add(ord1);
		ArrayList<Show> result= thalia.getShowsBetweenDates(startDate, endDate);
		assertTrue(result.size()==1);
		assertTrue(result.get(0).equals(show0));
		ArrayList<Order> orders = new ArrayList<Order>(Arrays.asList(ord0,ord1));
		assertTrue(orders.equals(thalia.viewOrdersByDate(date1, endDate)));
		
	}
	@After
	public void tearDown() throws Exception {
		thalia.delete(show0);
		thalia.delete(show1);
	}

}
