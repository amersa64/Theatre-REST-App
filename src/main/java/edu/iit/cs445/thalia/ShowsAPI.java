package edu.iit.cs445.thalia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import seating.Section;
import adapters.SectionAdapter;
import adapters.SectionPriceAdapter;
//import testing.SSS;
import mics.StaticSectionSetup;
import thalia.Donation;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;
import adapters.DonationAdapter;
import adapters.DonationAvailAdapter;
import adapters.ShowAdapter;
import adapters.ShowIDAdapter;
import adapters.ShowSeatingAdapter;
import adapters.ShowSectionAdapter;


//Sets the path to base URL + /test
@Path("/shows")
public class ShowsAPI {
	
	 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response CreateShow(String json) throws ParseException{
		if (json.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		StaticSectionSetup._init();
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		JSONObject show_info_object = (JSONObject)jsonObj.get("show_info");
		JSONArray seating_info_array = (JSONArray)jsonObj.get("seating_info");
		String name = (String) show_info_object.get("name");
		String web = (String) show_info_object.get("web");
		String datestring = (String) show_info_object.get("date");
		String[] dt = datestring.split("-");
		int[] datetokens = Stream.of(dt).mapToInt(Integer::parseInt).toArray();
		LocalDate date = LocalDate.of(datetokens[0], datetokens[1], datetokens[2]);
		String timestring = (String) show_info_object.get("time");
		String[] tt = timestring.split(":");
		int[] timetokens = Stream.of(tt).mapToInt(Integer::parseInt).toArray();
		LocalTime time = LocalTime.of(timetokens[0], timetokens[1], 0);
		Section[] seating_info = new Section[seating_info_array.size()];
		if (show_info_object.equals(null) || name.equals(null) || web.equals(null) || datestring.equals(null) || timestring.equals(null) || seating_info_array.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		
		for (int i = 0; i < seating_info.length; i++){
			JSONObject sectionelement = (JSONObject) seating_info_array.get(i);
			double price = Double.valueOf(sectionelement.get("price").toString());
			switch (sectionelement.get("sid").toString()){
			case "123": //FIX Will change these values in the future
				seating_info[i] = StaticSectionSetup.section_setup.get("Front right");
//				seating_info[i] = SSS.getInstance().getSection_setup().get("Front right");
				seating_info[i].setSid(sectionelement.get("sid").toString());
				seating_info[i].setPrice(price);
				break;
			case "124":
				seating_info[i] = StaticSectionSetup.section_setup.get("Front center");
//				seating_info[i] = SSS.getInstance().getSection_setup().get("Front center");
				seating_info[i].setSid(sectionelement.get("sid").toString());
				seating_info[i].setPrice(price);
				break;
			case "125":
				seating_info[i] = StaticSectionSetup.section_setup.get("Front left");
//				seating_info[i] = SSS.getInstance().getSection_setup().get("Front left");
				seating_info[i].setSid(sectionelement.get("sid").toString());
				seating_info[i].setPrice(price);
				break;
			case "126":
				seating_info[i] = StaticSectionSetup.section_setup.get("Main right");
//				seating_info[i] = SSS.getInstance().getSection_setup().get("Main right");
				seating_info[i].setSid(sectionelement.get("sid").toString());
				seating_info[i].setPrice(price);
				break;
			case "127":
				seating_info[i] = StaticSectionSetup.section_setup.get("Main center");
//				seating_info[i] = SSS.getInstance().getSection_setup().get("Main center");
				seating_info[i].setSid(sectionelement.get("sid").toString());
				seating_info[i].setPrice(price);
				break;
			case "128":
				seating_info[i] = StaticSectionSetup.section_setup.get("Main left");
//				seating_info[i] = SSS.getInstance().getSection_setup().get("Main left");
				seating_info[i].setSid(sectionelement.get("sid").toString());
				seating_info[i].setPrice(price);
				break;
			default:
				return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
			}
		}
		
		Show sh = new Show(time, date, seating_info, name, web);
		Theatre.getInstance().getShows().add(sh);
		ShowIDAdapter sida = new ShowIDAdapter(sh);
//		return Response.ok(sida).build();
		return Response.status(Response.Status.CREATED).entity(sida).build();
	}
	
	@PUT
	@Path("/{wid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateShow(@PathParam("wid") String wid, String json) throws ParseException{
		 if (wid.equals(null)){
			 return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		 }
		 for (int j = 0; j < Theatre.getInstance().getShows().size(); j++){
			 if (wid.equals(Theatre.getInstance().getShows().get(j).getWid())){
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(json);
				JSONObject show_info_object = (JSONObject)jsonObj.get("show_info");
				JSONArray seating_info_array = (JSONArray)jsonObj.get("seating_info");
				String name = (String) show_info_object.get("name");
				String web = (String) show_info_object.get("web");
				String datestring = (String) show_info_object.get("date");
				String[] dt = datestring.split("-");
				int[] datetokens = Stream.of(dt).mapToInt(Integer::parseInt).toArray();
				LocalDate date = LocalDate.of(datetokens[0], datetokens[1], datetokens[2]);
				String timestring = (String) show_info_object.get("time");
				String[] tt = timestring.split(":");
				int[] timetokens = Stream.of(tt).mapToInt(Integer::parseInt).toArray();
				LocalTime time = LocalTime.of(timetokens[0], timetokens[1], 0);
				Section[] seating_info = new Section[seating_info_array.size()];
				if (show_info_object.equals(null) || name.equals(null) || web.equals(null) || datestring.equals(null) || timestring.equals(null) || seating_info_array.equals(null)){
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
				}
				
				for (int i = 0; i < seating_info.length; i++){
					JSONObject sectionelement = (JSONObject) seating_info_array.get(i);
					double price = Double.valueOf(sectionelement.get("price").toString());
					switch (sectionelement.get("sid").toString()){//FIX Will Change to our own values later
					case "123":
						seating_info[i] = StaticSectionSetup.section_setup.get("Front right");
//						seating_info[i] = SSS.getInstance().getSection_setup().get("Front right");
						break;
					case "124":
						seating_info[i] = StaticSectionSetup.section_setup.get("Front center");
//						seating_info[i] = SSS.getInstance().getSection_setup().get("Front center");
						break;
					case "125":
						seating_info[i] = StaticSectionSetup.section_setup.get("Front left");
//						seating_info[i] = SSS.getInstance().getSection_setup().get("Front left");
						break;
					case "126":
						seating_info[i] = StaticSectionSetup.section_setup.get("Main right");
//						seating_info[i] = SSS.getInstance().getSection_setup().get("Main right");
						break;
					case "127":
						seating_info[i] = StaticSectionSetup.section_setup.get("Main center");
//						seating_info[i] = SSS.getInstance().getSection_setup().get("Main center");
						break;
					case "128":
						seating_info[i] = StaticSectionSetup.section_setup.get("Main left");
//						seating_info[i] = SSS.getInstance().getSection_setup().get("Main left");
						break;
					default:
						break;
					}
					seating_info[i].setSid(sectionelement.get("sid").toString());
					seating_info[i].setPrice(price);
				}
				Theatre.getInstance().getShows().get(j).setName(name);
				Theatre.getInstance().getShows().get(j).setDate(date);
				Theatre.getInstance().getShows().get(j).setSeating_info(seating_info);
				Theatre.getInstance().getShows().get(j).setTime(time);
				Theatre.getInstance().getShows().get(j).setWeb(web);;
				return Response.ok().build();
			 }
		 }
		 return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	 
	@GET
	@Path("/{wid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewShow(@PathParam("wid") String wid){
		if (wid.equals(null)){
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		}
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				ShowSeatingAdapter ssa = new ShowSeatingAdapter(show);
				return Response.ok(ssa).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewAllShows(){
		ShowAdapter sh;
		ArrayList<ShowAdapter> listofshows = new ArrayList<ShowAdapter>();
		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
			sh = new ShowAdapter(Theatre.getInstance().getShows().get(i));
			listofshows.add(sh);
		}
		return Response.ok(listofshows).build();
	}
	 
	@GET
	@Path("/{wid}/sections")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewShowSections(@PathParam("wid") String wid){
		if (wid.equals(null)){
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		}
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				SectionAdapter[] saa = new SectionAdapter[show.getSeating_info().length];
				for (int j = 0; j < saa.length; j++){
					saa[j] = new SectionPriceAdapter(show.getSeating_info()[j]);
				}
				return Response.ok(saa).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
	@GET
	@Path("/{wid}/sections/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewSpecificSection(@PathParam("wid") String wid, @PathParam("sid") String sid){
		if (wid.equals(null) || sid.equals(null)){
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		}
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				ShowSectionAdapter ssa = new ShowSectionAdapter(show, sid);
				if (ssa.getRows().equals(null)){
					return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
				}
				return Response.ok(ssa).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
	@POST
	@Path("/{wid}/donations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RequestDonations(@PathParam("wid") String wid, String json) throws ParseException{
		if (json.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		String wid_from_object = (String) jsonObj.get("wid");
		int count = ((Long)jsonObj.get("count")).intValue();
		JSONObject patron_info_object = (JSONObject)jsonObj.get("patron_info");
		String name = (String) patron_info_object.get("name");
		String phone = (String) patron_info_object.get("phone");
		String email = (String) patron_info_object.get("email");
		String billing_address = (String) patron_info_object.get("billing_address");
		String cc_number = (String) patron_info_object.get("cc_number");
		String cc_expiration_date = (String) patron_info_object.get("cc_expiration_date");
		Patron patron_info = new Patron(name, email, phone, billing_address, cc_number, cc_expiration_date);
		if (patron_info_object.equals(null) || name.equals(null) || wid_from_object.equals(null) || count == 0 || phone.equals(null) || email.equals(null) || billing_address.equals(null) || cc_number.equals(null) || cc_expiration_date.equals(null)){
			return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
		}
		
		for (Show show : Theatre.getInstance().getShows()) {
			if (show.getWid().equals(wid) && wid.equals(wid_from_object)) {
				Show sh = show;
				Donation d = new Donation(count, sh, patron_info);
				Theatre.getInstance().add(d);
				DonationAdapter da = new DonationAdapter(d);
				return Response.status(Response.Status.CREATED).entity(da).build();
			}
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Data is missing or Not Found").build();
	}
	
	@GET
	@Path("/{wid}/donations/{did}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonation(@PathParam("wid") String wid, @PathParam("did") String did){
		if (wid.equals(null) || did.equals(null)){
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
		}
		String wid_found = "";
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				wid_found = show.getWid();
				break;
			}
		}
		for (int j = 0; j < Theatre.getInstance().getDonationsRequest().size(); j++){
			if (((Donation) Theatre.getInstance().getDonationsRequest().toArray()[j]).getDid().equals(did) && ((Donation) Theatre.getInstance().getDonationsRequest().toArray()[j]).getShow().getWid().equals(wid_found)){
				Donation d = (Donation) Theatre.getInstance().getDonationsRequest().toArray()[j];
				DonationAvailAdapter daa = new DonationAvailAdapter(d);
				return Response.ok(daa).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
}
