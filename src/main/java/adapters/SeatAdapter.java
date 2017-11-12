package adapters;

import seating.Seat;

public class SeatAdapter {
	String cid;
	String seat;
	public SeatAdapter(Seat seat){
		this.seat= seat.getSeat();
		this.cid= seat.getCid();
	}
	public SeatAdapter(String cid, String seat) {
		this.cid = cid;
		this.seat = seat;
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
	public void setSeat(String seat) {
		this.seat = seat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
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
		SeatAdapter other = (SeatAdapter) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "SeatAdapter [cid=" + cid + ", seat=" + seat + "]";
	}
	

}
