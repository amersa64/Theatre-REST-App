package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import reporting.ShowRevenueReport;
import seating.Row;
import seating.Section;
import seating.Seat.SeatStatus;
import thalia.Show;
import thalia.Theatre;

public class TestShowRevenueReport {

	@Test
	public void testGetRevenue() {
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
		theatre1[0].setPrice(100);
		theatre1[1].setPrice(50);
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		ShowRevenueReport sr = new ShowRevenueReport(show0);
		double correctRevenue = 900+450;
		assertEquals(correctRevenue, sr.getRevenue(),0);
	}

}
