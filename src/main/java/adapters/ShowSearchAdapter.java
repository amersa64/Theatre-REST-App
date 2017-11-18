package adapters;

import java.util.ArrayList;

import thalia.Show;
import thalia.Theatre;

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
	
	public static ArrayList<ShowAdapter> searchShows(String key) {
		ArrayList<ShowAdapter> showList = new ArrayList<ShowAdapter>();
		if (key.equals("")){
			for (Show show : Theatre.getInstance().getShows()){
				ShowAdapter sa = new ShowAdapter(show);
				showList.add(sa);
			}
		}
		else{
			for (Show show : Theatre.getInstance().getShows()){
				if (show.toString().contains(key)){
					ShowAdapter sa = new ShowAdapter(show);
					showList.add(sa);
				}
			}
		}
		return showList;
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
