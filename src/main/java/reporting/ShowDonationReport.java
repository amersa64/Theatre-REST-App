package reporting;

import thalia.Show;

public class ShowDonationReport extends ShowReport{
	int donated_tickets=0;
	int donated_and_used_tickets=0;
	double donated_and_used_value=0;
	public ShowDonationReport(Show show) {
		super(show);
		updateSectionReports();
	}
	private void updateSectionReports(){
		for(int i=0; i < this.show.getSeating_info().length;i++){
			SectionDonationReport sr = new SectionDonationReport(this.show.getSeating_info()[i]);
			this.SectionsReports[i] = sr;
			this.donated_tickets+=sr.getDonated_tickets();
			this.donated_and_used_tickets+=sr.getDonated_and_used_tickets();
			this.donated_and_used_value+=sr.getDonated_and_used_value();
		}
	}
	public int getDonated_tickets() {
		return donated_tickets;
	}
	public void setDonated_tickets(int donated_tickets) {
		this.donated_tickets = donated_tickets;
	}
	public int getDonated_and_used_tickets() {
		return donated_and_used_tickets;
	}
	public void setDonated_and_used_tickets(int donated_and_used_tickets) {
		this.donated_and_used_tickets = donated_and_used_tickets;
	}
	public double getDonated_and_used_value() {
		return donated_and_used_value;
	}
	public void setDonated_and_used_value(double donated_and_used_value) {
		this.donated_and_used_value = donated_and_used_value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + donated_and_used_tickets;
		long temp;
		temp = Double.doubleToLongBits(donated_and_used_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + donated_tickets;
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
		ShowDonationReport other = (ShowDonationReport) obj;
		if (donated_and_used_tickets != other.donated_and_used_tickets)
			return false;
		if (Double.doubleToLongBits(donated_and_used_value) != Double.doubleToLongBits(other.donated_and_used_value))
			return false;
		if (donated_tickets != other.donated_tickets)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowDonationReport [donated_tickets=" + donated_tickets + ", donated_and_used_tickets="
				+ donated_and_used_tickets + ", donated_and_used_value=" + donated_and_used_value + "]";
	}
	

}
