package adapters;

import java.util.Arrays; //For viewing seating/{sid}

import seating.Row;

public class RowNumberAdapter {
	String row;
	String[] seats;
	public RowNumberAdapter(Row row){
		this.row = row.getRowId();
		this.seats=new String[row.getSeats().length];
		for(int i =0; i<this.seats.length;i++)
			this.seats[i]=row.getSeats()[i].getSeat();
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String[] getSeats() {
		return seats;
	}
	public void setSeats(String[] seats) {
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
		RowNumberAdapter other = (RowNumberAdapter) obj;
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
		return "RowNumberAdapter [row=" + row + ", seats=" + Arrays.toString(seats) + "]";
	}
	
}
