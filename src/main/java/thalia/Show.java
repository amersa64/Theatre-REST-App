package thalia;

import java.time.*;
import java.util.Arrays;

import seating.*;

import utility.ShowIDGenerator;

public class Show {
	String wid;
	Section[]  seating_info; //Should Delete?
	ShowData show_info = new ShowData();
	public void updateSection(Section section){
		for(Section s: seating_info){
			if(s.getSid().equals(section.getSid()))
				s = section;
		}
	}
	public Show(){
		this.wid = String.valueOf(ShowIDGenerator.getInstance().getNext());
		this.show_info.setTime(LocalTime.of(12,12,12));
		this.show_info.setDate(LocalDate.of(2017, 12, 12));
		this.seating_info = new Section[6];
		for (int i = 0; i < this.seating_info.length; i++){
			this.seating_info[i] = new Section();
		}
		this.show_info.setName("Name");
		this.show_info.setWeb("URL");
	}
	public Show(LocalTime time, LocalDate date, Section[] theatre,String name, String web){
		this.wid = String.valueOf(ShowIDGenerator.getInstance().getNext());
		this.show_info.setTime(time);
		this.show_info.setDate(date);
		this.seating_info = theatre;
		this.show_info.setName(name);
		this.show_info.setWeb(web);
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String id) {
		this.wid = id;
	}
	public LocalTime getTime() {
		return show_info.getTime();
	}
	public void setTime(LocalTime time) {
		this.show_info.setTime(time);
	}
	public LocalDate getDate() {
		return show_info.getDate();
	}
	public void setDate(LocalDate date) {
		this.show_info.setDate(date);
	}
	public Section[] getSeating_info() {
		return seating_info;
	}
	public void setSeating_info(Section[] theatre) {
		this.seating_info = theatre;
	}
	public String getName() {
		return show_info.getName();
	}
	public void setName(String name) {
		this.show_info.setName(name);
	}
	
	public String getWeb() {
		return show_info.getWeb();
	}
	public void setWeb(String name) {
		this.show_info.setWeb(name);
	}
	
	public ShowData getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowData show_info) {
		this.show_info = show_info;
	}


	@Override
	public String toString() {
		return "Show [wid=" + wid + ", seating_info=" + Arrays.toString(seating_info) + ", show_info=" + show_info
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((show_info.getDate() == null) ? 0 : show_info.getDate().hashCode());
		result = prime * result + ((show_info.getName() == null) ? 0 : show_info.getName().hashCode());
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
		result = prime * result + ((seating_info == null) ? 0 : seating_info.hashCode());
		result = prime * result + ((show_info.getTime() == null) ? 0 : show_info.getTime().hashCode());
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
		Show other = (Show) obj;
		if (show_info.getDate() == null) {
			if (other.show_info.getDate() != null)
				return false;
		} else if (!show_info.getDate().equals(other.show_info.getDate()))
			return false;
		if (show_info.getName() == null) {
			if (other.show_info.getName() != null)
				return false;
		} else if (!show_info.getName().equals(other.show_info.getName()))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		if (seating_info == null) {
			if (other.seating_info != null)
				return false;
		} else if (!seating_info.equals(other.seating_info))
			return false;
		if (show_info.getTime() == null) {
			if (other.show_info.getTime() != null)
				return false;
		} else if (!show_info.getTime().equals(other.show_info.getTime()))
			return false;
		return true;
	}
	
	public Show search(String key){
		if (wid.equals(key)){
			return this;
		}
		if (show_info.getName().equals(key)){
			return this;
		}
		if (show_info.getWeb().equals(key)){
			return this;
			
		}
		if (show_info.getTime().toString().equals(key)){
			return this;
		}
		if (show_info.getDate().toString().equals(key)){
			return this;
		}
		for (int i = 0; i < seating_info.length; i++){
			if (seating_info[i].getSection_name().equals(key)){
				return this;
			}
			if (String.valueOf(seating_info[i].getPrice()).equals(key)){
				return this;
			}
			if (seating_info[i].getSid().equals(key)){
				return this;
			}
			for (int j = 0; j < seating_info[i].getRows().length; j++){
				if (String.valueOf(seating_info[i].getRows()[j].getRowId()).equals(key)){
					return this;
				}
				
				for (int k = 0; k < seating_info[i].getRows()[j].getSeats().length; k++){
					if (String.valueOf(seating_info[i].getRows()[j].getSeats()[k].getCid()).equals(key)){
						return this;
					}
				}
			}
		}

		return null;
	}
	

}