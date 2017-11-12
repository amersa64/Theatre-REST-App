package edu.iit.cs445.thalia;
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
import seating.Section;
import thalia.Order;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;

//Sets the path to base URL + /test
@Path("/orders")
public class OrdersAPI {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response CreateOrder(String json) throws ParseException{
//		Order o = new Order (Theatre.getInstance().getShows().get(0), Theatre.getInstance().getShows().get(0).getSeating_info()[0], )
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
			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Entry").build();
		}
		for (int i = 0; i < seats.length; i++){
			JSONObject seatObject = (JSONObject) seats_array.get(i);
			seats[i] = new Seat((String) seatObject.get("cid"), (String) seatObject.get("seat"), SeatStatus.available);
		}
		
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			if (Theatre.getInstance().getShows().get(i).getWid().equals(wid)){
//				for (int j = 0; j < Theatre.getInstance().getShows().get(i).getSeating_info().length; j++){
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				for (Section section : show.getSeating_info()){
					if (section.getSid().equals(sid)){
//					if (Theatre.getInstance().getShows().get(i).getSeating_info()[j].getSid().equals(sid)){
						Order o = new Order (show, section, patron_info, seats);
//								(Theatre.getInstance().getShows().get(i),
//								Theatre.getInstance().getShows().get(i).getSeating_info()[j],
//								patron_info,
//								seats);
						Theatre.getInstance().add(o);
						OrderConfirmAdapter oa = new OrderConfirmAdapter(o);
						
						return Response.ok(oa).build();
					}
				}
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<OrderAdapter> ViewOrdersByDate(@DefaultValue("") @QueryParam("start_date") String start_date, @DefaultValue("") @QueryParam("end_date") String end_date){
		
		if (start_date.equals("") && end_date.equals("")){
			OrderAdapter oa;
			ArrayList<OrderAdapter> listoforders = new ArrayList<OrderAdapter>();
			for (int i = 0; i < Theatre.getInstance().getOrders().size(); i++){
				oa = new OrderAdapter(Theatre.getInstance().getOrders().get(i));
				listoforders.add(oa);
			}
			return listoforders;
		}
		if (start_date != null && end_date != null){
			return null;
		}
		return null;
	}
	
	@GET
	@Path("/{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderLookAdapter ViewOrder(@PathParam("oid") String oid){
		for (int i = 0; i < Theatre.getInstance().getOrders().size(); i++){
			if (Theatre.getInstance().getOrders().get(i).getOid().equals(oid)){
				OrderLookAdapter ola = new OrderLookAdapter(Theatre.getInstance().getOrders().get(i));
				return ola;
			}
		}
		return null;
	}
}
