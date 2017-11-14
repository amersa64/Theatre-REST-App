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

import adapters.TicketAdapter;
import adapters.TicketOrderAdapter;
import thalia.Theatre;
import thalia.Ticket;
import thalia.Ticket.TicketStatus;

//Sets the path to base URL + /test
@Path("/tickets")
public class TicketsAPI {
	
	@GET
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewTicket(@PathParam("tid") String tid){
		for (Ticket t : Theatre.getInstance().getTickets()){
			if (t.getTid().equals(tid)){
				TicketAdapter ta = new TicketAdapter(t);
				return Response.ok(ta).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
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
		
		for (int i = 0; i < Theatre.getInstance().getTickets().size(); i++){
			if (Theatre.getInstance().getTickets().get(i).getTid().equals(tid)){
				Theatre.getInstance().getTickets().get(i).setStatus(TicketStatus.used);
				TicketOrderAdapter toa = new TicketOrderAdapter(Theatre.getInstance().getTickets().get(i));
				return Response.status(Response.Status.CREATED).entity(toa).build();
			}
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
	}
	
	@POST
	@Path("/donations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DonateTicket(String json) throws ParseException {
		int count = 0;
		if (json.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		JSONArray jsonArray = (JSONArray) jsonObj.get("tickets");
		String[] ticketIds = new String[jsonArray.size()];
		for (int i = 0; i < ticketIds.length; i++) {
			ticketIds[i] = (String) jsonArray.get(i);
		}
		
		for (int j = 0; j < ticketIds.length; j++) {
			for (Ticket ticketlist : Theatre.getInstance().getTickets()) {
				if (ticketlist.getTid().equals(ticketIds[j])) {
					count++;
//					ticketlist.setDonated(true);
					Theatre.getInstance().addD(ticketlist);
					if (count == ticketIds.length) {
						return Response.ok().build();
					}
				}
			}
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
	}
	
	
}
