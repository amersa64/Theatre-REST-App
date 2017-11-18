package adapters;

import java.util.ArrayList;

import thalia.Order;
import thalia.Theatre;

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
	public static ArrayList<OrderAdapter> searchOrders(String key){
		ArrayList<OrderAdapter> orderList = new ArrayList<OrderAdapter>();
		if (key.equals("")){
			for (Order order : Theatre.getInstance().getOrders()){
				OrderAdapter oa = new OrderAdapter(order);
				orderList.add(oa);
			}
		}
		else{
			for (Order order  : Theatre.getInstance().getOrders()){
				if (order.toString().contains(key)){
					OrderAdapter oa = new OrderAdapter(order);
					orderList.add(oa);
				}
			}
		}
		return orderList;
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
