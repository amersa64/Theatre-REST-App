package thalia;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import adapters.RowAvailAdapter;
import adapters.SeatRequestAdapter;
import adapters.SectionAdapter;
import adapters.SectionPriceAdapter;
import adapters.ShowAdapter;
import adapters.ShowSectionAdapter;
import mics.StaticSectionSetup;
import seating.*;

import utility.ShowIDGenerator;

public class Show {
	String wid;
	Section[]  seating_info; //Should Delete?
	ShowData show_info = new ShowData();
	public void updateSection(Section section){
		for(Section s: seating_info){
			if(s.getSid().equals(section.getSid()))
				s = section;
		}
	}
	public Show(){
		this.wid = String.valueOf(ShowIDGenerator.getInstance().getNext());
		this.show_info.setTime(LocalTime.of(12,12,12));
		this.show_info.setDate(LocalDate.of(2017, 12, 12));
		this.seating_info = new Section[6];
		for (int i = 0; i < this.seating_info.length; i++){
			this.seating_info[i] = new Section();
		}
		this.show_info.setName("Name");
		this.show_info.setWeb("URL");
	}
	public Show(LocalTime time, LocalDate date, Section[] theatre,String name, String web){
		this.wid = String.valueOf(ShowIDGenerator.getInstance().getNext());
		this.show_info.setTime(time);
		this.show_info.setDate(date);
		this.seating_info = theatre;
		this.show_info.setName(name);
		this.show_info.setWeb(web);
	}


