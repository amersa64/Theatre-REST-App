package reporting.adapters;

import java.text.DecimalFormat;
import java.util.Arrays;

import reporting.ShowOccupancyReport;
import reporting.TheatreOccupancyReport;

public class TheatreOccupancyAdapter {
	String mrid;
	String name;
	String startDate;
	String endDate;
	int total_shows;
	int total_seats;
	int sold_seats;
	String overall_occupancy;
	MultiShowOccupancyAdapter[] shows;
	public TheatreOccupancyAdapter(TheatreOccupancyReport tor){
		this.mrid=String.valueOf(tor.getMrid());
		this.name=tor.getName();
		this.total_shows=tor.getShows().length;
		this.total_seats=tor.getTotal_seats();
		this.sold_seats=tor.getSold_seats();
		DecimalFormat df = new DecimalFormat("#.##");
		this.overall_occupancy = df.format(tor.getOverall_occupancy())+"%";
		
		if (tor.getStartDate() == null) {
			this.startDate = "";
		}
		else {
			int syear = tor.getStartDate().getYear();
			int smonth = tor.getStartDate().getMonthValue();
			int sday = tor.getStartDate().getDayOfMonth();
			String styear = String.format("%04d", syear);
			String stmonth = String.format("%02d", smonth);
			String stday = String.format("%02d", sday);
			this.startDate = (styear + "-" + stmonth + "-" + stday);
//			this.startDate= trr.getStartDate().toString();
		}
		if (tor.getEndDate() == null) {
			this.endDate = "";
		}
		else {
			int eyear = tor.getEndDate().getYear();
			int emonth = tor.getEndDate().getMonthValue();
			int eday = tor.getEndDate().getDayOfMonth();
			String enyear = String.format("%04d", eyear);
			String enmonth = String.format("%02d", emonth);
			String enday = String.format("%02d", eday);
			this.endDate = (enyear + "-" + enmonth + "-" + enday);
//			this.endDate = trr.getEndDate().toString();
		}
		
		
		this.shows= new MultiShowOccupancyAdapter[this.total_shows];
		for(int i =0; i<this.total_shows;i++){
			this.shows[i] = new MultiShowOccupancyAdapter((ShowOccupancyReport)tor.getShowsReports()[i]);
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
	public String getOverall_occupancy() {
		return overall_occupancy;
	}
	public void setOverall_occupancy(String overall_occupancy) {
		this.overall_occupancy = overall_occupancy;
	}
	public MultiShowOccupancyAdapter[] getShows() {
		return shows;
	}
	public void setShows(MultiShowOccupancyAdapter[] shows) {
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
		TheatreOccupancyAdapter other = (TheatreOccupancyAdapter) obj;
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
		return "TheatreOccupancyAdapter [mrid=" + mrid + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", total_shows=" + total_shows + ", total_seats=" + total_seats + ", sold_seats="
				+ sold_seats + ", overall_occupancy=" + overall_occupancy + ", shows=" + Arrays.toString(shows) + "]";
	}
	

}
