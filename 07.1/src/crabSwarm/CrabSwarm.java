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
		long minFuel = calculateFuel(0);
		for (int position : crabsPerPosition.keySet()) {
			long fuel = calculateFuel(position);
			minFuel = minFuel < fuel ? minFuel : fuel;
		}
		return minFuel;
	}
	
	/**
	 * Calculates the amount of fuel needed to align all crabs at a certain position.
	 * @param alignedPosition	The position all crabs need to align to.
	 * @return					The amount of fuel that is needed for the alignment.
	 */
	private long calculateFuel(int alignedPosition) {
		long totalFuel = 0;
		for (int position : crabsPerPosition.keySet()) {
			int numberOfCrabs = crabsPerPosition.get(position);
			int fuel = Math.abs(alignedPosition - position);
			totalFuel += (numberOfCrabs * fuel);
		}
		return totalFuel;
	}
	
	public Map<Integer, Integer> getCrabPositions() {
		return crabsPerPosition;
	}
}
