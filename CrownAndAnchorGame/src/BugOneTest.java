import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BugOneTest {
	
	private static Game game_; 
	private static Player player_; 
	private static Dice mockD1_, mockD2_, mockD3_; 

	@Before
	public void setUp() throws Exception {
		
		mockD1_ =  mock(Dice.class);
		mockD2_ = mock(Dice.class);
		mockD3_ = mock(Dice.class);
		
		player_ = new Player ("Robbert", 20);
	}

	@Test     //testing to see if player recieves correct money for 1 card match
	public void testOneCardMatch() {
		
		fail("Not yet implemented");
	}
	
	@Test    //testing to see if player recieves correct money for 2 card match
	public void testTwoCardMatch() {
		
		fail("Not yet implemented");
	}
	
	@Test    //testing to see if player recieves correct money for 3 card match
	public void testThreeCardMatch() {
		
		fail("Not yet implemented");
	}
	

}
