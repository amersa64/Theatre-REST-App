package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.Seat;
import seating.Section;
import thalia.Donation;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;
import thalia.Ticket;
import thalia.Donation.DonationStatus;

public class TestDonation {

	@Test
	public void testPending() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Patron p2 = new Patron("Erica", "Erica@gmail.com", "767878671", "address @ indiana", "123456789762345", "02/26");
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
		thalia.donateTicketByTid("0");
 		Donation don0 = new Donation(2,show0,p2);
		assertEquals(don0.getStatus(),DonationStatus.pending);
		assertTrue(donatedTicket.isDonated());
		assertFalse(thalia.getDonationsRequest().isEmpty());
		assertTrue(thalia.getDonatedTickets().isEmpty());
	}
	@Test
	public void testAssigned() {
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		Patron p2 = new Patron("Erica", "Erica@gmail.com", "767878671", "address @ indiana", "123456789762345", "02/26");
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
		thalia.donateTicketByTid("0");
		donatedTicket.setDonated(true);
		assertTrue(thalia.getDonatedTickets().contains(donatedTicket));
		Donation don0 = new Donation(1,show0,p2);
		assertEquals(don0.getStatus(),DonationStatus.assigned);
		assertTrue(donatedTicket.isDonated());
		assertTrue(thalia.getDonationsRequest().isEmpty());
		assertTrue(thalia.getDonatedTickets().isEmpty());
	}



}
