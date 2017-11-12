package reporting.adapters;

import reporting.ShowRevenueReport;
import thalia.ShowData;

public class MultiShowRevenueAdapter {
	String wid;
	ShowData show_info;
	int seats_available;
	int seats_sold;
	double revenue;
	public MultiShowRevenueAdapter(ShowRevenueReport srr){
		this.wid = srr.getShow().getWid();
		this.show_info=srr.getShow().getShow_info();
		this.seats_available=srr.getSeats_available();
		this.seats_sold = srr.getSeats_sold();
		this.revenue= srr.getRevenue();
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public ShowData getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowData show_info) {
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
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(revenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MultiShowRevenueAdapter other = (MultiShowRevenueAdapter) obj;
		if (Double.doubleToLongBits(revenue) != Double.doubleToLongBits(other.revenue))
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
		return "MultiShowRevenueAdapter [wid=" + wid + ", show_info=" + show_info + ", seats_available="
				+ seats_available + ", seats_sold=" + seats_sold + ", revenue=" + revenue + "]";
	}
	

}
