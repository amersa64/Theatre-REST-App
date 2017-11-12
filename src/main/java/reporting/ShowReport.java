package reporting;

import java.util.Arrays;

import seating.Section;
import thalia.Show;

public class ShowReport {

	protected Show show;
	int seats_available=0;
	int seats_sold=0;
	SectionReport[] SectionsReports;
	public ShowReport(Show show){
		this.show = show;
		updateOccupancyMetrics();
	}
	private void updateOccupancyMetrics(){
		for(Section section:this.show.getSeating_info()){
			SectionReport sr = new SectionReport(section);
			this.seats_available+=sr.getSeats_available();
			this.seats_sold+=sr.getSeats_sold();
		}
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}

	public int getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}
	public int getSeats_sold() {
		return seats_sold;
	}
	public void setSeats_sold(int seats_sold) {
		this.seats_sold = seats_sold;
	}
	public SectionReport[] getSectionsReports() {
		return SectionsReports;
	}
	public void setSectionsReports(SectionReport[] sectionsReports) {
		SectionsReports = sectionsReports;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(SectionsReports);
		result = prime * result + seats_available;
		result = prime * result + seats_sold;
		result = prime * result + ((show == null) ? 0 : show.hashCode());
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
		ShowReport other = (ShowReport) obj;
		if (!Arrays.equals(SectionsReports, other.SectionsReports))
			return false;
		if (seats_available != other.seats_available)
			return false;
		if (seats_sold != other.seats_sold)
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		return true;
	}

	



}