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
		
		when(mockD1_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD2_.getValue()).thenReturn(DiceValue.CROWN);
		when(mockD3_.getValue()).thenReturn(DiceValue.DIAMOND);
		
		game_ = new Game(mockD1_, mockD2_, mockD3_);
		
		fail("Not yet implemented");
	}
	
	@Test    //testing to see if player recieves correct money for 2 card match
	public void testTwoCardMatch() {
		
		when(mockD1_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD2_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD3_.getValue()).thenReturn(DiceValue.DIAMOND);
		
		game_ = new Game(mockD1_, mockD2_, mockD3_);
		
		fail("Not yet implemented");
	}
	
	@Test    //testing to see if player recieves correct money for 3 card match
	public void testThreeCardMatch() {
		
		when(mockD1_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD2_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD3_.getValue()).thenReturn(DiceValue.SPADE);
		
		game_ = new Game(mockD1_, mockD2_, mockD3_);
		
		fail("Not yet implemented");
	}
	

}
