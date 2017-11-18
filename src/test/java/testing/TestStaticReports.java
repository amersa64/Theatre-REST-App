package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import reporting.adapters.TheatreAdapter;

public class TestStaticReports {

	@Test
	public void test() {
		assertEquals(TheatreAdapter.staticReports()[0].getMrid(), "801");
		assertEquals(TheatreAdapter.staticReports()[1].getMrid(), "802");
	}

}
