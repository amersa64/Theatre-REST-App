package adapters;

import thalia.Ticket;

public class TicketOrderAdapter {
	String tid;
	String status;
	public TicketOrderAdapter(Ticket ticket){
		this.tid=ticket.getTid();
		this.status = ticket.getStatus().toString();
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		TicketOrderAdapter other = (TicketOrderAdapter) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TicketOrderAdapter [tid=" + tid + ", status=" + status + "]";
	}
	
}
