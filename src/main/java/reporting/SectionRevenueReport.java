package reporting;

import seating.Section;

public class SectionRevenueReport extends SectionReport{
	double section_revenue=0;
	public SectionRevenueReport(Section section) {
		super(section);
		this.section_revenue=section.getPrice()*this.seats_sold;
	}
	public SectionRevenueReport(Section section, int seats_available, int seats_sold, double section_revenue) {
		super(section,seats_available,seats_sold);
		this.section_revenue=section_revenue;
	}
	
	
	
	
	
	
	
	//setters and getters and hashcode
	public double getSection_revenue() {
		return section_revenue;
	}
	public void setSection_revenue(double section_revenue) {
		this.section_revenue = section_revenue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(section_revenue);
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
		SectionRevenueReport other = (SectionRevenueReport) obj;
		if (Double.doubleToLongBits(section_revenue) != Double.doubleToLongBits(other.section_revenue))
			return false;
		return true;
	}
	

}
