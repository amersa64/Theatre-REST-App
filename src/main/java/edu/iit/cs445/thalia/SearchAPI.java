package edu.iit.cs445.thalia;

import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import adapters.OrderAdapter;
import adapters.OrderSearchAdapter;
import adapters.ShowAdapter;
import adapters.ShowSearchAdapter;
import thalia.Order;
import thalia.Show;
import thalia.Theatre;

//Sets the path to base URL + /test
@Path("/search")
public class SearchAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Search(@DefaultValue("") @QueryParam("topic") String topic, @DefaultValue("") @QueryParam("key") String key){
		if (!topic.equals("")){
			switch (topic){
				case "show":
					ArrayList<ShowAdapter> showList = new ArrayList<ShowAdapter>();
					if (key.equals("")){
						for (Show show : Theatre.getInstance().getShows()){
							ShowAdapter sa = new ShowAdapter(show);
							showList.add(sa);
						}
					}
					else{
						for (Show show : Theatre.getInstance().getShows()){
							if (show.toString().contains(key)){
								ShowAdapter sa = new ShowAdapter(show);
								showList.add(sa);
							}
						}
					}
					ShowSearchAdapter ssa = new ShowSearchAdapter(showList);
					return Response.ok(ssa).build();
				case "order":
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
					OrderSearchAdapter osa = new OrderSearchAdapter(orderList);
					return Response.ok(osa).build();
				default: 
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
}
//for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//	sh = new ShowAdapter(Theatre.getInstance().getShows().get(i));
//	listofshows.add(sh);
//}

//ArrayList<Show> shows;
//ArrayList<Order> orders;
//ArrayList<Ticket> tickets;
//Queue<Donation> donationsRequest;
//ArrayList<Ticket> donatedTickets;
//ArrayList<Patron> patrons;