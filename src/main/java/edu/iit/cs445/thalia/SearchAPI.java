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

//Sets the path to base URL + /test
@Path("/search")
public class SearchAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Search(@DefaultValue("") @QueryParam("topic") String topic, @DefaultValue("") @QueryParam("key") String key){
		if (!topic.equals("")){
			switch (topic){
				case "show":
					ArrayList<ShowAdapter>  saal = ShowSearchAdapter.searchShows(key);
					if (saal != null) {
						ShowSearchAdapter ssa = new ShowSearchAdapter(saal);
						return Response.ok(ssa).build();
					}
					else {
						return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
					}
				case "order":
					ArrayList<OrderAdapter> oaal = OrderSearchAdapter.searchOrders(key);
					if (oaal != null) {
						OrderSearchAdapter osa = new OrderSearchAdapter(oaal);
						return Response.ok(osa).build();
					}
					else {
						return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
					}
				default: 
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
}