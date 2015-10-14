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
	public void testGameStopsAtLimit() {
		int bet = 5;
		
		player_ = new Player("Joe", 5); //Does not exceed limit 
		System.out.println("player: " + player_.getName());
		System.out.println("Balance: " + player_.getBalance());
		System.out.println("Balance < limit " + player_.balanceExceedsLimitBy(bet));
		
		assertEquals(player_.balanceExceedsLimitBy(bet), true);
		
		player_ = new Player("Joe", 10); //Does not exceed limit
		System.out.println("player: " + player_.getName());
		System.out.println("Balance: " + player_.getBalance());
		System.out.println("Balance < limit " + player_.balanceExceedsLimitBy(bet));
		equals(player_.balanceExceedsLimitBy(bet));
		
		assertEquals(player_.balanceExceedsLimitBy(bet), true);
		
		player_ = new Player("Joe", 15); //Does not exceed limit 
		System.out.println("player: " + player_.getName());
		System.out.println("Balance: " + player_.getBalance());
		System.out.println("Balance < limit " + player_.balanceExceedsLimitBy(bet));
		equals(player_.balanceExceedsLimitBy(bet));
		
		assertEquals(player_.balanceExceedsLimitBy(bet), true);
		
		player_ = new Player("Joe", 0);  // exceeds limit 
		System.out.println("player: " + player_.getName());
		System.out.println("Balance: " + player_.getBalance());
		System.out.println("Balance < limit " + player_.balanceExceedsLimitBy(bet));
		
		assertEquals(player_.balanceExceedsLimitBy(bet), false);
		
	}

}
