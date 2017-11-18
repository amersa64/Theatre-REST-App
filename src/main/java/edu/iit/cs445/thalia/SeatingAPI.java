package edu.iit.cs445.thalia;

import javax.ws.rs.PathParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import adapters.FailedSeatRequestAdapter;
import adapters.SeatRequestAdapter;
import adapters.SectionNameAdapter;
import adapters.SectionNumberAdapter;
//import testing.SSS;
import mics.StaticSectionSetup;
import thalia.Show;
import thalia.Theatre;

//Sets the path to base URL + /test
@Path("/seating")
public class SeatingAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response RequestSeats(@DefaultValue("") @QueryParam("show") String wid, @DefaultValue("") @QueryParam("section") String sid, @DefaultValue("0") @QueryParam("count") int count, @DefaultValue("") @QueryParam("starting_seat_id") String cid){
		if (wid.equals("") && sid.equals("") && cid.equals("")){
			return Response.ok(SectionNameAdapter.defaultSectionsSetup()).build();
		}
		if (!wid.equals("") && !sid.equals("") && count!=0){
			Show sh = Theatre.getInstance().searchShowId(wid);
			if (sh == null) {
				return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
			}
			SeatRequestAdapter sra = sh.requestSeats(sid,count,cid);
			if (sra.getTotal_amount() == 0) {
				FailedSeatRequestAdapter fsra = new FailedSeatRequestAdapter(sra);
				return Response.ok(fsra).build();
			}
			else {
				return Response.ok(sra).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
	@GET
	@Path("/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewSpecificSeats(@PathParam("sid") String sid) {
		StaticSectionSetup._init();//
		StaticSectionSetup.revertCid();
		SectionNumberAdapter sna;
		String section_name = StaticSectionSetup.sid_section_name_setup.get(sid);
		if(section_name==null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		}
		sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get(section_name));
		sna.setSid(sid);
		return Response.ok(sna).build();
	}
}
