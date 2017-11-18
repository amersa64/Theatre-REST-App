package thalia;
import java.time.LocalDate;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

import seating.Section;
import thalia.Donation.DonationStatus;

public class Theatre {
	private static Theatre instance = null;
		public static synchronized void restart() {
		instance = null;
	}
	public static Theatre getInstance() {
		if (instance == null) {
			instance = new Theatre();
		}
		return instance;
	}
	ArrayList<Show> shows;
	ArrayList<Order> orders;
	ArrayList<Ticket> tickets;
	Queue<Donation> donationsRequest;
	ArrayList<Ticket> donatedTickets;
	ArrayList<Patron> patrons;
	public Ticket findTicketByCid(String cid){
		for(Ticket ticket: this.tickets){
			if(ticket.getSeat().getCid().equals(cid))
				return ticket;
		}
		return null;
	}
	private void updateOrder(Ticket ticket) {
		for(Order ord: this.orders) {
			for(Ticket t: ord.getTickets()) {
				if(t.getTid().equals(ticket.getTid()))
					t=ticket;
			}
		}
	}
	public boolean donateTicketByTid(String tid) {
		for(Ticket t: this.tickets) {
			if(t.getTid().equals(tid)) {
				t.setDonated(true);
				updateOrder(t);
				addD(t);
				return true;
			}	
		}
		return false;
	}
	public void updateDonations(){
		Queue<Donation> temp = new LinkedList<>();
		Donation assignedDonation =null;
		while(!donationsRequest.isEmpty()){
			Donation donR = donationsRequest.poll();
			if(donR.tryAssignTicket()){
				assignedDonation = donR;
				assignedDonation.setStatus(DonationStatus.assigned);
			}else{
				temp.add(donR);
			}
		}
		if(assignedDonation != null)
			temp.add(assignedDonation);
		this.donationsRequest=temp;	
	}
	public void updateShow(Show show){
		for (Show s: shows){
			if(s.getWid().equals(show.getWid()))
				s=show;
		}
	}
	public Show searchShowId(String wid){
		for(Show s: shows){
			if(s.getWid().equals(wid))
				return s;
		}
		return null;
	}
	public Section[] viewShowSections(String wid){
		Show show = searchShowId(wid);
		return show.getSeating_info();
	}
	public ArrayList<Order> viewOrdersByDate(LocalDate startDate, LocalDate endDate){
		ArrayList<Order> orders = new ArrayList<Order>();
		for(Order o: this.orders){
			if((o.getDate_ordered().toLocalDate().isAfter(startDate) || o.getDate_ordered().toLocalDate().isEqual(startDate)) &&  (o.getDate_ordered().toLocalDate().isBefore(endDate) || o.getDate_ordered().toLocalDate().isEqual(endDate))){
				orders.add(o);
			}
		}
		if(orders.isEmpty())
			return null;
		else
			return orders;
	}
	public ArrayList<Show> getShowsBetweenDates(LocalDate startDate, LocalDate endDate){
		if(startDate==null || endDate==null)
			return this.shows; 
		ArrayList<Show> shows = new ArrayList<Show>();
		for(Show show: this.shows){
			if((show.getDate().isAfter(startDate) || show.getDate().isEqual(startDate))&& (show.getDate().isBefore(endDate) || show.getDate().isEqual(endDate)))
				shows.add(show);
		}
		return shows;
	}

	
	//setters and getters and default constructors
	protected Theatre(){
		this.shows = new ArrayList<Show>();
		this.orders = new ArrayList<Order>();
		this.tickets = new ArrayList<Ticket>();
		this.donationsRequest = new LinkedList<>();
		this.donatedTickets = new ArrayList<Ticket>();
		this.patrons = new ArrayList<Patron>();
	}
	public void add(Show show){
		this.shows.add(show);
	}
	public void add(Ticket ticket){
		this.tickets.add(ticket);
	}
	public void add(Order order){
		this.orders.add(order);
	}
	public void add(Donation donatee){
		this.donationsRequest.add(donatee);
		donatee.tryAssignTicket();
	}
	public void addD(Ticket Dticket){
		this.donatedTickets.add(Dticket);
		updateDonations();
	}
	public void add(Patron patron){
		this.patrons.add(patron);
	}
	
	public void delete(Show show){
		this.shows.remove(show);
	}
	public void delete(Ticket ticket){
		this.tickets.remove(ticket);
	}
	public void delete(Order order){
		this.orders.remove(order);
	}
	public void delete(Donation donatee){
		this.donationsRequest.remove(donatee);
	}
	public void delete(Patron patron){
		this.patrons.remove(patron);
	}
	public void deleteD(Ticket dticket){
		this.donatedTickets.remove(dticket);
	}
	
	public Queue<Donation> getDonationsRequest() {
		return donationsRequest;
	}
	public void setDonationsRequest(Queue<Donation> donationsRequest) {
		this.donationsRequest = donationsRequest;
	}
	public ArrayList<Ticket> getDonatedTickets() {
		return donatedTickets;
	}
	public void setDonatedTickets(ArrayList<Ticket> donatedTickets) {
		this.donatedTickets = donatedTickets;
	}
	public ArrayList<Patron> getPatrons() {
		return patrons;
	}
	public void setPatrons(ArrayList<Patron> patrons) {
		this.patrons = patrons;
	}
	public ArrayList<Show> getShows() {
		return shows;
	}
	public void setShows(ArrayList<Show> shows) {
		this.shows = shows;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patrons == null) ? 0 : patrons.hashCode());
		result = prime * result + ((donationsRequest == null) ? 0 : donationsRequest.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((shows == null) ? 0 : shows.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		if (patrons == null) {
			if (other.patrons != null)
				return false;
		} else if (!patrons.equals(other.patrons))
			return false;
		if (donationsRequest == null) {
			if (other.donationsRequest != null)
				return false;
		} else if (!donationsRequest.equals(other.donationsRequest))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (shows == null) {
			if (other.shows != null)
				return false;
		} else if (!shows.equals(other.shows))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
}
