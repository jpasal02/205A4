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
		
		
		System.out.println("");
		System.out.println("TEST1 - one card match");
		
		System.out.println("Players balance is: " + player_.getBalance());
		DiceValue pick = DiceValue.SPADE;
		int bet = 5; 
		int winnings = game_.playRound(player_, pick, bet);
		
		System.out.println("The player is: " + player_.getName());
	    System.out.println("The bet amount is: " + bet);
	    System.out.println("The player picked: " + pick);
	   
	    System.out.println("Dice values are: " + game_.getDiceValues());
	    System.out.println("Player wins " + winnings);
	    System.out.println("The players balance is: " + player_.getBalance());
		
		assertEquals(5, winnings);
		
		/** This assert fails (now) but worked when the code was wrong*/	
		//assertEquals(0, winnings); 
		
		
	}
	
	@Test    //testing to see if player recieves correct money for 2 card match
	public void testTwoCardMatch() {
		
		when(mockD1_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD2_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD3_.getValue()).thenReturn(DiceValue.DIAMOND);
		
		game_ = new Game(mockD1_, mockD2_, mockD3_);
		
		System.out.println("");
		System.out.println("TEST2 - two card match");
		
		System.out.println("Players balance is: " + player_.getBalance());
		DiceValue pick = DiceValue.SPADE;
		int bet = 5; 
		int winnings = game_.playRound(player_, pick, bet);
		
		System.out.println("The player is: " + player_.getName());
	    System.out.println("The bet amount is: " + bet);
	    System.out.println("The player picked: " + pick);
	   
	    System.out.println("Dice values are: " + game_.getDiceValues());
	    System.out.println("Player wins " + winnings);
	    System.out.println("The players balance is: " + player_.getBalance());
		
		assertEquals(10, winnings);
		
		/** This assert fails (now) but worked when the code was wrong*/	
		//assertEquals(5, winnings); 
		
	}
	
	@Test    //testing to see if player recieves correct money for 3 card match
	public void testThreeCardMatch() {
		
		when(mockD1_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD2_.getValue()).thenReturn(DiceValue.SPADE);
		when(mockD3_.getValue()).thenReturn(DiceValue.SPADE);
		
		game_ = new Game(mockD1_, mockD2_, mockD3_);
		
		System.out.println("");
		System.out.println("TEST3 - three card match");
		System.out.println("Players balance is: " + player_.getBalance());
		DiceValue pick = DiceValue.SPADE;
		int bet = 5; 
		int winnings = game_.playRound(player_, pick, bet);
		
		System.out.println("The player is: " + player_.getName());
	    System.out.println("The bet amount is: " + bet);
	    System.out.println("The player picked: " + pick);
	   
	    System.out.println("Dice values are: " + game_.getDiceValues());
	    System.out.println("Player wins " + winnings);
	    System.out.println("The players balance is: " + player_.getBalance());
		
		assertEquals(15, winnings);
		
		/** This assert fails (now) but worked when the code was wrong*/	
		//assertEquals(10, winnings); 
	}
	

}
