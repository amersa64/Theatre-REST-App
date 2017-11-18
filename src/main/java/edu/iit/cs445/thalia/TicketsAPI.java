package edu.iit.cs445.thalia;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import adapters.PutAdapter;
import adapters.TicketAdapter;
import adapters.TicketOrderAdapter;
import thalia.Theatre;
import thalia.Ticket;

//Sets the path to base URL + /test
@Path("/tickets")
public class TicketsAPI {
	
	@GET
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewTicket(@PathParam("tid") String tid){
		Ticket t = Theatre.getInstance().findTicketByTid(tid);
		if(t == null)
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		TicketAdapter ta = new TicketAdapter(t);
		return Response.ok(ta).build();
	}
	
	@POST
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateTicket(@PathParam("tid") String tid, String json) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		String jsonticketId = (String)jsonObj.get("tid");
		if (!tid.equals(jsonticketId)) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		TicketOrderAdapter toa = Theatre.getInstance().updateTicketByTid(tid);
		if(toa!=null) {
			return Response.status(Response.Status.CREATED).entity(toa).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
	}
	
	@POST
	@Path("/donations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DonateTicket(String json) throws ParseException {
		if (json.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		JSONArray jsonArray = (JSONArray) jsonObj.get("tickets");
		boolean success = false;
		for (Object thing: jsonArray) {
			success =Theatre.getInstance().donateTicketByTid(thing.toString());
		}
		if(success) {
			PutAdapter pa = new PutAdapter();
			return Response.ok(pa).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
	}
	
	
}
