package reporting.adapters;

import java.util.Arrays;

import reporting.SectionRevenueReport;
import reporting.ShowRevenueReport;
import thalia.ShowData;

public class SingleShowRevenueAdapter {
	String wid;
	ShowData show_info;
	SectionRevenueApdater[] sections;
	public SingleShowRevenueAdapter(ShowRevenueReport sor){
		this.wid = sor.getShow().getWid();
		this.show_info=sor.getShow().getShow_info();
		this.sections= new SectionRevenueApdater[sor.getShow().getSeating_info().length];
		for(int i=0;i<this.sections.length;i++){
			this.sections[i] = new SectionRevenueApdater((SectionRevenueReport) sor.getSectionsReports()[i]);
		}
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public ShowData getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowData show_info) {
		this.show_info = show_info;
	}
	public SectionRevenueApdater[] getSections() {
		return sections;
	}
	public void setSections(SectionRevenueApdater[] sections) {
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
		SingleShowRevenueAdapter other = (SingleShowRevenueAdapter) obj;
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
		return "SingleShowRevenueAdapter [wid=" + wid + ", show_info=" + show_info + ", sections="
				+ Arrays.toString(sections) + "]";
	}
	
}
