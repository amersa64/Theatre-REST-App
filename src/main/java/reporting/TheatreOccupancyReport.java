package reporting;

import java.time.LocalDate;

public class TheatreOccupancyReport extends TheatreReport {
	double overall_occupancy;
	
	public TheatreOccupancyReport(LocalDate startDate, LocalDate endDate){
		super(startDate,endDate);
		this.mrid = 801;
		this.name = "Occupancy report";
		updateOccupancy();
		this.overall_occupancy=(this.sold_seats/this.total_seats)*100;
	}
	public TheatreOccupancyReport(){
		super();
		this.mrid = 801;
		this.name = "Occupancy report";
		updateOccupancy();
		this.overall_occupancy=(this.sold_seats/this.total_seats)*100;
	}
	private void updateOccupancy(){
		for(int i =0; i< theatre.getShows().size();i++){
			ShowOccupancyReport srr = new ShowOccupancyReport(theatre.getShows().get(i));
			this.showsReports[i] =srr;
		}
	}
	public double getOverall_occupancy() {
		return overall_occupancy;
	}
	public void setOverall_occupancy(double overall_occupancy) {
		this.overall_occupancy = overall_occupancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(overall_occupancy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TheatreOccupancyReport other = (TheatreOccupancyReport) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (Double.doubleToLongBits(overall_occupancy) != Double.doubleToLongBits(other.overall_occupancy))
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
	

}
