package testing;

import static org.junit.Assert.*;

import java.time.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mics.StaticSectionSetup;
import seating.*;
import thalia.Show;
import thalia.Theatre;

public class TheatreTest {
	Show[] shows;
	Theatre thalia = Theatre.getInstance();
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
	@Before
	public void setUp(){
		shows = new Show[3];
		Section[] theatre1 = new Section[3];
		StaticSectionSetup.random=true; 
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre1[1] = StaticSectionSetup.section_setup.get("Front left");
		theatre1[2] = StaticSectionSetup.section_setup.get("Front center");
		shows[0] = new Show(randomTime(), randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		StaticSectionSetup._init();
		Section[] theatre2 = new Section[3];
		theatre2[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[1] = StaticSectionSetup.section_setup.get("Main left");
		theatre2[2] = StaticSectionSetup.section_setup.get("Main center");
		shows[1] = new Show(randomTime(), randomDate(), theatre2, "Inception", "www.movie.org");
//		StaticSectionSetup._init();
//		Section[] theatre = new Section[3];
//		theatre[0] = StaticSectionSetup.section_setup.get("Main right");
//		theatre[1] = StaticSectionSetup.section_setup.get("Front left");
//		theatre[2] = StaticSectionSetup.section_setup.get("Main center");
//		shows[2] = new Show(randomTime(), randomDate(), theatre, "HakunaMata", "www.IMBD.com");
		thalia.add(shows[0]);
		thalia.add(shows[1]);
	}

	@Test
	public void test() {
		assertFalse(thalia.getShows().get(0).getSeating_info()[0].equals(thalia.getShows().get(1).getSeating_info()[0]));
	}
	@Test
	public void testViewShowsBetweenDates(){
		LocalDate date1 = LocalDate.of(2017, 11, 4);
		LocalDate date2 = LocalDate.of(2017, 12, 4);
		LocalDate startDate = LocalDate.of(2017, 11, 1);
		LocalDate endDate = LocalDate.now();
		Section[] theatre1 = new Section[3];
		StaticSectionSetup.random=true; 
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre1[1] = StaticSectionSetup.section_setup.get("Front left");
		theatre1[2] = StaticSectionSetup.section_setup.get("Front center");
		Show show0 = new Show(randomTime(), date1, theatre1, "MartinLutherKing", "www.movie.com");
		StaticSectionSetup._init();
		Section[] theatre2 = new Section[3];
		theatre2[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[1] = StaticSectionSetup.section_setup.get("Main left");
		theatre2[2] = StaticSectionSetup.section_setup.get("Main center");
		Show show1 = new Show(randomTime(), date2, theatre2, "Inception", "www.movie.org");
		thalia.add(show0);
		thalia.add(show1);
		ArrayList<Show> result= thalia.getShowsBetweenDates(startDate, endDate);
		assertTrue(result.size()==1);
		assertTrue(result.get(0).equals(show0));
		
	}

}
