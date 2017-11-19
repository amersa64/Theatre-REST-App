package testing;

import static org.junit.Assert.*;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import adapters.SectionAdapter;
import adapters.ShowSectionAdapter;
import mics.Randomizer;
import mics.StaticSectionSetup;
import seating.Section;
import thalia.Donation;
import thalia.Patron;
import thalia.Show;
import thalia.Theatre;

public class TestShow {

	@SuppressWarnings("unchecked")
	@Test
	public void testCreateShow() {
		Theatre.restart();
//		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[6];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		theatre1[1] = StaticSectionSetup.section_setup.get("Front center");
		theatre1[2] = StaticSectionSetup.section_setup.get("Front left");
		theatre1[3] = StaticSectionSetup.section_setup.get("Main right");
		theatre1[4] = StaticSectionSetup.section_setup.get("Main center");
		theatre1[5] = StaticSectionSetup.section_setup.get("Main left");
		JSONObject jsonObj1 = new JSONObject();
		JSONObject jsonObj2 = new JSONObject();
		JSONObject jsonObj3 = new JSONObject();
		JSONObject jsonObj4 = new JSONObject();
		JSONObject jsonObj5 = new JSONObject();
		JSONObject jsonObj6 = new JSONObject();

		jsonObj1.put("sid", "123");
		jsonObj1.put("price", 600);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObj1);
		
		jsonObj2.put("sid", "124");
		jsonObj2.put("price", 60);
		jsonArray.add(jsonObj2);

		jsonObj3.put("sid", "125");
		jsonObj3.put("price", 600);
		jsonArray.add(jsonObj1);
		
		jsonObj4.put("sid", "126");
		jsonObj4.put("price", 60);
		jsonArray.add(jsonObj2);

		jsonObj5.put("sid", "127");
		jsonObj5.put("price", 600);
		jsonArray.add(jsonObj1);
		
		jsonObj6.put("sid", "128");
		jsonObj6.put("price", 60);
		jsonArray.add(jsonObj2);
		
		Show sh = Show.createShow(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com", jsonArray);
		
		assertEquals(sh.getWid(), "0");
		assertEquals(sh.getSeating_info().length, 6);
	}
		
	@Test
	public void testUpdateShow() throws ParseException{
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		
		String json = "    {\n" + 
				"    	\"show_info\": {\n" + 
				"    		\"name\": \"King Lear\",\n" + 
				"    		\"web\": \"http://www.example.com/shows/king-lear\",\n" + 
				"    		\"date\": \"2017-12-05\",\n" + 
				"    		\"time\": \"13:00\"\n" + 
				"    	},\n" + 
				"    	\"seating_info\": [{\n" + 
				"    			\"sid\": \"123\",\n" + 
				"    			\"price\": 60\n" + 
				"    		}\n" + 
				"    	]\n" + 
				"    }";
		
		boolean isUpdated = Show.updateShow("0", json);
		assertEquals(isUpdated, true);
		
		isUpdated = Show.updateShow("1", json);
		assertEquals(isUpdated, false);
		
		json = "    {\n" + 
				"    	\"show_info\": {\n" + 
				"    		\"name\": \"King Lear\",\n" + 
				"    		\"web\": \"http://www.example.com/shows/king-lear\",\n" + 
				"    		\"date\": \"2017-12-05\",\n" + 
				"    		\"time\": \"13:00\"\n" + 
				"    	},\n" + 
				"    	\"seating_info\": [{\n" + 
				"    			\"sid\": \"124\",\n" + 
				"    			\"price\": 60\n" + 
				"    		}\n" + 
				"    	]\n" + 
				"    }";
		
		isUpdated = Show.updateShow("0", json);
		assertEquals(thalia.getShows().get(0).getSeating_info()[0].getSid(), "124");
	}
	
	@Test
	public void testViewShow() throws ParseException{
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		Show show1 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKong", "www.movie.com");
		thalia.add(show1);
		
		Show o1 = Show.viewShow(show0.getWid());
		assertEquals(o1, show0);

		o1 = thalia.searchShowId("0");
		assertEquals(o1, show0);
		
		Show o2 = Show.viewShow(show1.getWid());
		assertEquals(o2, show1);
		
		Show o3 = Show.viewShow("2");
		assertNull(o3);
	}
	
	@Test
	public void testViewSections(){
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Section[] theatre2 = new Section[1];
		theatre2[0] = StaticSectionSetup.section_setup.get("Front center");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		Show show1 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre2, "MartinLutherKong", "www.movie.com");
		thalia.add(show1);
		
		SectionAdapter[] saa1 = Show.viewSections(show0.getWid());
		SectionAdapter[] saa2 = Show.viewSections(show1.getWid());
		SectionAdapter[] saa3 = Show.viewSections("3");
		
		assertEquals(saa1.length, 1);
		assertEquals(saa2.length, 1);

		assertEquals(saa1[0].getSid(), "123");
		assertEquals(saa2[0].getSid(), "124");
		
		assertNull(saa3);
	}
	
	@Test
	public void testViewSpecificSections(){
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		
		ShowSectionAdapter ssa = Show.viewSpecificSection(show0.getWid(), "123");
		assertEquals(ssa.getSid(), "123");
		
		ssa = Show.viewSpecificSection("1", "123");
		assertNull(ssa);
		
		ssa = Show.viewSpecificSection("0", "124");
		assertNull(ssa);

	}
	
	@Test
	public void testDonations(){
		Theatre.restart();
		Theatre thalia = Theatre.getInstance();
		Section[] theatre1 = new Section[1];
		StaticSectionSetup.random=true;
		StaticSectionSetup.resetIDGenerators();
		StaticSectionSetup._init();
		theatre1[0] = StaticSectionSetup.section_setup.get("Front right");
		Show show0 = new Show(Randomizer.randomTime(), Randomizer.randomDate(), theatre1, "MartinLutherKing", "www.movie.com");
		thalia.add(show0);
		int count = 2;
		Patron p1 = new Patron("Jack", "jack@gmail.com", "8593658871", "address @ chicago", "123456789012345", "01/22");
		
		Donation d = Show.requestDonations(show0.getWid(), count, p1, "0");
		Donation getD1 = Show.getDonation(show0.getWid(), d.getDid());
		Donation getD2 = Show.getDonation(show0.getWid(), "1");
		Donation getD3 = Show.getDonation("1", "0");
		assertNotNull(d);
		assertNotNull(getD1);
		assertNull(getD2);
		assertNull(getD3);
		
		Donation d2 = Show.requestDonations(show0.getWid(), count, p1, "1");
		
		assertNull(d2);
		
		Donation d3 = Show.requestDonations("1", count, p1, "0");
		
		assertNull(d3);
		
	}



}
