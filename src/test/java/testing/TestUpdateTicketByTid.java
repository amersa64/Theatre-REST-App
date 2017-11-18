package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import adapters.TicketOrderAdapter;
import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.Seat;
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;
import thalia.Ticket;
import thalia.Ticket.TicketStatus;

public class TestUpdateTicketByTid {
	@Test
	public void testSuccess() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		Seat seat01 = theatre1[0].findSeatByCid("51");
		Seat seat02 = theatre1[0].findSeatByCid("52");
		Seat[] seats0 = new Seat[]{seat01,seat02};
		Order ord0 = new Order(show0, theatre1[0], p1, seats0);
		thalia.add(show0);
		thalia.add(ord0);
		Ticket donatedTicket = ord0.getTickets()[0];
		assertNotEquals(donatedTicket.getStatus(),TicketStatus.used);
		TicketOrderAdapter toa = thalia.updateTicketByTid("0");
		Ticket t  = thalia.findTicketByTid("0");
		assertEquals(t.getStatus(),TicketStatus.used);
		assertEquals(thalia.getOrders().get(0).getTickets()[0],t);
		assertEquals(toa.getStatus(),"used");
	}
	@Test
	public void testFail() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Main right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		Seat seat01 = theatre1[0].findSeatByCid("51");
		Seat seat02 = theatre1[0].findSeatByCid("52");
		Seat[] seats0 = new Seat[]{seat01,seat02};
		Order ord0 = new Order(show0, theatre1[0], p1, seats0);
		thalia.add(show0);
		thalia.add(ord0);
		Ticket donatedTicket = ord0.getTickets()[0];
		assertNotEquals(donatedTicket.getStatus(),TicketStatus.used);
		TicketOrderAdapter toa = thalia.updateTicketByTid("20");
		Ticket t  = thalia.findTicketByTid("20");
		assertNull(t);
		assertNull(toa);
		
	}
}
