package fishRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to register timers of fish.
 * @author Laura Luijben
 *
 */
public class FishRegister {
	private final int MAX_TIMER = 8;
	private final int TIMER_RESET_FISH = 6;
	private final int TIMER_NEW_FISH = 8;
	private Map<Integer, Long> fishPerTimer = new HashMap<>();
	
	/**
	 * Creates a fish register with the timers of all initial fish.
	 * @param data	The timers of the initial fish.
	 */
	public FishRegister(String[] data) {
		// Ensure that all timers are available in the map
		for (int i = 0; i <= MAX_TIMER; i++) {
			fishPerTimer.put(i, (long)0);
		}
		
		// Register the timers of the initial fish
		for (String fishTimer : data) {
			int t = Integer.parseInt(fishTimer);
			fishPerTimer.put(t, fishPerTimer.get(t) + 1);
		}
	}
	
	/**
	 * Subtracts one from each timer. If the fish had timer 0, the timer is reser to TIMER_RESET_FISH and new fish are created at TIMER_NEW_FISH.
	 */
	public void registerFishReproduction() {
		// Save the number of fish with timer 0
		long numFishWithTimer0 = fishPerTimer.get(0);
		
		// Subtract one from all other timers
		for (int i = 1; i <= MAX_TIMER; i++) {
			long numFish = fishPerTimer.get(i);
			fishPerTimer.put(i - 1, numFish);
		}
		
		// Register the timers of the new fish
		fishPerTimer.put(TIMER_RESET_FISH, fishPerTimer.get(TIMER_RESET_FISH) + numFishWithTimer0);
		fishPerTimer.put(TIMER_NEW_FISH, numFishWithTimer0);
	}
	
	/**
	 * Counts the total number of fish.
	 * @return	Total number of fish.
	 */
	public long getNumberOfFish() {
		long sum = 0;
		for (int i = 0; i <= MAX_TIMER; i++) {
			sum += fishPerTimer.get(i);
		}
		return sum;
	}
}
