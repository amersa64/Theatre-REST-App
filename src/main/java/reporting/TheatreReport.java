package reporting;

import java.time.LocalDate;
import java.util.Arrays;

import thalia.Show;
import thalia.Theatre;

public class TheatreReport {
	protected int mrid;
	protected String name;
	protected LocalDate startDate;
	protected LocalDate endDate;
	protected Theatre theatre;
	protected int total_seats;
	protected int sold_seats;
	protected Show[] shows;
	protected ShowReport[] showsReports;

	public TheatreReport(LocalDate startDate, LocalDate endDate) {
		this.theatre= Theatre.getInstance();
		this.startDate=startDate;
		this.endDate=endDate;
		this.shows = theatre.getShowsBetweenDates(startDate, endDate).toArray(new Show[theatre.getShowsBetweenDates(startDate, endDate).size()]);
		this.showsReports = new ShowReport[this.shows.length];
		constructorHelper();
	}
	public TheatreReport(){
		this.theatre= Theatre.getInstance();
		this.startDate=null;
		this.endDate=null;
		this.shows = theatre.getShowsBetweenDates(startDate, endDate).toArray(new Show[theatre.getShowsBetweenDates(startDate, endDate).size()]);
		this.showsReports = new ShowReport[this.shows.length];
		constructorHelper();
	}
	public TheatreReport(Show show){
		this.theatre= Theatre.getInstance();
		this.startDate=null;
		this.endDate=null;
		this.shows = new Show[]{show};
		this.showsReports = new ShowReport[this.shows.length];
		constructorHelper();
	}
	private void constructorHelper(){
		total_seats=0;
		sold_seats=0;
		for(Show show: this.shows){
			ShowReport showreport = new ShowReport(show);
			total_seats+=(showreport.getSeats_available()+showreport.getSeats_sold());
			sold_seats+=showreport.getSeats_sold();
		}
	}
	
	public ShowReport[] getShowsReports() {
		return showsReports;
	}
	public void setShowsReports(ShowReport[] showsReports) {
		this.showsReports = showsReports;
	}
	public int getMrid() {
		return mrid;
	}
	public void setMrid(int mrid) {
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
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
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
	
	public Show[] getShows() {
		return shows;
	}
	public void setShows(Show[] shows) {
		this.shows = shows;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + mrid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(shows);
		result = prime * result + sold_seats;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((theatre == null) ? 0 : theatre.hashCode());
		result = prime * result + total_seats;
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
		TheatreReport other = (TheatreReport) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (mrid != other.mrid)
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
		if (theatre == null) {
			if (other.theatre != null)
				return false;
		} else if (!theatre.equals(other.theatre))
			return false;
		if (total_seats != other.total_seats)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TheatreReport [mrid=" + mrid + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", theatre=" + theatre + ", total_seats=" + total_seats
				+ ", sold_seats=" + sold_seats + ", shows=" + Arrays.toString(shows) + "]";
	}



}