package reporting;

import java.util.ArrayList;

import seating.Row;
import seating.Seat;
import seating.Section;
import thalia.Theatre;
import thalia.Ticket;
import thalia.Ticket.TicketStatus;

public class SectionDonationReport extends SectionReport{
	protected ArrayList<Ticket> section_tickets;
	int donated_tickets=0;
	int donated_and_used_tickets = 0;
	double donated_and_used_value=0;
	public SectionDonationReport(Section section) {
		super(section);
		updateSectionTickets();
		updateMetrics();
	}
	private void updateSectionTickets(){
		this.section_tickets = new ArrayList<Ticket>();
		for(Row row: section.getRows()){
			for(Seat seat: row.getSeats()){
				Ticket cid_ticket = Theatre.getInstance().findTicketByCid(seat.getCid());
				if(cid_ticket != null){
					section_tickets.add(cid_ticket);
				}
			}
		}
	}
	private void updateMetrics(){
		if (this.section_tickets != null){
		for(Ticket t: this.section_tickets){
			if(t.isDonated()){
				this.donated_tickets++;
				if(t.getStatus().equals(TicketStatus.used)){
					this.donated_and_used_tickets++;
					this.donated_and_used_value+=t.getPrice();
				}
			}
		}
		}
	}
	public ArrayList<Ticket> getSection_tickets() {
		return section_tickets;
	}
	public void setSection_tickets(ArrayList<Ticket> section_tickets) {
		this.section_tickets = section_tickets;
	}
	public int getDonated_tickets() {
		return donated_tickets;
	}
	public void setDonated_tickets(int donated_tickets) {
		this.donated_tickets = donated_tickets;
	}
	public int getDonated_and_used_tickets() {
		return donated_and_used_tickets;
	}
	public void setDonated_and_used_tickets(int donated_and_used_tickets) {
		this.donated_and_used_tickets = donated_and_used_tickets;
	}
	public double getDonated_and_used_value() {
		return donated_and_used_value;
	}
	public void setDonated_and_used_value(double donated_and_used_value) {
		this.donated_and_used_value = donated_and_used_value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + donated_and_used_tickets;
		long temp;
		temp = Double.doubleToLongBits(donated_and_used_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + donated_tickets;
		result = prime * result + ((section_tickets == null) ? 0 : section_tickets.hashCode());
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
		SectionDonationReport other = (SectionDonationReport) obj;
		if (donated_and_used_tickets != other.donated_and_used_tickets)
			return false;
		if (Double.doubleToLongBits(donated_and_used_value) != Double.doubleToLongBits(other.donated_and_used_value))
			return false;
		if (donated_tickets != other.donated_tickets)
			return false;
		if (section_tickets == null) {
			if (other.section_tickets != null)
				return false;
		} else if (!section_tickets.equals(other.section_tickets))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SectionDonationReport [section_tickets=" + section_tickets + ", donated_tickets=" + donated_tickets
				+ ", donated_and_used_tickets=" + donated_and_used_tickets + ", donated_and_used_value="
				+ donated_and_used_value + "]";
	}
	

}
