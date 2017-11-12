package testing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


//Sets the path to base URL + /test
@Path("/test")
public class Test {

//	 // This method is called if TEXT_PLAIN is request
//	 @GET
//	 @Produces(MediaType.TEXT_PLAIN)
//	 public String sayPlainTextHello() {
//		 return "Hello Jerseys - plain text\n";
//	 }
//	 // This method is called if HTML is request
//	 @GET
//	 @Produces(MediaType.TEXT_HTML)
//	 public String sayHtmlHello() {
//		 return "<html> " + "<title>" + "Hello Jersey" + "</title>"
//		+ "<body><h1>" + "Hello Jersey - html" + "</body></h1>" + "</html> \n";
//	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public testVals[] getStringAsJSON(@Context HttpHeaders httpHeaders){
		 testVals tv = new testVals();
		 testVals[] tva = {tv, tv, tv};
		 return tva;
	 }	
}