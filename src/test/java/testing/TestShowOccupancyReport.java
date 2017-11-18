package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import reporting.ShowOccupancyReport;
import seating.Row;
import seating.Section;
import seating.Seat.SeatStatus;
import thalia.Show;
import thalia.Theatre;

public class TestShowOccupancyReport {

	@Test
	public void testGetShowOccupancy() {
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
		ShowOccupancyReport sr = new ShowOccupancyReport(show0);
		double correctOcc = 18.0/0.3;
		assertEquals(correctOcc, sr.getOccupancy(),0);
	}

}
