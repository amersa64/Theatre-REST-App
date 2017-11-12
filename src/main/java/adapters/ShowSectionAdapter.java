package adapters;

import java.util.Arrays;

//import seating.Row;
import seating.Section;
import thalia.*;
//this is used for viewing a specific section in a show (shows/{wid}/sections/{sid}
public class ShowSectionAdapter extends ShowAdapter {
	String sid;
	String section_name;
	RowAvailAdapter[] seating;
	public ShowSectionAdapter(Show show, String sid){
		super(show);
//		for (int i = 0; i < show.getSeating_info().length; i++){
//			if (show.getSeating_info()[i].getSid().equals(sid)){
		for (Section section : show.getSeating_info()){
			if (section.getSid().equals(sid)){
				Section s = new Section();
				s = section;
				this.sid = s.getSid();
				this.section_name = s.getSection_name();
				this.seating = new RowAvailAdapter[s.getRows().length];
				for (int j = 0; j < this.seating.length; j++){
					this.seating[j] = new RowAvailAdapter(s.getRows()[j]);
				}
				return;
			}
		}

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
	public RowAvailAdapter[] getRows() {
		return seating;
	}
	public void setRows(RowAvailAdapter[] seating) {
		this.seating = seating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(seating);
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		ShowSectionAdapter other = (ShowSectionAdapter) obj;
		if (!Arrays.equals(seating, other.seating))
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
		return "ShowSectionAdapter [sid=" + sid + ", section_name=" + section_name + ", seating="
				+ Arrays.toString(seating) + "]";
	}
	
	
}
