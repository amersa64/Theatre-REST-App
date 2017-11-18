package edu.iit.cs445.thalia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import adapters.OrderAdapter;
import adapters.OrderConfirmAdapter;
import adapters.OrderLookAdapter;
import seating.Seat;
import seating.Seat.SeatStatus;
import thalia.Order;
import thalia.Patron;
import thalia.Theatre;

//Sets the path to base URL + /test
@Path("/orders")
public class OrdersAPI {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response CreateOrder(String json) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		JSONObject patron_info_object = (JSONObject)jsonObj.get("patron_info");
		String wid = (String) jsonObj.get("wid");
		String sid = (String) jsonObj.get("sid");
		String name = (String) patron_info_object.get("name");
		String phone = (String) patron_info_object.get("phone");
		String email = (String) patron_info_object.get("email");
		String billing_address = (String) patron_info_object.get("billing_address");
		String cc_number = (String) patron_info_object.get("cc_number");
		String cc_expiration_date = (String) patron_info_object.get("cc_expiration_date");
		Patron patron_info = new Patron(name, email, phone, billing_address, cc_number, cc_expiration_date);
		JSONArray seats_array = (JSONArray)jsonObj.get("seats");
		Seat[] seats = new Seat[seats_array.size()];
		if (patron_info_object.equals(null) || wid.equals(null) || sid.equals(null) || name.equals(null) || phone.equals(null) || email.equals(null) || billing_address.equals(null) || cc_number.equals(null) || cc_expiration_date.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or invalid entry").build();
		}
		for (int i = 0; i < seats.length; i++){
			JSONObject seatObject = (JSONObject) seats_array.get(i);
			seats[i] = new Seat((String) seatObject.get("cid"), (String) seatObject.get("seat"), SeatStatus.available);
		}
		
		Order orderConfirm = Order.confirmOrder(wid, sid, patron_info, seats);
		if (orderConfirm != null) {
			OrderConfirmAdapter oca = new OrderConfirmAdapter(orderConfirm);
			return Response.status(Response.Status.CREATED).entity(oca).build();
		}else{
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or invalid entry").build();	
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewOrdersByDate(@DefaultValue("") @QueryParam("start_date") String start_date, @DefaultValue("") @QueryParam("end_date") String end_date){
		
		if (start_date.equals("") && end_date.equals("")){

			ArrayList<OrderAdapter> listoforders = new ArrayList<OrderAdapter>();
			for (int i = 0; i < Theatre.getInstance().getOrders().size(); i++){
				OrderAdapter oa = new OrderAdapter(Theatre.getInstance().getOrders().get(i));
				listoforders.add(oa);
			}
			return Response.ok(listoforders).build();
		}
		if (!start_date.equals("") && !end_date.equals("")){
			DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
			LocalDate startdate = LocalDate.parse(start_date, formatter);
			LocalDate enddate = LocalDate.parse(end_date, formatter);
			ArrayList<Order> listofOrders = Theatre.getInstance().viewOrdersByDate(startdate, enddate);
			if (listofOrders == null) {
				return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
			}
			OrderAdapter[] orders = new OrderAdapter[listofOrders.size()];

			for (int i = 0; i < orders.length; i++) {
				orders[i] = new OrderAdapter(listofOrders.get(i));
			}

			return Response.ok(orders).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
	@GET
	@Path("/{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewOrder(@PathParam("oid") String oid){
		Order o = Order.viewOrder(oid);
		if (o != null) {
			OrderLookAdapter ola = new OrderLookAdapter(Order.viewOrder(oid));
			return Response.ok(ola).build();

		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
}
