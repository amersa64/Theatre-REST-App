package testing;

import static org.junit.Assert.*;

import java.time.*;
import java.util.ArrayList;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.*;
import thalia.Show;
import thalia.Theatre;

public class TestTheatreGenerator {



	@Test
	public void test() {
		Show[] shows;
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		shows = new Show[3];
		Section[] theatre1 = new Section[3];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre1[1] = StaticSectionSetup.section_setup.get("Front left");
		theatre1[2] = StaticSectionSetup.section_setup.get("Front center");
		shows[0] = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		StaticSectionSetup._init();
		Section[] theatre2 = new Section[3];
		theatre2[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[1] = StaticSectionSetup.section_setup.get("Main left");
		theatre2[2] = StaticSectionSetup.section_setup.get("Main center");
		shows[1] = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre2, "Inception", "www.movie.org");
		thalia.add(shows[0]);
		thalia.add(shows[1]);
		assertFalse(thalia.getShows().get(0).getSeating_info()[0].equals(thalia.getShows().get(1).getSeating_info()[0]));
	}
	@Test
	public void testViewShowsBetweenDates(){
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
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
		Show show0 = new Show(Randomizer.randomTime(), date1, theatre1, "MartinLutherKing", "www.movie.com");
		StaticSectionSetup._init();
		Section[] theatre2 = new Section[3];
		theatre2[0] = StaticSectionSetup.section_setup.get("Main right");
		theatre2[1] = StaticSectionSetup.section_setup.get("Main left");
		theatre2[2] = StaticSectionSetup.section_setup.get("Main center");
		Show show1 = new Show(Randomizer.randomTime(), date2, theatre2, "Inception", "www.movie.org");
		thalia.add(show0);
		thalia.add(show1);
		ArrayList<Show> result= thalia.getShowsBetweenDates(startDate, endDate);
		assertEquals(result.size(),1);
		assertTrue(result.get(0).equals(show0));
		
	}

}
