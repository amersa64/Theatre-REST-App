package adapters;

import java.util.ArrayList;


public class FailedSeatRequestAdapter {
	String wid;
	ShowDataAdapter show_info;
	String sid;
	String section_name;
	String starting_seat_id;
	String status;
	ArrayList<RowAvailAdapter> seating;
	
	public FailedSeatRequestAdapter(SeatRequestAdapter sra) { //Changed from Row to RowAdapter (Enums)
		this.sid=sra.getSid();
		this.section_name= sra.getSection_name();
		this.status= sra.getStatus();
		this.starting_seat_id = sra.getSid();
		this.seating = sra.getSeating();
		this.wid = sra.getWid();
		this.show_info = sra.getShow_info();
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
	public ArrayList<RowAvailAdapter> getSeating() {
		return seating;
	}
	public void setSeating(ArrayList<RowAvailAdapter> seating) {
		this.seating = seating;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((seating == null) ? 0 : seating.hashCode());
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((starting_seat_id == null) ? 0 : starting_seat_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		FailedSeatRequestAdapter other = (FailedSeatRequestAdapter) obj;
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
		return true;
	}
	
	@Override
	public String toString() {
		return "SeatRequestAdapter [wid=" + wid + ", sid=" + sid + ", section_name=" + section_name + ", starting_seat_id="
				+ starting_seat_id + ", status=" + status + ", seating=" + seating
				+ "show_info=" + show_info.toString() + "]";
	}
	
}
