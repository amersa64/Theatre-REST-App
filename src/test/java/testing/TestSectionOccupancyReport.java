package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.StaticSectionSetup;
import reporting.SectionOccupancyReport;
import seating.Row;
import seating.Section;
import seating.Seat.SeatStatus;
import thalia.Theatre;

public class TestSectionOccupancyReport {

	@Test
	public void testGetSection_occupancy() {
		Theatre.restart();
		Section[] theatre1 = new Section[1];
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
		SectionOccupancyReport sr = new SectionOccupancyReport(theatre1[0]);
		double correctOcc = 9.0/15.0*100;
		assertEquals(correctOcc,sr.getSection_occupancy(),0);
	}

}
