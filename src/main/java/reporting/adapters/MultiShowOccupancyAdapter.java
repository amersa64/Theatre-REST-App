package reporting.adapters;

import java.text.DecimalFormat;

import adapters.ShowDataAdapter;
import reporting.ShowOccupancyReport;
//import thalia.ShowData;

public class MultiShowOccupancyAdapter {
	String wid;
	ShowDataAdapter show_info;
	int seats_available;
	int seats_sold;
	String occupancy;
	public MultiShowOccupancyAdapter(ShowOccupancyReport sor){
		this.wid = sor.getShow().getWid();
		this.show_info=new ShowDataAdapter(sor.getShow().getShow_info());
//		this.show_info=sor.getShow().getShow_info();
		this.seats_available= sor.getSeats_available();
		this.seats_sold = sor.getSeats_sold();
		DecimalFormat df = new DecimalFormat("#.##");
		this.occupancy = df.format(sor.getOccupancy())+"%";
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public ShowDataAdapter getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowDataAdapter show_info) {
		this.show_info = show_info;
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
		result = prime * result + ((show_info == null) ? 0 : show_info.hashCode());
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
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
		MultiShowOccupancyAdapter other = (MultiShowOccupancyAdapter) obj;
		if (occupancy == null) {
			if (other.occupancy != null)
				return false;
		} else if (!occupancy.equals(other.occupancy))
			return false;
		if (seats_available != other.seats_available)
			return false;
		if (seats_sold != other.seats_sold)
			return false;
		if (show_info == null) {
			if (other.show_info != null)
				return false;
		} else if (!show_info.equals(other.show_info))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MultiShowOccupancyAdapter [wid=" + wid + ", show_info=" + show_info + ", seats_available="
				+ seats_available + ", seats_sold=" + seats_sold + ", occupancy=" + occupancy + "]";
	}
	
}
