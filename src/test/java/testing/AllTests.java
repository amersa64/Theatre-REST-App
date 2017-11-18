package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFindSeatByCid.class, TestViewOrdersBetweenDates.class,
		TestViewShowBetweenDates.class, TestFindTicketByCid.class })
public class AllTests {

}
