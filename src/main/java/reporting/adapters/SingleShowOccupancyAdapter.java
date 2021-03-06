package reporting.adapters;

import java.util.Arrays;

import adapters.ShowDataAdapter;
import reporting.SectionOccupancyReport;
import reporting.ShowOccupancyReport;
//import thalia.ShowData;

public class SingleShowOccupancyAdapter {
	String wid;
	ShowDataAdapter show_info;
	SectionOccupancyAdapter[] sections;
	public SingleShowOccupancyAdapter(ShowOccupancyReport sor){
		this.wid = sor.getShow().getWid();
		this.show_info=new ShowDataAdapter(sor.getShow().getShow_info());
//		this.show_info=sor.getShow().getShow_info();
		this.sections= new SectionOccupancyAdapter[sor.getShow().getSeating_info().length];
		for(int i=0;i<this.sections.length;i++){
			this.sections[i] = new SectionOccupancyAdapter((SectionOccupancyReport) sor.getSectionsReports()[i]);
		}
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public ShowDataAdapter getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowDataAdapter show_info) {
		this.show_info = show_info;
	}
	public SectionOccupancyAdapter[] getSections() {
		return sections;
	}
	public void setSections(SectionOccupancyAdapter[] sections) {
		this.sections = sections;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sections);
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
		SingleShowOccupancyAdapter other = (SingleShowOccupancyAdapter) obj;
		if (!Arrays.equals(sections, other.sections))
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
		return "SingleShowOccupancyAdapter [wid=" + wid + ", show_info=" + show_info + ", sections="
				+ Arrays.toString(sections) + "]";
	}
	

}
