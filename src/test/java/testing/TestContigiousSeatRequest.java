package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.After;
import org.junit.Test;

import mics.StaticSectionSetup;
import seating.Row;
import seating.Seat;
import seating.Seat.SeatStatus;
import seating.Section;
import thalia.Theatre;

public class TestContigiousSeatRequest {
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

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindsSeats() {
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
		Row r = theatre1[0].reqNewSeats(2, 0, 1);
		Seat seat01 = theatre1[0].findSeatByCid("54");
		Seat seat02 = theatre1[0].findSeatByCid("55");
		Seat[] seats0 = new Seat[]{seat01,seat02};
		Row correctR = new Row(seats0, "5");
		assertEquals(r,correctR);
	}
	@Test
	public void testGoToNextRow() {
		Theatre.restart();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		for(Row row: theatre1[0].getRows()) {
			if(row.getRowId().equals("5"))
				row.getSeats()[3].setStatus(SeatStatus.sold);
			for(int i = 0; i<row.getSeats().length;i++) {
				if(i==0 || i==1 || (i+1)%3==0) 
					row.getSeats()[i].setStatus(SeatStatus.sold);
			}
		}
		Row r = theatre1[0].reqNewSeats(2, 0, 1);
		Seat seat01 = theatre1[0].findSeatByCid("59");
		Seat seat02 = theatre1[0].findSeatByCid("60");
		Seat[] seats0 = new Seat[]{seat01,seat02};
		Row correctR = new Row(seats0, "6");
		assertEquals(r,correctR);
	}
	@Test
	public void testReturnsNull() {
		Theatre.restart();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		for(Row row: theatre1[0].getRows()) {
			if(row.getRowId().equals("5"))
				row.getSeats()[3].setStatus(SeatStatus.sold);
			for(int i = 0; i<row.getSeats().length;i++) {
				if(i==0 || i==1 || (i+1)%3==0) 
					row.getSeats()[i].setStatus(SeatStatus.sold);
			}
		}
		Row r = theatre1[0].reqNewSeats(4, 0, 0);
		Row correctR = null;
		assertEquals(r,correctR);
	}


}
