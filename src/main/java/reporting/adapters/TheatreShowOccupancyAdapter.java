package reporting.adapters;

import java.time.LocalDate;

import reporting.ShowOccupancyReport;
import reporting.TheatreOccupancyReport;

public class TheatreShowOccupancyAdapter {
	String mrid;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	int total_shows;
	int total_seats;
	int sold_seats;
	String overall_occupancy;
	SingleShowOccupancyAdapter[] shows;
	public TheatreShowOccupancyAdapter(TheatreOccupancyReport tor){
		this.mrid=String.valueOf(tor.getMrid());
		this.name=tor.getName();
		this.startDate=tor.getStartDate();
		this.endDate=tor.getEndDate();
		this.total_shows=tor.getShows().length;
		this.total_seats=tor.getTotal_seats();
		this.sold_seats=tor.getSold_seats();
		this.overall_occupancy=tor.getOverall_occupancy()+"%";
		this.shows= new SingleShowOccupancyAdapter[]{new SingleShowOccupancyAdapter((ShowOccupancyReport)tor.getShowsReports()[0])};
	}
	public String getOverall_occupancy() {
		return overall_occupancy;
	}
	public void setOverall_occupancy(String overall_occupancy) {
		this.overall_occupancy = overall_occupancy;
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
	public SingleShowOccupancyAdapter[] getShows() {
		return shows;
	}
	public void setShows(SingleShowOccupancyAdapter[] shows) {
		this.shows = shows;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((mrid == null) ? 0 : mrid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((overall_occupancy == null) ? 0 : overall_occupancy.hashCode());
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
		TheatreShowOccupancyAdapter other = (TheatreShowOccupancyAdapter) obj;
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
		if (overall_occupancy == null) {
			if (other.overall_occupancy != null)
				return false;
		} else if (!overall_occupancy.equals(other.overall_occupancy))
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
		return "TheatreShowOccupancyAdapter [mrid=" + mrid + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", total_shows=" + total_shows + ", total_seats=" + total_seats
				+ ", sold_seats=" + sold_seats + ", overall_occupancy=" + overall_occupancy + ", shows=" + shows.toString() + "]";
	}
	
	
}
