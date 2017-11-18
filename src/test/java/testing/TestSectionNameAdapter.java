package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import adapters.SectionNameAdapter;

public class TestSectionNameAdapter {

	@Test
	public void test() {
		SectionNameAdapter[] snas = SectionNameAdapter.defaultSectionsSetup();
		assertEquals(snas[0].getSid(),"123");
		assertEquals(snas[0].getSection_name(),"Front right");
		assertEquals(snas[5].getSid(),"128");
		assertEquals(snas[5].getSection_name(),"Main left");
	}

}
