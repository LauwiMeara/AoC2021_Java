package crabSwarm;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to move a crab swarm.
 * @author Laura Luijben
 *
 */
public class CrabSwarm {
	private Map <Integer, Integer> crabsPerPosition = new HashMap<>();
	
	public CrabSwarm(String[] data) {
		for (String crab : data) {
			int position = Integer.parseInt(crab);
			if (crabsPerPosition.containsKey(position)) {
				crabsPerPosition.put(position, crabsPerPosition.get(position) + 1);
			} else {
				crabsPerPosition.put(position, 1);
			}
		}
	}
	
	/**
	 * Calculates the minimum amount of fuel needed to align all crabs.
	 * @return	The minimum amount of fuel.
	 */
	public long calculateMinFuel() {
		long minFuel = calculateFuelForSwarm(0);
		for (int position : crabsPerPosition.keySet()) {
			long fuel = calculateFuelForSwarm(position);
			minFuel = minFuel < fuel ? minFuel : fuel;
		}
		return minFuel;
	}
	
	/**
	 * Calculates the amount of fuel needed to align all crabs at a certain position.
	 * @param alignedPosition	The position all crabs need to align to.
	 * @return					The amount of fuel that is needed for the alignment for the entire swarm.
	 */
	private long calculateFuelForSwarm(int alignedPosition) {
		long totalFuel = 0;
		for (int position : crabsPerPosition.keySet()) {
			int numberOfCrabs = crabsPerPosition.get(position);
			int diffPosition = Math.abs(alignedPosition - position);
			long fuel = calculateFuelForCrab(diffPosition);
			totalFuel += (numberOfCrabs * fuel);
		}
		return totalFuel;
	}
	
	/**
	 * Calculates the amount of fuel needed to align a subswarm of crabs at a certain distance from the aligned position.
	 * @param diffPosition	The distance between the crabs and the position they need to align to.
	 * @return				The amount of fuel that is needed for the alignment of the subswarm.
	 */
	private long calculateFuelForCrab(long diffPosition) {
		if (diffPosition == 0) {
			return diffPosition;
		} else {
			return diffPosition + calculateFuelForCrab(diffPosition - 1);
		}
	}
	
	public Map<Integer, Integer> getCrabPositions() {
		return crabsPerPosition;
	}
}
