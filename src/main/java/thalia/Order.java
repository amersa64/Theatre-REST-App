package thalia;

import java.time.LocalDateTime;
import java.util.Arrays;

import seating.*;
import seating.Seat.SeatStatus;
import utility.OrderIDGenerator;

public class Order {
	String oid; 
	LocalDateTime date_ordered; 
	double order_amount; //calculated
	int number_of_tickets; //inferred
	Patron patron_info;
	Show show;
	Section section;
	Seat[] seats; 
	Ticket[] tickets;//generated
	
	public Order(Show show,Section section, Patron patron_info, Seat[] seats){
		this.patron_info = patron_info;
		for (int k = 0; k < section.getRows().length; k++){ //Traverse through rows in section
			for (int l = 0; l < section.getRows()[k].getSeats().length; l++){ //Traverse through seats in row
				for (int m = 0; m < seats.length; m++){ //Traverse each seat requested
					if (section.getRows()[k].getSeats()[l].getCid().equals(seats[m].getCid())){ //Check to see if this is a seat requested
						if (section.getRows()[k].getSeats()[l].getStatus().equals(SeatStatus.sold)) //Check to see if this seat is sold
							return;
						else
							section.getRows()[k].getSeats()[l].setStatus(SeatStatus.sold);
					}
				}
			}
		}
		show.updateSection(section);
		Theatre.getInstance().updateShow(show);
		this.show = show;
		this.section = section;
		this.date_ordered = LocalDateTime.now();
		this.order_amount = seats.length*section.getPrice();
		this.number_of_tickets = seats.length;
		this.oid= String.valueOf(OrderIDGenerator.getInstance().getNext());
		Ticket[] tickets = new Ticket[seats.length];
		for(int i=0; i<seats.length; i++){
			tickets[i] = new Ticket(show,section,seats[i], this.patron_info);
			Theatre.getInstance().add(tickets[i]);
		}
		this.tickets = tickets;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public LocalDateTime getDate_ordered() {
		return date_ordered;
	}

	public void setDate_ordered(LocalDateTime date_ordered) {
		this.date_ordered = date_ordered;
	}

	public double getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}

	public int getNumber_of_tickets() {
		return number_of_tickets;
	}

	public void setNumber_of_tickets(int number_of_tickets) {
		this.number_of_tickets = number_of_tickets;
	}

	public Patron getPatron_info() {
		return patron_info;
	}

	public void setPatron_info(Patron patron_info) {
		this.patron_info = patron_info;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}

	public Ticket[] getTickets() {
		return tickets;
	}

	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_ordered == null) ? 0 : date_ordered.hashCode());
		result = prime * result + number_of_tickets;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(order_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((patron_info == null) ? 0 : patron_info.hashCode());
		result = prime * result + Arrays.hashCode(seats);
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		result = prime * result + Arrays.hashCode(tickets);
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
		Order other = (Order) obj;
		if (date_ordered == null) {
			if (other.date_ordered != null)
				return false;
		} else if (!date_ordered.equals(other.date_ordered))
			return false;
		if (number_of_tickets != other.number_of_tickets)
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Double.doubleToLongBits(order_amount) != Double.doubleToLongBits(other.order_amount))
			return false;
		if (patron_info == null) {
			if (other.patron_info != null)
				return false;
		} else if (!patron_info.equals(other.patron_info))
			return false;
		if (!Arrays.equals(seats, other.seats))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		if (!Arrays.equals(tickets, other.tickets))
			return false;
		return true;
	}

	public Order(String oid, LocalDateTime date_ordered, double order_amount, int number_of_tickets, Patron patron_info,
			Show show, Section section, Seat[] seats, Ticket[] tickets) {
		super();
		this.oid = oid;
		this.date_ordered = date_ordered;
		this.order_amount = order_amount;
		this.number_of_tickets = number_of_tickets;
		this.patron_info = patron_info;
		this.show = show;
		this.section = section;
		this.seats = seats;
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", date_ordered=" + date_ordered + ", order_amount=" + order_amount
				+ ", number_of_tickets=" + number_of_tickets + ", patron_info=" + patron_info 
				+ ", show=" + show
				+ ", section=" + section + ", seats=" + Arrays.toString(seats) + ", tickets=" + Arrays.toString(tickets)
				+ "]";
	}

	
}