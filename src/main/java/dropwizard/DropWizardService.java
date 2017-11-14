package dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import config.ExampleServiceConfiguration;
import edu.iit.cs445.thalia.OrdersAPI;
//import eu.sayasavanh.hello.HelloResource;
//import eu.sayasavanh.hello.testclass;
import edu.iit.cs445.thalia.ReportsAPI;
import edu.iit.cs445.thalia.SearchAPI;
import edu.iit.cs445.thalia.SeatingAPI;
import edu.iit.cs445.thalia.ShowsAPI;
import edu.iit.cs445.thalia.TicketsAPI;
import mics.StaticSectionSetup;

public class DropWizardService extends Service<ExampleServiceConfiguration>{
	
	public static void main(String[]args) throws Exception {
		new DropWizardService().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<ExampleServiceConfiguration> bootstrap) {
		bootstrap.setName("dropwizard-example");
	}
	
	@Override
	public void run(ExampleServiceConfiguration conf, Environment env) throws Exception {
//		env.addResource(new HelloResource(conf.getMessages()));
//		env.addResource(new testclass());
		env.addResource(new ReportsAPI());
		env.addResource(new OrdersAPI());
		env.addResource(new SearchAPI());
		env.addResource(new SeatingAPI());
		env.addResource(new ShowsAPI());
		env.addResource(new TicketsAPI());
		env.addResource(new StaticSectionSetup());
	}
}
