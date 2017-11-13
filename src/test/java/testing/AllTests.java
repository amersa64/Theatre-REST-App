package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFindSeatByCid.class, TestContigiousSeatRequest.class, TestViewOrdersBetweenDates.class,
		TestViewShowBetweenDates.class,TestDonation.class, TestFindTicketByCid.class })
public class AllTests {

}
