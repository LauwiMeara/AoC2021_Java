package depthCounter;

import java.util.List;

/**
 * Class to count increases in depth.
 * @author Laura Luijben
 *
 */
public class DepthCounter {
	
	/**
	 * Count depth increases by comparing two subsequent values.
	 * @param data	The recorded depths.
	 * @return		The number of depth increases.
	 */
	public static int countDepthIncreases(List<Integer> data) {
		int counter = 0;
		for (int i = 0; i < data.size() - 1; i++) {
			if (data.get(i) < data.get(i + 1)) {
				counter++;
			}
		}
		return counter;
	}
}
