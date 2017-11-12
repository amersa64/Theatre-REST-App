package thalia;


import seating.*;
import utility.TicketIDGenerator;

public class Ticket {
	public enum TicketStatus{
		open, used
	}
	boolean donated;
	String tid;
	double price;
	TicketStatus status;
	Show show;
	Patron patron_info;
	Section section;
	Seat seat;
	public Ticket(Show show, Section section, Seat seat, Patron patron_info) {
		this.tid= String.valueOf(TicketIDGenerator.getInstance().getNext());
		this.price=section.getPrice();
		this.status = TicketStatus.open;
		this.donated=false;
		this.show = show;
		this.section=section;
		this.seat = seat;
		this.patron_info = patron_info;
	}
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Patron getPatron_info() {
		return patron_info;
	}

	public void setPatron_info(Patron patron_info) {
		this.patron_info = patron_info;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	

	public boolean isDonated() {
		return donated;
	}
	public void setDonated(boolean donated) {
		this.donated = donated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (donated ? 1231 : 1237);
		result = prime * result + ((patron_info == null) ? 0 : patron_info.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		Ticket other = (Ticket) obj;
		if (donated != other.donated)
			return false;
		if (patron_info == null) {
			if (other.patron_info != null)
				return false;
		} else if (!patron_info.equals(other.patron_info))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
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
		if (status != other.status)
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [donated=" + donated + ", tid=" + tid + ", price=" + price + ", status=" + status + ", show="
				+ show + ", patron_info=" + patron_info + ", section=" + section + ", seat=" + seat + "]";
	}


	
	
	

}
