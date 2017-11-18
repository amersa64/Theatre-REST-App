package thalia;

import java.util.ArrayList;

import utility.DonationIDGenerator;

public class Donation {
	String did;
	public enum DonationStatus{
		pending, assigned 
	}
	DonationStatus status;
	int count;
	ArrayList<Ticket> tickets;
	Show show;
	Patron patron_info;
	public Donation(int count,Show show,Patron patron_info ){
		this.did= String.valueOf(DonationIDGenerator.getInstance().getNext());
		this.status= DonationStatus.pending;
		this.count=count;
		this.tickets= new ArrayList<Ticket>();
		this.show= show;
		this.patron_info=patron_info;
		Theatre.getInstance().add(this);
	}
	public Donation(String did, DonationStatus status, int count, ArrayList<Ticket> tickets, Show show,
			Patron patron_info) {
		super();
		this.did = did;
		this.status = status;
		this.count = count;
		this.tickets = tickets;
		this.show = show;
		this.patron_info = patron_info;
		Theatre.getInstance().add(this);
	}
	public boolean tryAssignTicket(){
		for(Ticket ticket: Theatre.getInstance().getDonatedTickets()){
			if(ticket.getShow().getWid().equals(this.show.getWid())){
				add(ticket);
				updateStatus();
				Theatre.getInstance().deleteD(ticket);
				return true;
			}
		}
		return false;
	}
//	public boolean tryAssignTicket(){
//		ArrayList<Ticket> validTickets = new ArrayList<Ticket>();
//		for(Ticket ticket: Theatre.getInstance().getDonatedTickets()){
//			if(ticket.getShow().getWid().equals(this.show.getWid()) && validTickets.size() < this.count){
//				validTickets.add(ticket);
//			}
//		}
//		if (validTickets.size() != 0) {
//			for (Ticket valtix : validTickets) {
//				valtix.setDonated(true);
//				add(valtix);
//				updateStatus();
//				Theatre.getInstance().deleteD(valtix);
//			}
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	private void updateStatus(){
		if(this.count==this.tickets.size()) {
			this.status=DonationStatus.assigned;
			Theatre.getInstance().delete(this);
			}
	}
	public void add(Ticket ticket){
		this.tickets.add(ticket);
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public DonationStatus getStatus() {
		return status;
	}
	public void setStatus(DonationStatus status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Patron getPatron_info() {
		return patron_info;
	}
	public void setPatron_info(Patron patron_info) {
		this.patron_info = patron_info;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		result = prime * result + ((patron_info == null) ? 0 : patron_info.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Donation other = (Donation) obj;
		if (count != other.count)
			return false;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		if (patron_info == null) {
			if (other.patron_info != null)
				return false;
		} else if (!patron_info.equals(other.patron_info))
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		if (status != other.status)
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Donation [did=" + did + ", status=" + status + ", count=" + count + ", tickets="
				+ tickets + ", show=" + show + ", patron_info=" + patron_info + "]";
	}
	
	

}
