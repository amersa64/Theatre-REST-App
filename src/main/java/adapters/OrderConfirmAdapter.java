
package adapters;

import thalia.Order;

public class OrderConfirmAdapter {
	String oid;
	String wid;
	ShowDataAdapter show_info;
	String  date_ordered;
	double order_amount;
	String[] tickets;
	public OrderConfirmAdapter(Order order){
		this.oid=order.getOid();
		this.wid= order.getShow().getWid();
		this.show_info= new ShowDataAdapter(order.getShow().getShow_info());
		int iyear = order.getDate_ordered().getYear();
		int imonth = order.getDate_ordered().getMonthValue();
		int iday = order.getDate_ordered().getDayOfMonth();
		int ihour = order.getDate_ordered().getHour();
		int iminute = order.getDate_ordered().getMinute();
		String year = String.valueOf(iyear);
		String month = String.valueOf(imonth);
		String day = String.valueOf(iday);
		String hour = String.valueOf(ihour);
		String minute = String.valueOf(iminute);
		this.date_ordered = (year + "-" + month + "-" + day + " " + hour + ":" + minute);
		this.order_amount=order.getOrder_amount();
		this.tickets = new String[order.getTickets().length];
		for (int i = 0; i < order.getTickets().length; i++){
			this.tickets[i] = order.getTickets()[i].getTid();
		}
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
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
	public String getDate_ordered() {
		return date_ordered;
	}
	public void setDate_ordered(String date_ordered) {
		this.date_ordered = date_ordered;
	}
	public double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}
	public String[] getTickets() {
		return tickets;
	}
	public void setTickets(String[] tickets) {
		this.tickets = tickets;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_ordered == null) ? 0 : date_ordered.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(order_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OrderConfirmAdapter other = (OrderConfirmAdapter) obj;
		if (date_ordered == null) {
			if (other.date_ordered != null)
				return false;
		} else if (!date_ordered.equals(other.date_ordered))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Double.doubleToLongBits(order_amount) != Double.doubleToLongBits(other.order_amount))
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
		return "OrderAdapter [oid=" + oid + ", wid=" + wid + ", show_info=" + show_info + ", date_ordered="
				+ date_ordered + ", order_amount=" + order_amount + "]";
	}
	
	

}
