package reporting;

import thalia.Show;

public class ShowOccupancyReport extends ShowReport {
	double occupancy;
	public ShowOccupancyReport(Show show){
		super(show);
		this.SectionsReports= new SectionOccupancyReport[show.getSeating_info().length];
		updateSectionReports();
		this.occupancy=(this.seats_sold/(this.seats_available+this.seats_sold))*100;
	}
	private void updateSectionReports(){
		for(int i=0; i < this.show.getSeating_info().length;i++){
			SectionOccupancyReport sr = new SectionOccupancyReport(this.show.getSeating_info()[i]);
			this.SectionsReports[i] = sr;
		}
	}
	public int getSeats_sold() {
		return seats_sold;
	}
	public void setSeats_sold(int seats_sold) {
		this.seats_sold = seats_sold;
	}
	public int getAvailable_seats() {
		return seats_available;
	}
	public void setAvailable_seats(int available_seats) {
		this.seats_available = available_seats;
	}
	public double getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(double occupancy) {
		this.occupancy = occupancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(occupancy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowOccupancyReport other = (ShowOccupancyReport) obj;
		if (Double.doubleToLongBits(occupancy) != Double.doubleToLongBits(other.occupancy))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowOccupancyReport [occupancy=" + occupancy + "]";
	}
	
	

}
