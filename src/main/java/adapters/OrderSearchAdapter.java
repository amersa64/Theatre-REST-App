package adapters;

import java.util.ArrayList;

public class OrderSearchAdapter {
	
	ArrayList<OrderAdapter> orders;
	public OrderSearchAdapter(ArrayList<OrderAdapter> oa) {
		this.orders = oa;
	}
	public ArrayList<OrderAdapter> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<OrderAdapter> oa) {
		this.orders = oa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
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
		OrderSearchAdapter other = (OrderSearchAdapter) obj;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderSearchAdapter [orders=" + orders + "]";
	}
	
	

}
