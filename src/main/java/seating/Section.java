package seating;

import java.util.Arrays;

//import testing.StaticSectionSetup;
import utility.SectionIDGenerator;

public class Section {
	String sid;
	String section_name;
	Row[] seating;
	double price;
	
	public Section(){
		this.section_name = "Section Name";
		this.sid = "0";
		Seat[] sa = new Seat[1];
		sa[0] = new Seat();
		Row[] ra = new Row[1];
		ra[0] = new Row(sa, "0");
		this.seating = ra;
		this.price = 0;
	}
	
	public Section(String Name, double price, Row[] rows){
		this.section_name = Name;
		this.sid = String.valueOf(SectionIDGenerator.getInstance().getNext());
		this.seating = rows;
		this.price= price;
	}
	public Seat findSeatByCid(String Cid){
		for(Row row: seating){
			for(Seat seat: row.getSeats()){
				if(seat.getCid().equals(Cid))
					return seat;
			}
		}
		return null;
	}
	public Row reqNewSeats(int numSeats, int startRow, int startSeat){
		int initSeat = -1;
		Row row = null;
		Seat[] seats;
		int rowCounter;
		for (rowCounter = startRow; rowCounter < this.seating.length; rowCounter++){
			if (numSeats <= this.seating[rowCounter].getSeats().length){
				initSeat = this.seating[rowCounter].getAvailSeats(numSeats, startSeat);
			}
			if (initSeat != -1){
				break;
			}
			else {//Goes to the next row, starting at 0 for the seat
				startSeat = 0;
			}
		}
		if (initSeat == -1){
			seats = null;
		}
		else {
			seats = new Seat[numSeats];
			String rowID = this.seating[rowCounter].getRowId();
			for (int t = 0; t < numSeats; t ++){
				seats[t] = this.seating[rowCounter].getSeats()[t+initSeat];
			}
			row = new Row(seats,rowID);
		}
		return row;
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

	public Row[] getRows() {
		return seating;
	}

	public void setRows(Row[] rows) {
		seating = rows;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(seating);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
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
		Section other = (Section) obj;
		if (!Arrays.equals(seating, other.seating))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
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
		return "Section [sid=" + sid + ", section_name=" + section_name + ", price="
				+ price +  "\n seating=" + Arrays.toString(seating) +"]";
	}
	
	


	
}
