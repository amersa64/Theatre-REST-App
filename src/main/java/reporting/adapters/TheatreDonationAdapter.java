package reporting.adapters;

import java.time.LocalDate;
import java.util.Arrays;

import reporting.ShowDonationReport;
import reporting.TheatreDonationReport;

public class TheatreDonationAdapter {
	String mrid;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	int total_shows;
	int total_seats;
	int sold_seats;
	int donated_tickets;
	int donated_and_used_tickets;
	double donated_and_used_value;
	MultiShowDonationAdapter[] shows;
	public TheatreDonationAdapter(TheatreDonationReport tdr){
		this.mrid=String.valueOf(tdr.getMrid());
		this.name=tdr.getName();
		this.startDate=tdr.getStartDate();
		this.endDate=tdr.getEndDate();
		this.total_shows=tdr.getShows().length;
		this.total_seats=tdr.getTotal_seats();
		this.sold_seats=tdr.getSold_seats();
		this.donated_tickets= tdr.getDonated_tickets();
		this.donated_and_used_tickets=tdr.getDonated_and_used_tickets();
		this.donated_and_used_value=tdr.getDonated_and_used_value();
		this.shows= new MultiShowDonationAdapter[this.total_shows];
		for(int i =0; i<this.total_shows;i++){
			this.shows[i] = new MultiShowDonationAdapter((ShowDonationReport)tdr.getShowsReports()[i]);
		}
	}
	public String getMrid() {
		return mrid;
	}
	public void setMrid(String mrid) {
		this.mrid = mrid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getTotal_shows() {
		return total_shows;
	}
	public void setTotal_shows(int total_shows) {
		this.total_shows = total_shows;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public int getSold_seats() {
		return sold_seats;
	}
	public void setSold_seats(int sold_seats) {
		this.sold_seats = sold_seats;
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
	public MultiShowDonationAdapter[] getShows() {
		return shows;
	}
	public void setShows(MultiShowDonationAdapter[] shows) {
		this.shows = shows;
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
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((mrid == null) ? 0 : mrid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(shows);
		result = prime * result + sold_seats;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + total_seats;
		result = prime * result + total_shows;
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
		TheatreDonationAdapter other = (TheatreDonationAdapter) obj;
		if (donated_and_used_tickets != other.donated_and_used_tickets)
			return false;
		if (Double.doubleToLongBits(donated_and_used_value) != Double.doubleToLongBits(other.donated_and_used_value))
			return false;
		if (donated_tickets != other.donated_tickets)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (mrid == null) {
			if (other.mrid != null)
				return false;
		} else if (!mrid.equals(other.mrid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(shows, other.shows))
			return false;
		if (sold_seats != other.sold_seats)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (total_seats != other.total_seats)
			return false;
		if (total_shows != other.total_shows)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TheatreDonationAdapter [mrid=" + mrid + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", total_shows=" + total_shows + ", total_seats=" + total_seats + ", sold_seats="
				+ sold_seats + ", donated_tickets=" + donated_tickets + ", donated_and_used_tickets="
				+ donated_and_used_tickets + ", donated_and_used_value=" + donated_and_used_value + ", shows="
				+ Arrays.toString(shows) + "]";
	}
	
}
