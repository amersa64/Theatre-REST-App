package reporting.adapters;

import java.time.LocalDate;

import reporting.ShowRevenueReport;
import reporting.TheatreRevenueReport;

public class TheatreShowRevenueAdapter {
	String mrid;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	int total_shows;
	int total_seats;
	int sold_seats;
	double overall_revenue;
	SingleShowRevenueAdapter[] shows;
	public TheatreShowRevenueAdapter(TheatreRevenueReport trr){
		this.mrid=String.valueOf(trr.getMrid());
		this.name=trr.getName();
		this.startDate=trr.getStartDate();
		this.endDate=trr.getEndDate();
		this.total_shows=1;
		this.total_seats=trr.getTotal_seats();
		this.sold_seats=trr.getSold_seats();
		this.overall_revenue=trr.getOverall_revenue();
		this.shows= new SingleShowRevenueAdapter[]{new SingleShowRevenueAdapter(new ShowRevenueReport(trr.getShows()[0]))};
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
	public double getOverall_revenue() {
		return overall_revenue;
	}
	public void setOverall_revenue(double overall_revenue) {
		this.overall_revenue = overall_revenue;
	}
	public SingleShowRevenueAdapter[] getShows() {
		return shows;
	}
	public void setShows(SingleShowRevenueAdapter[] shows) {
		this.shows = shows;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((mrid == null) ? 0 : mrid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(overall_revenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TheatreShowRevenueAdapter other = (TheatreShowRevenueAdapter) obj;
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
		if (Double.doubleToLongBits(overall_revenue) != Double.doubleToLongBits(other.overall_revenue))
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
		return "TheatreShowRevenueAdapter [mrid=" + mrid + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", total_shows=" + total_shows + ", total_seats=" + total_seats + ", sold_seats="
				+ sold_seats + ", overall_revenue=" + overall_revenue + ", shows=" + shows + "]";
	}
	

}
