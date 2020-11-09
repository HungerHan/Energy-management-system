import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class ViewTarrifTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testCheckTarrif() {
		assertEquals("<html><p>The electricity price is 10.00 pound/kWh.</p><p>The gas price is 10.00 pound/kWh.</p></html>"
				,new ViewTarrif().checkTarrif());
		//fail("Not yet implemented");
	}

}
