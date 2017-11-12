//package testing;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import seating.*;
//
//public class StaticSectionSetup {
//	public static HashMap<String,Section> section_setup;
//	public static boolean random=false;
//	public static synchronized void _init(){
//		JSONParser parser = new JSONParser();
//		section_setup = new HashMap<>();
//        try {     
////            Object obj = parser.parse(new FileReader("C:\\Users\\Amer\\Documents\\Java-Eclipse\\edu.iit.cs445.thalia\\src\\project-test-theatre-seating.json"));
//            Object obj = parser.parse(new FileReader("C:\\Users\\Alrick\\workspace\\edu.iit.cs445.thalia\\src\\project-test-theatre-seating.json"));
//            JSONArray arrayJSON =  (JSONArray) obj;
//            for(int i=0; i <arrayJSON.size();i++){
//            	JSONObject section = (JSONObject) arrayJSON.get(i);
//                String section_name = (String) section.get("section_name");
//                JSONArray seating = (JSONArray) section.get("seating");
//                Row[] rowsArray = new Row[seating.size()];
//                for(int j=0; j<seating.size();j++){
//                	JSONObject row = (JSONObject) seating.get(j);
//                	String row_number =  row.get("row").toString();
//                	JSONArray seats = (JSONArray) row.get("seats");
//                	String[] seatsArray = new String[seats.size()];
//                	for(int x=0; x<seats.size(); x++){
//                		seatsArray[x] = seats.get(x).toString();
//                	}
//                	Row newRow = new Row(seatsArray,row_number);
//                	rowsArray[j]= newRow;
//                }
//                double price;
//                if(random)
//                	price = Math.random()*100;
//                else 
//                	price =0;
//                Section s = new Section(section_name,price,rowsArray);
////                System.out.println(s.toString());
//                section_setup.put(s.getSection_name(), s);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//		
//}
