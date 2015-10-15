
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


public class BugThreeTest extends TestCase {

	private static Game game_; 
	private static Player player_; 

	@Before
	public void setUp() throws Exception {

		player_ = new Player("Robbert", 20);
		player_.setLimit(0);

	}

	@Test
	public void testRatioWinLose() {

		Dice d1 = new Dice();
		Dice d2 = new Dice();
		Dice d3 = new Dice();

		game_ = new Game(d1, d2, d3);
		DiceValue pick = DiceValue.getRandom();
		List<DiceValue> cdv = game_.getDiceValues();
		
		boolean wasSpadePicked = false;
		boolean wasSpadeRolled = false; 

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
				
				/**
				 * This line was commented out to see if asserttrue pick spade 
 				   fail (line sets pick to anchor so assert fails) Test. 
				 */
				//pick = DiceValue.ANCHOR;
				
				
				if(!wasSpadePicked) {
					wasSpadePicked = pick == DiceValue.SPADE;
				}

				System.out.printf("Turn %d: %s bet %d on %s\n",
						turn, player.getName(), bet, pick); 

				int winnings = game_.playRound(player, pick, bet);
				cdv = game_.getDiceValues();
				
				/** This line is to test the roll of spade fail (commented out so it passes) */
			//	cdv = new ArrayList<DiceValue>(Arrays.asList(new DiceValue[]{DiceValue.ANCHOR, DiceValue.ANCHOR, DiceValue.ANCHOR}));
				
				if(!wasSpadeRolled) {
					wasSpadeRolled = (cdv.get(0) == DiceValue.SPADE) || (cdv.get(1) == DiceValue.SPADE) || (cdv.get(2) == DiceValue.SPADE);
				}

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
		System.out.println("was spade picked atleast once: " + wasSpadePicked);
		System.out.println("was spade rolled atleast once: " + wasSpadeRolled);
		assertTrue(wasSpadePicked);
		assertTrue(wasSpadeRolled);
		
		
		
		/** This assert fails (now) but worked when the code was wrong*/
		// assertTrue(ratio > 50);


	}

}
