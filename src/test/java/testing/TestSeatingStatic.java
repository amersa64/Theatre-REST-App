package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import adapters.SectionNumberAdapter;
import mics.StaticSectionSetup;

public class TestSeatingStatic {

	@Test
	public void test() {
		StaticSectionSetup._init();//
		StaticSectionSetup.revertCid();
		SectionNumberAdapter sna;
		String section_name = StaticSectionSetup.sid_section_name_setup.get("123");
		sna = new SectionNumberAdapter(StaticSectionSetup.section_setup.get(section_name));
		assertEquals(sna.getSection_name(),"Front right");
	}
	@Test
	public void testNull() {
		StaticSectionSetup._init();//
		StaticSectionSetup.revertCid();
		String section_name = StaticSectionSetup.sid_section_name_setup.get("500");
		assertNull(section_name);
	}

}
