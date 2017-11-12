package reporting.adapters;
import reporting.SectionRevenueReport;

public class SectionRevenueApdater {
	String sid;
	String section_name;
	double section_price;
	int seats_available;
	int seats_sold;
	double section_revenue;
	public SectionRevenueApdater(SectionRevenueReport sor){
		this.sid=sor.getSection().getSid();
		this.section_name=sor.getSection().getSection_name();
		this.section_price=sor.getSection().getPrice();
		this.seats_available=sor.getSeats_available();
		this.seats_sold=sor.getSeats_sold();
		this.section_revenue= sor.getSection_revenue();
		//check for rounding errors with professors
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public double getSection_price() {
		return section_price;
	}
	public void setSection_price(double section_price) {
		this.section_price = section_price;
	}
	public int getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}
	public int getSeats_sold() {
		return seats_sold;
	}
	public void setSeats_sold(int seats_sold) {
		this.seats_sold = seats_sold;
	}
	public double getSection_revenue() {
		return section_revenue;
	}
	public void setSection_revenue(double section_revenue) {
		this.section_revenue = section_revenue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seats_available;
		result = prime * result + seats_sold;
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(section_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(section_revenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		SectionRevenueApdater other = (SectionRevenueApdater) obj;
		if (seats_available != other.seats_available)
			return false;
		if (seats_sold != other.seats_sold)
			return false;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		if (Double.doubleToLongBits(section_price) != Double.doubleToLongBits(other.section_price))
			return false;
		if (Double.doubleToLongBits(section_revenue) != Double.doubleToLongBits(other.section_revenue))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SectionRevenueApdater [sid=" + sid + ", section_name=" + section_name + ", section_price="
				+ section_price + ", seats_available=" + seats_available + ", seats_sold=" + seats_sold
				+ ", section_revenue=" + section_revenue + "]";
	}
	
}
