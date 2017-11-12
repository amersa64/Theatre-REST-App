//package edu.iit.cs445.thalia;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.stream.Stream;
//
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import adapters.DonationAdapter;
//import adapters.DonationAvailAdapter;
//import adapters.SectionAdapter;
//import adapters.SectionNameAdapter;
//import adapters.ShowAdapter;
//import adapters.ShowIDAdapter;
//import adapters.ShowSeatingAdapter;
//import adapters.ShowSectionAdapter;
//import seating.Section;
//import testing.StaticSectionSetup;
//import thalia.Donation;
//import thalia.Patron;
//import thalia.Show;
//import thalia.Theatre;
//
//
////Sets the path to base URL + /test
//@Path("/shows")
//public class ShowsAPI {
//	
//	 
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response CreateShow(String json) throws ParseException{
//		if (json.equals(null)){
//			return Response.status(Response.Status.NOT_FOUND).entity("Invalid Entry").build();
//		}
//		StaticSectionSetup._init();
//		JSONParser parser = new JSONParser();
//		JSONObject jsonObj = (JSONObject) parser.parse(json);
//		JSONObject show_info_object = (JSONObject)jsonObj.get("show_info");
//		JSONArray seating_info_array = (JSONArray)jsonObj.get("seating_info");
//		String name = (String) show_info_object.get("name");
//		String web = (String) show_info_object.get("web");
//		String datestring = (String) show_info_object.get("date");
//		String[] dt = datestring.split("-");
//		int[] datetokens = Stream.of(dt).mapToInt(Integer::parseInt).toArray();
//		LocalDate date = LocalDate.of(datetokens[0], datetokens[1], datetokens[2]);
//		String timestring = (String) show_info_object.get("time");
//		String[] tt = timestring.split(":");
//		int[] timetokens = Stream.of(tt).mapToInt(Integer::parseInt).toArray();
//		LocalTime time = LocalTime.of(timetokens[0], timetokens[1], 0);
//		Section[] seating_info = new Section[seating_info_array.size()];
//		
//		for (int i = 0; i < seating_info.length; i++){
//			JSONObject sectionelement = (JSONObject) seating_info_array.get(i);
//			double price = Double.valueOf(sectionelement.get("price").toString());
//			switch (sectionelement.get("sid").toString()){
//			case "123":
//				seating_info[i] = StaticSectionSetup.section_setup.get("Front right");
//				seating_info[i].setSid(sectionelement.get("sid").toString());
//				seating_info[i].setPrice(price);
//				break;
//			case "124":
//				seating_info[i] = StaticSectionSetup.section_setup.get("Front center");
//				seating_info[i].setSid(sectionelement.get("sid").toString());
//				seating_info[i].setPrice(price);
//				break;
//			case "125":
//				seating_info[i] = StaticSectionSetup.section_setup.get("Front left");
//				seating_info[i].setSid(sectionelement.get("sid").toString());
//				seating_info[i].setPrice(price);
//				break;
//			case "126":
//				seating_info[i] = StaticSectionSetup.section_setup.get("Main right");
//				seating_info[i].setSid(sectionelement.get("sid").toString());
//				seating_info[i].setPrice(price);
//				break;
//			case "127":
//				seating_info[i] = StaticSectionSetup.section_setup.get("Main center");
//				seating_info[i].setSid(sectionelement.get("sid").toString());
//				seating_info[i].setPrice(price);
//				break;
//			case "128":
//				seating_info[i] = StaticSectionSetup.section_setup.get("Main left");
//				seating_info[i].setSid(sectionelement.get("sid").toString());
//				seating_info[i].setPrice(price);
//				break;
//			default:
//				break;
//			}
//		}
//		
//		Show sh = new Show(time, date, seating_info, name, web);
//		Theatre.getInstance().getShows().add(sh);
//		ShowIDAdapter sida = new ShowIDAdapter(sh);
//		return Response.ok(sida).build();
//		
//	}
//	
//	@PUT
//	@Path("/{wid}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void UpdateShow(@PathParam("wid") String wid, String json) throws ParseException{
//		 if (wid.equals(null)){
//			 return;
//		 }
//		 for (int j = 0; j < Theatre.getInstance().getShows().size(); j++){
//			 if (wid.equals(Theatre.getInstance().getShows().get(j).getWid())){
//				JSONParser parser = new JSONParser();
//				JSONObject jsonObj = (JSONObject) parser.parse(json);
//				JSONObject show_info_object = (JSONObject)jsonObj.get("show_info");
//				JSONArray seating_info_array = (JSONArray)jsonObj.get("seating_info"); //Need to fix Section (Names)
//				String name = (String) show_info_object.get("name");
//				String web = (String) show_info_object.get("web");
//				String datestring = (String) show_info_object.get("date");
//				String[] dt = datestring.split("-");
//				int[] datetokens = Stream.of(dt).mapToInt(Integer::parseInt).toArray();
//				LocalDate date = LocalDate.of(datetokens[0], datetokens[1], datetokens[2]);
//				String timestring = (String) show_info_object.get("time");
//				String[] tt = timestring.split(":");
//				int[] timetokens = Stream.of(tt).mapToInt(Integer::parseInt).toArray();
//				LocalTime time = LocalTime.of(timetokens[0], timetokens[1], 0);
//				Section[] seating_info = new Section[seating_info_array.size()];
//				
//				for (int i = 0; i < seating_info.length; i++){
//					JSONObject sectionelement = (JSONObject) seating_info_array.get(i);
//					double price = Double.valueOf(sectionelement.get("price").toString());
//					switch (sectionelement.get("sid").toString()){
//					case "123":
//						seating_info[i] = StaticSectionSetup.section_setup.get("Front right");
//						break;
//					case "124":
//						seating_info[i] = StaticSectionSetup.section_setup.get("Front center");
//						break;
//					case "125":
//						seating_info[i] = StaticSectionSetup.section_setup.get("Front left");
//						break;
//					case "126":
//						seating_info[i] = StaticSectionSetup.section_setup.get("Main right");
//						break;
//					case "127":
//						seating_info[i] = StaticSectionSetup.section_setup.get("Main center");
//						break;
//					case "128":
//						seating_info[i] = StaticSectionSetup.section_setup.get("Main left");
//						break;
//					default:
//						break;
//					}
//					seating_info[i].setSid(sectionelement.get("sid").toString());
//					seating_info[i].setPrice(price);
//				}
//				Theatre.getInstance().getShows().get(j).setName(name);
//				Theatre.getInstance().getShows().get(j).setDate(date);
//				Theatre.getInstance().getShows().get(j).setSeating_info(seating_info);
//				Theatre.getInstance().getShows().get(j).setTime(time);
//				Theatre.getInstance().getShows().get(j).setWeb(web);;
//				return;
//			 }
//		 }
//	}
//	 
//	@GET
//	@Path("/{wid}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ShowSeatingAdapter ViewShow(@PathParam("wid") String wid){
//		if (wid.equals(null)){
//			return null;
//		}
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			if (wid.equals(Theatre.getInstance().getShows().get(i).getWid())){
//				ShowSeatingAdapter ssa = new ShowSeatingAdapter(Theatre.getInstance().getShows().get(i));
//				return ssa;
//			}
//		}
//		return null;
//	}
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<ShowAdapter> ViewAllShows(){
//		ShowAdapter sh;
//		ArrayList<ShowAdapter> listofshows = new ArrayList<ShowAdapter>();
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			sh = new ShowAdapter(Theatre.getInstance().getShows().get(i));
//			listofshows.add(sh);
//		}
//		return listofshows;
//	}
//	 
//	@GET
//	@Path("/{wid}/sections")
//	@Produces(MediaType.APPLICATION_JSON)
//	public SectionAdapter[] ViewShowSections(@PathParam("wid") String wid){
//		if (wid.equals(null)){
//			return null;
//		}
//		
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			if (wid.equals(Theatre.getInstance().getShows().get(i).getWid())){
//				SectionAdapter[] saa = new SectionAdapter[Theatre.getInstance().getShows().get(i).getSeating_info().length];
//				for (int j = 0; j < saa.length; j++){
////					Section section = Theatre.getInstance().getShows().get(i).getSeating_info()[j];
//					saa[j] = new SectionNameAdapter(Theatre.getInstance().getShows().get(i).getSeating_info()[j]);
//				}
//				return saa;
//			}
//		}
//		return null;
//	}
//	
//	@GET
//	@Path("/{wid}/sections/{sid}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ShowSectionAdapter ViewSpecificSection(@PathParam("wid") String wid, @PathParam("sid") String sid){
//		if (wid.equals(null) || sid.equals(null)){
//			return null;
//		}
////		Show s = new Show();
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			if (wid.equals(Theatre.getInstance().getShows().get(i).getWid())){
//				ShowSectionAdapter ssa = new ShowSectionAdapter(Theatre.getInstance().getShows().get(i), sid);
//				return ssa;
////				s = Theatre.getInstance().getShows().get(i);
////				break;
//			}
//		}
////		for (int j = 0; j < s.getSeating_info().length; j++){
////			if (sid.equals(s.getSeating_info()[j].getSid())){
////				SectionSeatingAdapter sna = new SectionSeatingAdapter(s.getSeating_info()[j]);
////				return sna;
////			}
////		}
//		return null;
//	}
//	
//	@POST
//	@Path("/{wid}/donations")
//	@Produces(MediaType.APPLICATION_JSON)
//	public DonationAdapter RequestDonations(@PathParam("wid") String wid, String json) throws ParseException{
//		if (json.equals(null)){
////			return Response.status(Response.Status.NOT_FOUND).entity("Invalid Entry").build();
//			return null;
//		}
//		JSONParser parser = new JSONParser();
//		JSONObject jsonObj = (JSONObject) parser.parse(json);
//		String wid_from_object = (String) jsonObj.get("wid");
//		int count = ((Long)jsonObj.get("count")).intValue();
//		JSONObject patron_info_object = (JSONObject)jsonObj.get("patron_info");
//		String name = (String) patron_info_object.get("name");
//		String phone = (String) patron_info_object.get("phone");
//		String email = (String) patron_info_object.get("email");
//		String billing_address = (String) patron_info_object.get("billing_address");
//		String cc_number = (String) patron_info_object.get("cc_number");
//		String cc_expiration_date = (String) patron_info_object.get("cc_expiration_date");
//		Patron patron_info = new Patron(name, email, phone, billing_address, cc_number, cc_expiration_date);
//		
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			if (Theatre.getInstance().getShows().get(i).getWid().equals(wid) && wid.equals(wid_from_object)){
//				Show sh = Theatre.getInstance().getShows().get(i);//When passing show, I don't think it'll update the values whenever we change anything with it
//				Donation d = new Donation(count, sh, patron_info);
//				Theatre.getInstance().add(d);
//				DonationAdapter da = new DonationAdapter(d);
//				return da;
////				return d;
//			}
//		}
//		return null;
//	}
//	
//	@GET
//	@Path("/{wid}/donations/{did}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public DonationAvailAdapter getDonation(@PathParam("wid") String wid, @PathParam("did") String did){
//		if (wid.equals(null) || did.equals(null)){
//			return null;
//		}
//		String wid_found = "";
//		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
//			if (Theatre.getInstance().getShows().get(i).getWid().equals(wid)){
//				wid_found = Theatre.getInstance().getShows().get(i).getWid();
//				break;
//			}
//		}
//		for (int j = 0; j < Theatre.getInstance().getDonatees().size(); j++){
//			if (Theatre.getInstance().getDonatees().get(j).getDid().equals(did) && Theatre.getInstance().getDonatees().get(j).getShow().getWid().equals(wid_found)){
//				System.out.println("HI1");
//				Donation d = Theatre.getInstance().getDonatees().get(j);
//				System.out.println("HI2");
//				DonationAvailAdapter daa = new DonationAvailAdapter(d);
//				System.out.println("HI3");
//				System.out.println(daa.toString());
//				return daa;
//			}
//		}
//		return null;
//	}
//	
//}
