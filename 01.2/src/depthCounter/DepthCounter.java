package depthCounter;

import java.util.List;

/**
 * Class to count increases in depth.
 * @author Laura Luijben
 *
 */
public class DepthCounter {
	
	/**
	 * Count depth increases by comparing two subsequent pairs of three values.
	 * @param data	The recorded depths.
	 * @return		The number of depth increases.
	 */
	public static int countDepthIncreasesPerThreeRecords(List<Integer> data) {
		int counter = 0;
		for (int i = 0; i < data.size() - 3; i++) {
			int sum1 = data.get(i) + data.get(i + 1) + data.get(i + 2);
			int sum2 = data.get(i + 1) + data.get(i + 2) + data.get(i + 3);
			if (sum1 < sum2) {
				counter++;
			}
		}
		return counter;
	}
}
