package testing;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Test;

import adapters.SeatRequestAdapter;
import mics.StaticSectionSetup;
import seating.Row;
import seating.Seat;
import seating.Seat.SeatStatus;
import seating.Section;
import thalia.Show;
import thalia.Theatre;

public class TestContigiousSeatRequest {

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
		assertNull(r);
	}
	@Test
	public void testNullRequestSeatsWithoutStartingCid() {
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
		Show s = new Show();
		s.setSeating_info(theatre1);
		SeatRequestAdapter  sra = s.requestSeats("126", 4, "");
		Row r = theatre1[0].reqNewSeats(4, 0, 0);
		assertNull(r);
		assertTrue(sra.getSeating().isEmpty());
	}
	@Test
	public void testRequestSeatsWithoutStartingCid() {
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
		Show s = new Show();
		s.setSeating_info(theatre1);
		SeatRequestAdapter  sra = s.requestSeats("126", 2, "");
		assertEquals(sra.getSeating().get(0).getSeats()[0].getCid(), "59");
		assertEquals(sra.getSeating().get(0).getSeats()[1].getCid(), "60");
		assertEquals(sra.getStatus(),"ok");
		assertEquals(sra.getStarting_seat_id(),"59");
		assertNotEquals(sra.getTotal_amount(),0);
	}
	@Test
	public void testRequestSeatsWithStartingCid() {
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
		Show s = new Show();
		s.setSeating_info(theatre1);
		SeatRequestAdapter  sra = s.requestSeats("126", 2, "60");
		assertEquals(sra.getSeating().get(0).getSeats()[0].getCid(), "64");
		assertEquals(sra.getSeating().get(0).getSeats()[1].getCid(), "65");
		assertEquals(sra.getSeating().get(0).getRow(), "7");
		assertEquals(sra.getStatus(),"ok");
		assertEquals(sra.getStarting_seat_id(),"60");
		assertNotEquals(sra.getTotal_amount(),0);
	}
	@Test
	public void testNullRequestSeatsWithStartingCid() {
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
		Show s = new Show();
		s.setSeating_info(theatre1);
		SeatRequestAdapter  sra = s.requestSeats("126", 3, "60");
		assertTrue(sra.getSeating().isEmpty());
		assertNotEquals(sra.getStatus(),"ok");
		assertEquals(sra.getStarting_seat_id(),"60");
		assertEquals(sra.getTotal_amount(), 0.0, 0);
	}
	


}
