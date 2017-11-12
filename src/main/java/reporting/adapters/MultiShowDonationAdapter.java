package reporting.adapters;

import reporting.ShowDonationReport;
import thalia.ShowData;

public class MultiShowDonationAdapter {
	String wid;
	ShowData show_info;
	int seats_available;
	int seats_sold;
	int donated_tickets;
	int donated_and_used_tickets;
	double donated_and_used_value;
	public MultiShowDonationAdapter(ShowDonationReport sdr){
		this.wid = sdr.getShow().getWid();
		this.show_info = sdr.getShow().getShow_info();
		this.seats_available=sdr.getSeats_available();
		this.seats_sold=sdr.getSeats_sold();
		this.donated_tickets = sdr.getDonated_tickets();
		this.donated_and_used_tickets=sdr.getDonated_and_used_tickets();
		this.donated_and_used_value = sdr.getDonated_and_used_value();
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
	public int getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}
	public int getSeats_sold() {
		return seats_sold;
	}
	public void setSeats_sold(int seats_sold) {
		this.seats_sold = seats_sold;
	}
	public int getDonated_tickets() {
		return donated_tickets;
	}
	public void setDonated_tickets(int donated_tickets) {
		this.donated_tickets = donated_tickets;
	}
	public int getDonated_and_used_tickets() {
		return donated_and_used_tickets;
	}
	public void setDonated_and_used_tickets(int donated_and_used_tickets) {
		this.donated_and_used_tickets = donated_and_used_tickets;
	}
	public double getDonated_and_used_value() {
		return donated_and_used_value;
	}
	public void setDonated_and_used_value(double donated_and_used_value) {
		this.donated_and_used_value = donated_and_used_value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + donated_and_used_tickets;
		long temp;
		temp = Double.doubleToLongBits(donated_and_used_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + donated_tickets;
		result = prime * result + seats_available;
		result = prime * result + seats_sold;
		result = prime * result + ((show_info == null) ? 0 : show_info.hashCode());
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
		MultiShowDonationAdapter other = (MultiShowDonationAdapter) obj;
		if (donated_and_used_tickets != other.donated_and_used_tickets)
			return false;
		if (Double.doubleToLongBits(donated_and_used_value) != Double.doubleToLongBits(other.donated_and_used_value))
			return false;
		if (donated_tickets != other.donated_tickets)
			return false;
		if (seats_available != other.seats_available)
			return false;
		if (seats_sold != other.seats_sold)
			return false;
		if (show_info == null) {
			if (other.show_info != null)
				return false;
		} else if (!show_info.equals(other.show_info))
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
		return "MultiShowDonationAdapter [wid=" + wid + ", show_info=" + show_info + ", seats_available="
				+ seats_available + ", seats_sold=" + seats_sold + ", donated_tickets=" + donated_tickets
				+ ", donated_and_used_tickets=" + donated_and_used_tickets + ", donated_and_used_value="
				+ donated_and_used_value + "]";
	}
	
}
