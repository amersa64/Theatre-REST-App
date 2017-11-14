package reporting.adapters;

//import java.time.LocalDate;

import reporting.ShowDonationReport;
import reporting.TheatreDonationReport;


public class TheatreShowDonationAdapter {
	String mrid;
	String name;
	String startDate;
	String endDate;
	int total_shows;
	int total_seats;
	int sold_seats;
	int donated_tickets;
	int donated_and_used_tickets;
	double donated_and_used_value;
	SingleShowDonationAdapter[] shows;
	public TheatreShowDonationAdapter(TheatreDonationReport tdr){
		this.mrid=String.valueOf(tdr.getMrid());
		this.name=tdr.getName();
		int syear = tdr.getStartDate().getYear();
		int smonth = tdr.getStartDate().getMonthValue();
		int sday = tdr.getStartDate().getDayOfMonth();
		int eyear = tdr.getEndDate().getYear();
		int emonth = tdr.getEndDate().getMonthValue();
		int eday = tdr.getEndDate().getDayOfMonth();	
		String styear = String.format("%04d", syear);
		String stmonth = String.format("%02d", smonth);
		String stday = String.format("%02d", sday);
		String enyear = String.format("%04d", eyear);
		String enmonth = String.format("%02d", emonth);
		String enday = String.format("%02d", eday);	
		this.startDate = (styear + "-" + stmonth + "-" + stday);
		this.endDate = (enyear + "-" + enmonth + "-" + enday);
//		this.startDate=tdr.getStartDate();
//		this.endDate=tdr.getEndDate();
		this.total_shows=1;
		this.total_seats=tdr.getTotal_seats();
		this.sold_seats=tdr.getSold_seats();
		this.donated_tickets= tdr.getDonated_tickets();
		this.donated_and_used_tickets=tdr.getDonated_and_used_tickets();
		this.donated_and_used_value=tdr.getDonated_and_used_value();
		this.shows= new SingleShowDonationAdapter[]{new SingleShowDonationAdapter(new ShowDonationReport(tdr.getShows()[0]))};
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
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
	public SingleShowDonationAdapter[] getShows() {
		return shows;
	}
	public void setShows(SingleShowDonationAdapter[] shows) {
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
		result = prime * result + ((shows == null) ? 0 : shows.hashCode());
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
		TheatreShowDonationAdapter other = (TheatreShowDonationAdapter) obj;
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
		if (shows == null) {
			if (other.shows != null)
				return false;
		} else if (!shows.equals(other.shows))
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
		return "TheatreShowDonationAdapter [mrid=" + mrid + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", total_shows=" + total_shows + ", total_seats=" + total_seats + ", sold_seats="
				+ sold_seats + ", donated_tickets=" + donated_tickets + ", donated_and_used_tickets="
				+ donated_and_used_tickets + ", donated_and_used_value=" + donated_and_used_value + ", shows=" + shows
				+ "]";
	}
	
}
