package reporting;

import java.time.LocalDate;

import thalia.Show;


public class TheatreRevenueReport extends TheatreReport{
	double overall_revenue=0;
	public TheatreRevenueReport(){
		super();
		this.mrid = 802;
		this.name = "Revenue from ticket sales";
		updateRevenue();
	}
	public TheatreRevenueReport(LocalDate startDate, LocalDate endDate){
		super(startDate,endDate);
		this.mrid = 802;
		this.name = "Revenue from ticket sales";
		updateRevenue();
	}
	
	public TheatreRevenueReport(Show show){
		super(show);
		this.mrid = 802;
		this.name = "Revenue from ticket sales";
		for (Show s : this.shows) {
			if (s.getWid().equals(show.getWid())) {
				ShowRevenueReport srr = new ShowRevenueReport(s);
				this.showsReports[0] = srr;
				this.overall_revenue = srr.getRevenue();
			}
		}
	}
	
	private void updateRevenue(){
		for(int i =0; i< this.shows.length;i++){
			ShowRevenueReport srr = new ShowRevenueReport(theatre.getShows().get(i));
			this.showsReports[i] =srr;
			this.overall_revenue+=srr.getRevenue();
		}
	}
	public double getOverall_revenue() {
		return overall_revenue;
	}
	public void setOverall_revenue(double overall_revenue) {
		this.overall_revenue = overall_revenue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(overall_revenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TheatreRevenueReport other = (TheatreRevenueReport) obj;
		if (Double.doubleToLongBits(overall_revenue) != Double.doubleToLongBits(other.overall_revenue))
			return false;
		return true;
	}
	

}
