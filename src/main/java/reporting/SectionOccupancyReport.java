package reporting;

import seating.Section;

public class SectionOccupancyReport extends SectionReport{
	double section_occupancy;
	public SectionOccupancyReport(Section section) {
		super(section);
		this.section_occupancy = (this.seats_sold/(this.seats_sold+this.seats_available))*100;
	}
	public SectionOccupancyReport(Section section, double section_occupancy) {
		super(section);
		this.section_occupancy = section_occupancy;
	}

	public double getSection_occupancy() {
		return section_occupancy;
	}
	public void setSection_occupancy(double section_occupancy) {
		this.section_occupancy = section_occupancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(section_occupancy);
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
		SectionOccupancyReport other = (SectionOccupancyReport) obj;
		if (Double.doubleToLongBits(section_occupancy) != Double.doubleToLongBits(other.section_occupancy))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SectionOccupancyReport [section_occupancy=" + section_occupancy + "]";
	}
	
	

}
