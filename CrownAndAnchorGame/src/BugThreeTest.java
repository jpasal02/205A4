import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;


public class BugThreeTest {

	private static Game game_; 
	private static Player player_; 
	private static Dice mockD1_, mockD2_, mockD3_;

	@Before
	public void setUp() throws Exception {
		
		player_ = new Player("Robbert", 20);
		int winnings = 5;
		player_.setLimit(0);
		
		mockD1_ =  mock(Dice.class);
		mockD2_ = mock(Dice.class);
		mockD3_ = mock(Dice.class);
		
		
	}

	@Test
	public void test() {
		int bet = 5;
		int winCount = 1; 
		int loseCount = 1;
		DiceValue pick = DiceValue.getRandom();
		game_ = new Game(mockD1_, mockD2_, mockD3_);
		
		player_.takeBet(5);
		
		int winnings_ = game_.playRound(player_, pick, bet);
		
		if (winnings_ > 0){
			winCount++;
		}
		else
		{
			loseCount++;
		}
		
		float ratio = winCount/(winCount + loseCount);
		System.out.println(winCount + loseCount + ratio);
		assertTrue(ratio > 0.30 && ratio < 0.50);
		
	}

}
