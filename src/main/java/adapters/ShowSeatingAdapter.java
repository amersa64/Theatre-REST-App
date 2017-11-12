package adapters;

import java.util.Arrays;

import seating.Section;
import thalia.*;
//this is used for viewing shows general info and sections prices and sid
public class ShowSeatingAdapter extends ShowAdapter {
	SectionAdapter[] seating_info;
	public ShowSeatingAdapter(Show show){
		super(show);
		this.seating_info = new SectionAdapter[show.getSeating_info().length];
		for(int i = 0;i<this.seating_info.length;i++){
			Section section = show.getSeating_info()[i];
			this.seating_info[i]= new SectionPriceAdapter(section);
		}
	}
	public SectionAdapter[] getSeating_info() {
		return seating_info;
	}
	public void setSeating_info(SectionAdapter[] seating_info) {
		this.seating_info = seating_info;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(seating_info);
		result = prime * result + ((show_info == null) ? 0 : show_info.hashCode());
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
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
		ShowSeatingAdapter other = (ShowSeatingAdapter) obj;
		if (!Arrays.equals(seating_info, other.seating_info))
			return false;
		if (show_info == null) {
			if (other.show_info != null)
				return false;
		} else if (!show_info.equals(other.show_info))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowSeatingAdapter [wid=" + wid + ", show_info=" + show_info + ", seating_info="
				+ Arrays.toString(seating_info) + "]";
	}
	

}
