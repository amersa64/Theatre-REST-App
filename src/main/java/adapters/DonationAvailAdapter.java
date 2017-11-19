package adapters;

import java.util.ArrayList;

import thalia.Donation;
import thalia.Patron;
import thalia.Ticket;

public class DonationAvailAdapter {
	protected String did;
	protected String wid;	
	protected int count;
	protected String status;
	protected ArrayList<String> tickets;
	protected Patron patron_info;
	
	public DonationAvailAdapter(Donation d){
		this.wid = d.getShow().getWid();
		this.did= d.getDid();
		this.count= d.getCount();
		this.status= d.getStatus().toString();
		this.patron_info = d.getPatron_info();
		this.tickets = new ArrayList<String>();
		for (Ticket ticket : d.getTickets()) {
			this.tickets.add(ticket.getTid());
		}
	}

	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<String> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<String> tickets) {
		this.tickets = tickets;
	}
	public Patron getPatron_info() {
		return patron_info;
	}
	public void setPatron_info(Patron patron_info) {
		this.patron_info = patron_info;
	}
	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		result = prime * result + ((patron_info == null) ? 0 : patron_info.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
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
		DonationAvailAdapter other = (DonationAvailAdapter) obj;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonationAvailAdapter [did=" + did + ", wid=" + wid + ", count=" + count + ", status=" + status
				+ ", tickets=" + tickets + ", patron_info=" + patron_info + "]";
	}
	
	
	
}
