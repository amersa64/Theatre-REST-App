package reporting.adapters;

import reporting.SectionDonationReport;

public class SectionDonationAdapter {
	String sid;
	String section_name;
	int seats_available;
	int seats_sold;
	int donated_tickets;
	int donated_and_used_tickets;
	double donated_and_used_value;
	public SectionDonationAdapter(SectionDonationReport sdr){
		this.sid=sdr.getSection().getSid();
		this.section_name=sdr.getSection().getSection_name();
		this.seats_available=sdr.getSeats_available();
		this.seats_sold=sdr.getSeats_sold();
		this.donated_tickets = sdr.getDonated_tickets();
		this.donated_and_used_tickets=sdr.getDonated_and_used_tickets();
		this.donated_and_used_value = sdr.getDonated_and_used_value();
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
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		SectionDonationAdapter other = (SectionDonationAdapter) obj;
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
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SectionDonationAdapter [sid=" + sid + ", section_name=" + section_name + ", seats_available="
				+ seats_available + ", seats_sold=" + seats_sold + ", donated_tickets=" + donated_tickets
				+ ", donated_and_used_tickets=" + donated_and_used_tickets + ", donated_and_used_value="
				+ donated_and_used_value + "]";
	}
	
}
