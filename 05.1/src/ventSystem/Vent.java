package ventSystem;

import java.util.ArrayList;
import utils.Pair;

/**
 * Class to register all coords of a vent.
 * @author Laura Luijben
 *
 */
public class Vent {
	private ArrayList<Pair> coords = new ArrayList<>();
	
	/**
	 * Creates a vent. In other words: registers all the coords of a vent in a list.
	 * @param x1	The first x value.
	 * @param y1	The first y value.
	 * @param x2	The second x value.
	 * @param y2	The second y value.
	 * Condition: the vent must be horizontal or vertical.
	 */
	public Vent(int x1, int y1, int x2, int y2) {
		
		// Horizontal vent
		if (x1 == x2) {
			int[] minMax = getMinMax(y2, y1);
			for (int y = minMax[0]; y <= minMax[1]; y++) {
				coords.add(new Pair(x1, y));
			}
		}
		
		// Vertical vent
		else if (y1 == y2) {
			int[] minMax = getMinMax(x1, x2);
			for (int x = minMax[0]; x <= minMax[1]; x++) {
				coords.add(new Pair (x, y1));
			}
		}
	}
	
	/**
	 * Sorts two values from min to max.
	 * @param firstValue	The first value to sort.
	 * @param secondValue	The second value to sort.
	 * @return				An array with the sorted values.
	 */
	private int[] getMinMax(int firstValue, int secondValue) {
		int min = 0;
		int max = 0;
		if (firstValue < secondValue) {
			min = firstValue;
			max = secondValue;
		} else {
			min = secondValue;
			max = firstValue;
		}
		return new int[] {min, max};
	}
	
	public ArrayList<Pair> getCoords() {
		return coords;
	}
}
