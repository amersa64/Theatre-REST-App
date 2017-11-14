package adapters;

import seating.Section;
//this is an adapter for showing sections and prices only 
//will be used in the show adapter

public class SectionPriceAdapter extends SectionAdapter {
	String section_name;
	double price;
	public SectionPriceAdapter(Section section){
		super(section);
		this.section_name=section.getSection_name();
		this.price=section.getPrice();
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
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
		SectionPriceAdapter other = (SectionPriceAdapter) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "SectionPriceAdapter [sid=" + sid + ", price=" + price + ", section_name=" + section_name + "]";
	}
	
}
