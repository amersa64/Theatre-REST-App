package adapters;

import java.util.ArrayList;

public class ShowSearchAdapter {
	
	ArrayList<ShowAdapter> shows;
	public ShowSearchAdapter(ArrayList<ShowAdapter> sa) {
		this.shows = sa;
	}
	public ArrayList<ShowAdapter> getShows() {
		return shows;
	}
	public void setShows(ArrayList<ShowAdapter> shows) {
		this.shows = shows;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shows == null) ? 0 : shows.hashCode());
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
		ShowSearchAdapter other = (ShowSearchAdapter) obj;
		if (shows == null) {
			if (other.shows != null)
				return false;
		} else if (!shows.equals(other.shows))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowSearchAdapter [shows=" + shows + "]";
	}
	
	

}
