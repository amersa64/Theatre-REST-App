package edu.iit.cs445.thalia;
import javax.ws.rs.PathParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import reporting.TheatreDonationReport;
import reporting.TheatreOccupancyReport;
import reporting.TheatreRevenueReport;
import reporting.adapters.TheatreAdapter;
import reporting.adapters.TheatreDonationAdapter;
import reporting.adapters.TheatreOccupancyAdapter;
import reporting.adapters.TheatreRevenueAdapter;
import reporting.adapters.TheatreShowDonationAdapter;
import reporting.adapters.TheatreShowOccupancyAdapter;
import reporting.adapters.TheatreShowRevenueAdapter;
import thalia.Show;
import thalia.Theatre;

//Sets the path to base URL + /test
@Path("/reports")
public class ReportsAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetListOfAvailableReports(){
		TheatreAdapter[] ta = new TheatreAdapter[3];
		ta[0] = new TheatreAdapter("801", "Theatre occupancy");
		ta[1] = new TheatreAdapter("802", "Revenue from ticket sales");
		ta[2] = new TheatreAdapter("803", "Donated tickets report");
		return Response.ok(ta).build();
	}
	
	@GET
	@Path("/{mrid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetReport(@PathParam("mrid") String mrid, @DefaultValue("") @QueryParam("show") String wid, @DefaultValue("") @QueryParam("start_date") String start_date, @DefaultValue("")  @QueryParam("end_date") String end_date){
		if (start_date.equals("") && end_date.equals("") && wid.equals("")){
			switch (mrid){
			case "801":
				TheatreOccupancyReport tor = new TheatreOccupancyReport();
				TheatreOccupancyAdapter toa = new TheatreOccupancyAdapter(tor);
				return Response.ok(toa).build();
			case "802":
				TheatreRevenueReport trr = new TheatreRevenueReport();
				TheatreRevenueAdapter tra = new TheatreRevenueAdapter(trr);
				return Response.ok(tra).build();
			case "803":
				TheatreDonationReport tdr = new TheatreDonationReport();
				TheatreDonationAdapter tda = new TheatreDonationAdapter(tdr);
				return Response.ok(tda).build();
			default:
				return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
			}
		}
		
		else if(start_date.equals("") && end_date.equals("") && !wid.equals("")){
			
			for (Show show : Theatre.getInstance().getShows()){
				if (show.getWid().equals(wid)){
					Show sh = show;
					switch (mrid){
					case "801":
						TheatreOccupancyReport tor = new TheatreOccupancyReport(sh);
						TheatreShowOccupancyAdapter tsoa = new TheatreShowOccupancyAdapter(tor);
						
						return Response.ok(tsoa).build();
					case "802":
						TheatreRevenueReport trr = new TheatreRevenueReport(sh);
						TheatreShowRevenueAdapter tsra = new TheatreShowRevenueAdapter(trr);
						return Response.ok(tsra).build();
					case "803":
						TheatreDonationReport tdr = new TheatreDonationReport(sh);
						TheatreShowDonationAdapter tsda = new TheatreShowDonationAdapter(tdr);
						return Response.ok(tsda).build();
						
					default:
						return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
					}
				}
			}
		}
		else if (!start_date.equals("") && !end_date.equals("") && wid.equals("")){
			DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
			LocalDate startdate = LocalDate.parse(start_date, formatter);
			LocalDate enddate = LocalDate.parse(end_date, formatter);
			switch (mrid){
			case "801":
				TheatreOccupancyReport tor = new TheatreOccupancyReport(startdate, enddate);
				TheatreOccupancyAdapter toa = new TheatreOccupancyAdapter(tor);
				if (toa.getShows().length == 0) {
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
				}
				return Response.ok(toa).build();
			case "802":
				TheatreRevenueReport trr = new TheatreRevenueReport(startdate, enddate);
				TheatreRevenueAdapter tra = new TheatreRevenueAdapter(trr);
				if (tra.getShows().length == 0) {
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
				}
				return Response.ok(tra).build();
			case "803":
				TheatreDonationReport tdr = new TheatreDonationReport(startdate, enddate);
				TheatreDonationAdapter tda = new TheatreDonationAdapter(tdr);
				if (tda.getShows().length == 0) {
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
				}
				return Response.ok(tda).build();
			default:
				return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
			}
		}
		
		
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}

}
