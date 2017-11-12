package adapters;

import seating.Section;
//this is an adapter for showing sections and prices only 
//will be used in the show adapter

public class SectionPriceAdapter extends SectionAdapter {
	double price;
	public SectionPriceAdapter(Section section){
		super(section);
		this.price=section.getPrice();
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
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
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
		SectionPriceAdapter other = (SectionPriceAdapter) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
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
		return "SectionPriceAdapter [sid=" + sid + ", price=" + price + "]";
	}

}
