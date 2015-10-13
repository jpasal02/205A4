import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BugTwoTest {
	
	private static Player player_;

	@Before
	public void setUp() throws Exception {
		player_ = new Player("Robbert", 20);
		player_.setLimit(0);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
