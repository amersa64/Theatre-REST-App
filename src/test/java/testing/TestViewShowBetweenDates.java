package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.Section;
import thalia.Show;
import thalia.Theatre;

public class TestViewShowBetweenDates {
	Theatre thalia = Theatre.getInstance();
	Show show0;
	Show show1;


	@Test
	public void testViewShowsBetweenDates(){
		LocalDate date1 = LocalDate.of(2017, 11, 4);
		LocalDate date2 = LocalDate.of(2017, 12, 4);
		LocalDate startDate = LocalDate.of(2017, 11, 1);
		LocalDate endDate = LocalDate.now();
		Section[] theatre1 = new Section[3];
		StaticSectionSetup.random=true; 
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre1[1] = StaticSectionSetup.section_setup.get("Front left");
		theatre1[2] = StaticSectionSetup.section_setup.get("Front center");
		show0 = new Show(Randomizer.randomTime(), date1, theatre1, "MartinLutherKing", "www.movie.com");
		StaticSectionSetup._init();
		Section[] theatre2 = new Section[3];
		theatre2[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[1] = StaticSectionSetup.section_setup.get("Main left");
		theatre2[2] = StaticSectionSetup.section_setup.get("Main center");
		show1 = new Show(Randomizer.randomTime(), date2, theatre2, "Inception", "www.movie.org");
		thalia.add(show0);
		thalia.add(show1);
		ArrayList<Show> result= thalia.getShowsBetweenDates(startDate, endDate);
		assertTrue(result.size()==1);
		assertTrue(result.get(0).equals(show0));
		
	}
	@After
	public void tearDown() throws Exception {
		thalia.delete(show0);
		thalia.delete(show1);
	}
}
