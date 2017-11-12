package edu.iit.cs445.thalia;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Entry").build();
	}
	
	@POST
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateTicket(@PathParam("tid") String tid){
		for (int i = 0; i < Theatre.getInstance().getTickets().size(); i++){
			if (Theatre.getInstance().getTickets().get(i).getTid().equals(tid)){
				Theatre.getInstance().getTickets().get(i).setStatus(TicketStatus.used);
				TicketOrderAdapter toa = new TicketOrderAdapter(Theatre.getInstance().getTickets().get(i));
				return Response.ok(toa).build();
			}
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Entry").build();
	}
}
