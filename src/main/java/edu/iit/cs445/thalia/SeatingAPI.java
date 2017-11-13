package edu.iit.cs445.thalia;

import javax.ws.rs.PathParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import adapters.RowAvailAdapter;
import adapters.SeatRequestAdapter;
import adapters.SectionNameAdapter;
import adapters.SectionNumberAdapter;
import mics.StaticSectionSetup;
import seating.Section;
import seating.Row;
import seating.Seat;
import thalia.Show;
import thalia.Theatre;

//Sets the path to base URL + /test
@Path("/seating")
public class SeatingAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response RequestSeats(@DefaultValue("") @QueryParam("show") String wid, @DefaultValue("") @QueryParam("section") String sid, @DefaultValue("0") @QueryParam("count") int count, @DefaultValue("") @QueryParam("starting_seat_id") String cid){
		if (wid.equals("") && sid.equals("") && cid.equals("")){
			StaticSectionSetup._init();
			SectionNameAdapter[] sna = new SectionNameAdapter[6];
			sna[0] = new SectionNameAdapter(StaticSectionSetup.section_setup.get("Front right"));
			sna[1] = new SectionNameAdapter(StaticSectionSetup.section_setup.get("Front center"));
			sna[2] = new SectionNameAdapter(StaticSectionSetup.section_setup.get("Front left"));
			sna[3] = new SectionNameAdapter(StaticSectionSetup.section_setup.get("Main right"));
			sna[4] = new SectionNameAdapter(StaticSectionSetup.section_setup.get("Main center"));
			sna[5] = new SectionNameAdapter(StaticSectionSetup.section_setup.get("Main left"));
			return Response.ok(sna).build();
		}
		if (!wid.equals("") && !sid.equals("") && count!=0 && cid.equals("")){
			Show sh = Theatre.getInstance().searchShowId(wid);
			for (Section section : sh.getSeating_info()){
				if (section.getSid().equals(sid)){
					
					Section s = section;
					Row row = s.reqNewSeats(count, 0, 0);
					RowAvailAdapter raa = null;
					if (row != null){
						raa = new RowAvailAdapter(row);
					}
					SeatRequestAdapter sra = new SeatRequestAdapter(sh, s, raa, count);
					return Response.ok(sra).build();
				}
			}
		}
		if (!wid.equals("") && !sid.equals("") && count!=0 && !cid.equals("")){
			Show sh = Theatre.getInstance().searchShowId(wid);

			for (Section section : sh.getSeating_info()){
				if (section.getSid().equals(sid)){
					int rowIndex =0;
					for (Row row : section.getRows()){
						int seatIndex = 0;
						for (Seat seat : row.getSeats()){
							if (seat.getCid().equals(cid)){
								Section s = section;
								Row r = s.reqNewSeats(count, rowIndex, seatIndex);
								RowAvailAdapter raa = null;
								if (r != null){
									raa = new RowAvailAdapter(r);
								}
								SeatRequestAdapter sra = new SeatRequestAdapter(sh, s, raa, count);
								return Response.ok(sra).build();
							}
							seatIndex++;
						}
						rowIndex++;
					}
				}
			}
		}	
		return Response.status(Response.Status.NOT_FOUND).entity("Invalid Entry").build();
	}
	
	@GET
	@Path("/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewSpecificSeats(@PathParam("sid") String sid) {
		StaticSectionSetup._init();
		SectionNumberAdapter sna;
		switch (sid){
		case "123":
			sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get("Front right"));
			return Response.ok(sna).build();
		case "124":
			sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get("Front center"));
			return Response.ok(sna).build();
		case "125":
			sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get("Front left"));
			return Response.ok(sna).build();
		case "126":
			sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get("Main right"));
			return Response.ok(sna).build();
		case "127":
			sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get("Main center"));
			return Response.ok(sna).build();
		case "128":
			sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get("Main left"));
			return Response.ok(sna).build();
		default:
			return Response.status(Response.Status.NOT_FOUND).entity("Invalid Entry").build();
		}
	}
}
