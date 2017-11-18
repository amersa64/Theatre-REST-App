package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.StaticSectionSetup;
import reporting.SectionReport;
import seating.Row;
import seating.Section;
import seating.Seat.SeatStatus;
import thalia.Theatre;

public class TestSectionReport {

	@Test
	public void testGetSeats_available() {
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
		SectionReport sr = new SectionReport(theatre1[0]);
		assertEquals(sr.getSeats_available(),15);
	}

	@Test
	public void testGetSeats_sold() {
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
		SectionReport sr = new SectionReport(theatre1[0]);
		assertEquals(sr.getSeats_sold(),9);
	}

}
