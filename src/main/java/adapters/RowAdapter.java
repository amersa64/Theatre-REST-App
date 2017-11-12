package adapters;

import java.util.Arrays;

import seating.Row;

public class RowAdapter {
	String row;
	SeatAdapter[] seats;
	public RowAdapter(Row row){
		this.row = row.getRowId();
		this.seats=new SeatAdapter[row.getSeats().length];
		for(int i =0; i<this.seats.length;i++)
			this.seats[i]=new SeatAdapter(row.getSeats()[i]);
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public SeatAdapter[] getSeats() {
		return seats;
	}
	public void setSeats(SeatAdapter[] seats) {
		this.seats = seats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		result = prime * result + Arrays.hashCode(seats);
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
		RowAdapter other = (RowAdapter) obj;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		if (!Arrays.equals(seats, other.seats))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RowAdapter [row=" + row + ", seats=" + Arrays.toString(seats) + "]";
	}
	
}
