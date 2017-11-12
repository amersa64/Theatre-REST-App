package seating;

import utility.SeatIDGenerator;

public class Seat {
	public enum SeatStatus{
		available,sold
	}
	String cid;
	String seat;
	SeatStatus status;
	
	public Seat(){
		this.cid = String.valueOf(SeatIDGenerator.getInstance().getNext());
		this.seat = "Seat number here";
		this.status=SeatStatus.available;
	}
	
	public Seat(String seat_number){
		this.cid =String.valueOf(SeatIDGenerator.getInstance().getNext());
		this.seat = seat_number;
		this.status=SeatStatus.available;
	}
	public Seat(String id, String seat_number ,SeatStatus isTaken) {
		this.cid = id;
		this.seat= seat_number;
		this.status = isTaken;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat_number) {
		this.seat = seat_number;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Seat other = (Seat) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Seat [cid=" + cid + ", seat=" + seat + ", status=" + status + "]";
	}
	
	
	
}
