package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestSeatRequest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String cc_number = "1234567890987654";
		String oldChar = cc_number.substring(0, cc_number.length()-4);
		String res = cc_number.replace(oldChar, "xxxxxxxxxxxx");
		String correct = "xxxxxxxxxxxx7654";
		System.out.println(cc_number);
		System.out.println(res);
		assertTrue(correct.equals(res));
	}

}
