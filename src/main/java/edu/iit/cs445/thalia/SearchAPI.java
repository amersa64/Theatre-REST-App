package edu.iit.cs445.thalia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /test
@Path("/search")
public class SearchAPI {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String Search(@QueryParam("topic") String Topicword, @QueryParam("key") String keyword){
		return "Search";
	}
}