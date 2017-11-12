package adapters;

import seating.Row;
import seating.Seat;
import thalia.ShowData;
import thalia.Ticket;

public class TicketAdapter {
	String tid;
	double price;
	String status;
	String wid;
	ShowData show_info;
	PatronAdapter patron_info;
	String sid;
	String section_name;
	RowAdapter seating;
	public TicketAdapter(Ticket ticket){
		this.tid=ticket.getTid();
		this.price= ticket.getPrice();
//		this.status= ticket.getStatus();
		this.status = ticket.getStatus().toString();
		this.wid= ticket.getShow().getWid();
		this.show_info= ticket.getShow().getShow_info();
		this.patron_info= new PatronAdapter(ticket.getPatron_info());
		this.sid= ticket.getSection().getSid();
		this.section_name= ticket.getSection().getSection_name();
		for(Row row: ticket.getSection().getRows()){
			for(Seat seat: row.getSeats()){
				if(seat.getCid().equals(ticket.getSeat().getCid())){
					Seat[] ss = {ticket.getSeat()};
					this.seating = new RowAdapter(new Row(ss, row.getRowId()));
					break;
				}
			}
		}
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public ShowData getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowData show_info) {
		this.show_info = show_info;
	}
	public PatronAdapter getPatron_info() {
		return patron_info;
	}
	public void setPatron_info(PatronAdapter patron_info) {
		this.patron_info = patron_info;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public RowAdapter getSeating() {
		return seating;
	}
	public void setSeating(RowAdapter seating) {
		this.seating = seating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patron_info == null) ? 0 : patron_info.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seating == null) ? 0 : seating.hashCode());
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + ((show_info == null) ? 0 : show_info.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		TicketAdapter other = (TicketAdapter) obj;
		if (patron_info == null) {
			if (other.patron_info != null)
				return false;
		} else if (!patron_info.equals(other.patron_info))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seating == null) {
			if (other.seating != null)
				return false;
		} else if (!seating.equals(other.seating))
			return false;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		if (show_info == null) {
			if (other.show_info != null)
				return false;
		} else if (!show_info.equals(other.show_info))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (status != other.status)
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
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
		return "TicketAdapter [tid=" + tid + ", price=" + price + ", status=" + status + ", wid=" + wid + ", show_info="
				+ show_info + ", patron_info=" + patron_info + ", sid=" + sid + ", section_name=" + section_name
				+ ", seating=" + seating + "]";
	}
	

}
