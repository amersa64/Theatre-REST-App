package adapters;

import java.util.ArrayList;

import seating.Section;
import thalia.Show;

public class SeatRequestAdapter extends ShowAdapter {
	String sid;
	String section_name;
	String starting_seat_id;
	String status;
	double total_amount;
	ArrayList<RowAvailAdapter> seating;
	public SeatRequestAdapter(Show show,Section section,String starting_seat_id, RowAvailAdapter seats, int count) { //Changed from Row to RowAdapter (Enums)
		super(show);
		this.sid=section.getSid();
		this.section_name= section.getSection_name();
		
		if(seats != null){
			this.status="ok";
			if(starting_seat_id.equals(""))
				this.starting_seat_id = seats.getSeats()[0].getCid();
			else
				this.starting_seat_id =starting_seat_id;
			this.seating = new ArrayList<RowAvailAdapter>();
			this.seating.add(seats);
			this.total_amount = section.getPrice()*count; 
		}else{
			this.status="Error: "+ count+ " contiguous seats not available";
			if(starting_seat_id.equals(""))
				this.starting_seat_id = section.getRows()[0].getSeats()[0].getCid();
			else
				this.starting_seat_id =starting_seat_id;
			this.seating = new ArrayList<RowAvailAdapter>();
			this.total_amount = 0;
		}
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
	public String getStarting_seat_id() {
		return starting_seat_id;
	}
	public void setStarting_seat_id(String starting_seat_id) {
		this.starting_seat_id = starting_seat_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public ArrayList<RowAvailAdapter> getSeating() {
		return seating;
	}
	public void setSeating(ArrayList<RowAvailAdapter> seating) {
		this.seating = seating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((seating == null) ? 0 : seating.hashCode());
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((starting_seat_id == null) ? 0 : starting_seat_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total_amount);
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
		SeatRequestAdapter other = (SeatRequestAdapter) obj;
		if (seating == null) {
			if (other.seating != null)
				return false;
		} else if (!seating.equals(other.seating))
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
		if (starting_seat_id == null) {
			if (other.starting_seat_id != null)
				return false;
		} else if (!starting_seat_id.equals(other.starting_seat_id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(total_amount) != Double.doubleToLongBits(other.total_amount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SeatRequestAdapter [sid=" + sid + ", section_name=" + section_name + ", starting_seat_id="
				+ starting_seat_id + ", status=" + status + ", total_amount=" + total_amount + ", seating=" + seating
				+ "]";
	}
	

}
