import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


public class BugThreeTest extends TestCase {

	private static Game game_; 
	private static Player player_; 
	private static Dice mockD1_, mockD2_, mockD3_;

	@Before
	public void setUp() throws Exception {

		player_ = new Player("Robbert", 20);
		player_.setLimit(0);



	}

	@Test
	public void testRatioWinLose() {
		//		int bet = 5;
		//		int winCount = 0; 
		//		int loseCount = 0;
		//		//DiceValue pick = DiceValue.getRandom();
		//
		//		when(mockD1_.getValue()).thenReturn(DiceValue.getRandom());
		//		when(mockD2_.getValue()).thenReturn(DiceValue.getRandom());
		//		when(mockD3_.getValue()).thenReturn(DiceValue.getRandom());
		//		
		//		
		//		DiceValue pick = DiceValue.getRandom();
		//		game_ = new Game(mockD1_, mockD2_, mockD3_);
		//		
		//		player_.takeBet(5);
		//		
		//		int winnings_ = game_.playRound(player_, pick, bet);
		//		
		//		if (winnings_ > 0){
		//			winCount++;
		//		}
		//		else
		//		{
		//			loseCount++;
		//		}
		//		
		//		int gamesPlayed = 100;
		//		
		//		float ratio = (winCount * 100) / (winCount + loseCount);
		//		System.out.println("WINS:	" + winCount +" LOSE: " +loseCount + "	 RATIO:		"+ ratio);
		//		
		//		assertTrue(ratio > 0.30 && ratio < 0.50);
		//		
		//	}
		//
		//}
		//		mockD1_ =  mock(Dice.class);
		//		mockD2_ = mock(Dice.class);
		//		mockD3_ = mock(Dice.class);
		//		
		//		mockD1_.roll();
		//		mockD2_.roll();
		//		mockD3_.roll();
		//		
		//		when(mockD1_.getValue()).thenReturn(DiceValue.getRandom());
		//		when(mockD2_.getValue()).thenReturn(DiceValue.getRandom());
		//		when(mockD3_.getValue()).thenReturn(DiceValue.getRandom());

		Dice d1 = new Dice();
		Dice d2 = new Dice();
		Dice d3 = new Dice();


		//List<DiceValue> cdv = game_.getDiceValues();
		game_ = new Game(d1, d2, d3);
		DiceValue pick = DiceValue.getRandom();
		List<DiceValue> cdv = game_.getDiceValues();



		int totalWins = 0;
		int totalLosses = 0;

		int winCount = 0;
		int loseCount = 0;

		for (int i = 0; i < 100; i++)



		{

			Player player = new Player("Fred", 100);
			player.setLimit(0);
			int bet = 5;


			System.out.println(String.format("Start Game %d: ", i));
			System.out.println(String.format("%s starts with balance %d, limit %d", 
					player.getName(), player.getBalance(), player.getLimit()));

			int turn = 0;
			while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
			{
				turn++;                    
				pick = DiceValue.getRandom();

				System.out.printf("Turn %d: %s bet %d on %s\n",
						turn, player.getName(), bet, pick); 

				int winnings = game_.playRound(player, pick, bet);
				cdv = game_.getDiceValues();

				System.out.printf("Rolled %s, %s, %s\n",
						cdv.get(0), cdv.get(1), cdv.get(2));


				if (winnings > 0) {
					System.out.printf("%s won %d, balance now %d\n\n",
							player.getName(), winnings, player.getBalance());
					winCount++; 
				}
				else {
					System.out.printf("%s lost, balance now %d\n\n",
							player.getName(), player.getBalance());
					loseCount++;
				}

			} //while

			System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
			System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));

		} //for

		System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
		totalWins += winCount;
		totalLosses += loseCount;

		float ratio = (float) winCount/(winCount+loseCount);
		System.out.println("WINS:	" + winCount +" LOSE: " +loseCount + "	 RATIO:		"+ ratio);
		assertTrue(ratio > 0.40);
		assertTrue(ratio < 0.45);


	}

}
