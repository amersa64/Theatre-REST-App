package reporting;

import seating.*;
import seating.Seat.SeatStatus;

public class SectionReport {
	Section section;
	int seats_available;
	int seats_sold;
	public SectionReport(Section section){
		this.section = section;
		this.seats_sold= 0;
		int cap = 0;
		for(Row row: section.getRows()){
			for(Seat seat: row.getSeats()){
				if(seat.getStatus().equals(SeatStatus.sold))
					this.seats_sold++;
				cap++;
			}
		}
		this.seats_available=cap-this.seats_sold;
	}
	public SectionReport(Section section, int seats_available, int seats_sold) {
		this.section = section;
		this.seats_available = seats_available;
		this.seats_sold = seats_sold;
	}
	
	
	//setters and getters and hashcode and equals
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seats_available;
		result = prime * result + seats_sold;
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		SectionReport other = (SectionReport) obj;
		if (seats_available != other.seats_available)
			return false;
		if (seats_sold != other.seats_sold)
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}
	
	
}
