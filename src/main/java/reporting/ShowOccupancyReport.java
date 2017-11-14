package reporting;

import thalia.Show;

public class ShowOccupancyReport extends ShowReport {
	double occupancy;
	public ShowOccupancyReport(Show show){
		super(show);
		this.SectionsReports= new SectionOccupancyReport[show.getSeating_info().length];
		updateSectionReports();
		double denom = Double.valueOf(this.seats_available) + Double.valueOf(this.seats_sold);
		this.occupancy=(Double.valueOf(this.seats_sold)/denom)*100;
	}
	private void updateSectionReports(){
		for(int i=0; i < this.show.getSeating_info().length;i++){
			SectionOccupancyReport sr = new SectionOccupancyReport(this.show.getSeating_info()[i]);
			this.SectionsReports[i] = sr;
		}
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
