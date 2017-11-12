package seating;

import java.util.Arrays;

import seating.Seat.SeatStatus;

public class Row {
	String row;
	Seat[] seats;
	public Row(String[] seats, String id){
		this.seats = new Seat[seats.length];
		for(int i=0; i<seats.length;i++){
			this.seats[i]= new Seat(seats[i]);
		}
		this.row= id;
	}
	
	public Row(Row r){
		this.row = r.getRowId();
		this.seats = r.getSeats();
	}
	public Row(Seat[] seats2, String id) {
		this.row =id;
		this.seats= seats2;
	}
	public Seat[] getSeats() {
		return seats;
	}
	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
	public String getRowId() {
		return row;
	}
	public void setRowId(String rowId) {
		this.row = rowId;
	}
	
	public int getAvailSeats(int numSeats, int start){
		//This counter will check how many seats are contiguously available
		int counter = 0;
		
		for (int s = start; s < this.seats.length; s++){
			if (this.seats[s].status.equals(SeatStatus.sold)){
				counter = 0;
			}
			else {
				counter ++;
			}
			if (counter == numSeats){
				return start;
			}
		}
		return -1;
	}
	
	
	
	@Override
	public String toString() {
		return "RowAdapter [seats=" + Arrays.toString(seats) + ", row=" + row + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(seats);
		result = prime * result + row.hashCode();
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
		Row other = (Row) obj;
		if (!Arrays.equals(seats, other.seats))
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	

}
