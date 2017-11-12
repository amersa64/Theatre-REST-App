package reporting;

import thalia.Show;

public class ShowRevenueReport extends ShowReport {
	double revenue;

	public ShowRevenueReport(Show show) {
		super(show);
		this.SectionsReports = new SectionRevenueReport[this.show.getSeating_info().length];
		update();
	}
	public void update(){
		for(int i =0; i<this.show.getSeating_info().length ;i++){
			SectionRevenueReport srr = new SectionRevenueReport(this.show.getSeating_info()[i]);
			this.SectionsReports[i] = srr;
			this.revenue+=srr.getSection_revenue();
		}
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(revenue);
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
		ShowRevenueReport other = (ShowRevenueReport) obj;
		if (Double.doubleToLongBits(revenue) != Double.doubleToLongBits(other.revenue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShowRevenueReport [revenue=" + revenue + "]";
	}
	

}
