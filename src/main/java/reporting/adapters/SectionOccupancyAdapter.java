package reporting.adapters;

import reporting.SectionOccupancyReport;

public class SectionOccupancyAdapter {
	String sid;
	String section_name;
	int seats_available;
	int seats_sold;
	String occupancy;
	public SectionOccupancyAdapter(SectionOccupancyReport sor){
		this.sid=sor.getSection().getSid();
		this.section_name=sor.getSection().getSection_name();
		this.seats_available=sor.getSeats_available();
		this.seats_sold=sor.getSeats_sold();
		this.occupancy=(this.seats_sold/(this.seats_available+this.seats_sold))*100+ "%";
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
	public String getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((occupancy == null) ? 0 : occupancy.hashCode());
		result = prime * result + seats_available;
		result = prime * result + seats_sold;
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());;
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
		SectionOccupancyAdapter other = (SectionOccupancyAdapter) obj;
		if (occupancy == null) {
			if (other.occupancy != null)
				return false;
		} else if (!occupancy.equals(other.occupancy))
			return false;
		if (seats_available != other.seats_available)
			return false;
		if (seats_sold != other.seats_sold)
			return false;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
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
		return "SectionOccupancyAdapter [sid=" + sid + ", section_name=" + section_name + 
				", seats_available=" + seats_available + ", seats_sold=" + seats_sold + ", occupancy="
				+ occupancy + "]";
	}
	

}
