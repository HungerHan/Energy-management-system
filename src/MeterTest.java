import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class MeterTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testMeterRead() {
		assertEquals("12345,2018.4.30,40,2000,80,1900",new Meter().meterRead("12345","2018","April"));
		//fail("Not yet implemented");
	}

}
