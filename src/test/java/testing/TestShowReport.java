package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import reporting.ShowReport;
import seating.Row;
import seating.Section;
import seating.Seat.SeatStatus;
import thalia.Show;
import thalia.Theatre;

public class TestShowReport {

	@Test
	public void testGetSeats_available() {
		Theatre.restart();
		Section[] theatre1 = new Section[2];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		for(Row row: theatre1[0].getRows()) {
			for(int i = 0; i<row.getSeats().length;i++) {
				if(i==0 || i==1 || (i+1)%3==0) 
					row.getSeats()[i].setStatus(SeatStatus.sold);
			}
		}
		theatre1[1] = StaticSectionSetup.section_setup.get("Main left");
		for(Row row: theatre1[1].getRows()) {
			for(int i = 0; i<row.getSeats().length;i++) {
				if(i==0 || i==1 || (i+1)%3==0) 
					row.getSeats()[i].setStatus(SeatStatus.sold);
			}
		}
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		ShowReport sr = new ShowReport(show0);
		assertEquals(sr.getSeats_available(),30);
	}

	@Test
	public void testGetSeats_sold() {
		Theatre.restart();
		Section[] theatre1 = new Section[2];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		for(Row row: theatre1[0].getRows()) {
			for(int i = 0; i<row.getSeats().length;i++) {
				if(i==0 || i==1 || (i+1)%3==0) 
					row.getSeats()[i].setStatus(SeatStatus.sold);
			}
		}
		theatre1[1] = StaticSectionSetup.section_setup.get("Main left");
		for(Row row: theatre1[1].getRows()) {
			for(int i = 0; i<row.getSeats().length;i++) {
				if(i==0 || i==1 || (i+1)%3==0) 
					row.getSeats()[i].setStatus(SeatStatus.sold);
			}
		}
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		ShowReport sr = new ShowReport(show0);
		assertEquals(sr.getSeats_sold(),18);
	}

}
