package edu.iit.cs445.thalia;
import javax.ws.rs.PathParam;


import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import reporting.TheatreOccupancyReport;

//Sets the path to base URL + /test
@Path("/reports")
public class ReportsAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String GetListOfAvailableReports(){
		return "GetListOfAvailableReports";	
	}
	
	@GET
	@Path("/{mrid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetReport(@PathParam("mrid") String mrid, @DefaultValue("") @QueryParam("start_date") String start_date,@DefaultValue("")  @QueryParam("end_date") String end_date){
		if (start_date.equals("") && end_date.equals("")){
			switch (mrid){
			case "801":
				TheatreOccupancyReport tor = new TheatreOccupancyReport();
				return Response.ok(tor).build();
			default:
				break;
			}
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Entry").build();
	}

}