	public static Show createShow(LocalTime time, LocalDate date, Section[] seating_info, String name, String web, JSONArray seating_info_array) {

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
				return null;
			}
		}














		
		Show sh = new Show(time, date, seating_info, name, web);
		Theatre.getInstance().getShows().add(sh);
		return sh;
	}
	
	public static boolean updateShow(String wid, String json) throws ParseException{
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
					return false;
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
						return false;
					}
					Theatre.getInstance().getShows().get(j).getSeating_info()[i].setSid(sectionelement.get("sid").toString());
					Theatre.getInstance().getShows().get(j).getSeating_info()[i].setPrice(price);
				}
				Theatre.getInstance().getShows().get(j).setName(name);
				Theatre.getInstance().getShows().get(j).setDate(date);
				Theatre.getInstance().getShows().get(j).setTime(time);
				Theatre.getInstance().getShows().get(j).setWeb(web);
				return true;
			 }
		}
		return false;
	}
	
	public static Show viewShow(String wid) {
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				return show;
			}




		}
		return null;
	}
	
	public static ArrayList<ShowAdapter> viewAllShows(){
		ShowAdapter sh;
		ArrayList<ShowAdapter> listofshows = new ArrayList<ShowAdapter>();
		for (int i = 0; i < Theatre.getInstance().getShows().size(); i++){
			sh = new ShowAdapter(Theatre.getInstance().getShows().get(i));
			listofshows.add(sh);
		}
		return listofshows;
//		return Response.ok(listofshows).build();
	}
	
	public static SectionAdapter[] viewSections(String wid) {
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				SectionAdapter[] saa = new SectionAdapter[show.getSeating_info().length];
				for (int j = 0; j < saa.length; j++){
					saa[j] = new SectionPriceAdapter(show.getSeating_info()[j]);
				}
				return saa;
//				return Response.ok(saa).build();
			}

		}
		return null;
	}
	
	public static ShowSectionAdapter viewSpecificSection (String wid, String sid) {
		for (Show show : Theatre.getInstance().getShows()){
			if (show.getWid().equals(wid)){
				ShowSectionAdapter ssa = new ShowSectionAdapter(show, sid);
				if (ssa.getSeating() == null){
					return null;
				}
				return ssa;
			}
		}
		return null;
	}
	
	public static Donation requestDonations(String wid, int count, Patron patron_info, String wid_from_object) {
		for (Show show : Theatre.getInstance().getShows()) {
			if (show.getWid().equals(wid) && wid.equals(wid_from_object)) {
				Donation d = new Donation(count, show, patron_info);
				Theatre.getInstance().add(d);
				return d;
			}
		}
		return null;
	}
	
	public static Donation getDonation(String wid, String did) {
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
				
				return d;
			}
		}
		return null;
	}
	
	public Section findSectionBySid(String sid) {
		for(Section section: this.seating_info) {
			if(section.getSid().equals(sid))
				return section;
		}
		return null;
	}
	public SeatRequestAdapter requestSeats(String sid,int count, String cid) {
		Section section = findSectionBySid(sid);
		Row rowRE = null;
		int rowIndex = 0;
		int seatIndex = 0;
		String StartingCid="";
		if(!cid.equals("")) {
			for (int r =0 ;r< section.getRows().length;r++){
				for (int s =0 ;s< section.getRows()[r].getSeats().length;s++){
					if (section.getRows()[r].getSeats()[s].getCid().equals(cid)){
						rowIndex =r;
						seatIndex = s;
						StartingCid = section.getRows()[r].getSeats()[s].getCid();
					}
				}
			}
		}
		rowRE = section.reqNewSeats(count, rowIndex, seatIndex);
		RowAvailAdapter raa = null;
		if (rowRE != null){
			raa = new RowAvailAdapter(rowRE);
		}
		SeatRequestAdapter sra = new SeatRequestAdapter(this, section,StartingCid, raa, count);
		return sra;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String id) {
		this.wid = id;
	}
	public LocalTime getTime() {
		return show_info.getTime();
	}
	public void setTime(LocalTime time) {
		this.show_info.setTime(time);
	}
	public LocalDate getDate() {
		return show_info.getDate();
	}
	public void setDate(LocalDate date) {
		this.show_info.setDate(date);
	}
	public Section[] getSeating_info() {
		return seating_info;
	}
	public void setSeating_info(Section[] theatre) {
		this.seating_info = theatre;
	}
	public String getName() {
		return show_info.getName();
	}
	public void setName(String name) {
		this.show_info.setName(name);
	}
	
	public String getWeb() {
		return show_info.getWeb();
	}
	public void setWeb(String name) {
		this.show_info.setWeb(name);
	}
	
	public ShowData getShow_info() {
		return show_info;
	}
	public void setShow_info(ShowData show_info) {
		this.show_info = show_info;
	}


	@Override
	public String toString() {
		return "Show [wid=" + wid + ", seating_info=" + Arrays.toString(seating_info) + ", show_info=" + show_info
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((show_info.getDate() == null) ? 0 : show_info.getDate().hashCode());
		result = prime * result + ((show_info.getName() == null) ? 0 : show_info.getName().hashCode());
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
		result = prime * result + ((seating_info == null) ? 0 : seating_info.hashCode());
		result = prime * result + ((show_info.getTime() == null) ? 0 : show_info.getTime().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		if (show_info.getDate() == null) {
			if (other.show_info.getDate() != null)
				return false;
		} else if (!show_info.getDate().equals(other.show_info.getDate()))
			return false;
		if (show_info.getName() == null) {
			if (other.show_info.getName() != null)
				return false;
		} else if (!show_info.getName().equals(other.show_info.getName()))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		if (seating_info == null) {
			if (other.seating_info != null)
				return false;
		} else if (!seating_info.equals(other.seating_info))
			return false;
		if (show_info.getTime() == null) {
			if (other.show_info.getTime() != null)
				return false;
		} else if (!show_info.getTime().equals(other.show_info.getTime()))
			return false;
		return true;
	}
	
	public Show search(String key){
		if (wid.equals(key)){
			return this;
		}
		if (show_info.getName().equals(key)){
			return this;
		}
		if (show_info.getWeb().equals(key)){
			return this;
			
		}
		if (show_info.getTime().toString().equals(key)){
			return this;
		}
		if (show_info.getDate().toString().equals(key)){
			return this;
		}
		for (int i = 0; i < seating_info.length; i++){
			if (seating_info[i].getSection_name().equals(key)){
				return this;
			}
			if (String.valueOf(seating_info[i].getPrice()).equals(key)){
				return this;
			}
			if (seating_info[i].getSid().equals(key)){
				return this;
			}
			for (int j = 0; j < seating_info[i].getRows().length; j++){
				if (String.valueOf(seating_info[i].getRows()[j].getRowId()).equals(key)){
					return this;
				}
				
				for (int k = 0; k < seating_info[i].getRows()[j].getSeats().length; k++){
					if (String.valueOf(seating_info[i].getRows()[j].getSeats()[k].getCid()).equals(key)){
						return this;
					}
				}
			}
		}

		return null;
	}
	

}