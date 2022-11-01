package ventSystem;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Pair;

/**
 * Class to keep register all vent coords.
 * @author Laura Luijben
 *
 */
public class VentSystem {
	private Map<Pair, Integer> ventRegister = new HashMap<>();
	
	/**
	 * Creates a map of xy coords and the number of vents that are present on the coords.
	 * @param recordedVentCoords	Input, consisting of the vents that the submarine has found.
	 */
	public VentSystem(List<List<String[]>> recordedVentCoords) {
		for (int i = 0; i < recordedVentCoords.size(); i++) {
			Vent vent = getVent(recordedVentCoords.get(i));
			addVentToRegister(vent);
		}
	}
	
	/**
	 * Creates a vent.
	 * @param record	One record of a vent that the submarine has found, consisting of start coords (x and y) and end coords (x and y).
	 * @return			Vent object.
	 */
	private Vent getVent(List<String[]> record) {
		String[] startCoords = record.get(0);
		String[] endCoords = record.get(1);
		
		int x1 = Integer.parseInt(startCoords[0]);
		int y1 = Integer.parseInt(startCoords[1]);
		int x2 = Integer.parseInt(endCoords[0]);
		int y2 = Integer.parseInt(endCoords[1]);
		
		return new Vent(x1, y1, x2, y2);
	}
	
	/**
	 * Adds all coords of a vent to the register. If the coords already exist in the register, one is added to the number of vents on the coords.
	 */
	private void addVentToRegister(Vent vent) {
		ArrayList<Pair> ventCoords = vent.getCoords();
		for (int i = 0; i < ventCoords.size(); i++) {
			Pair coords = ventCoords.get(i);
			if (this.ventRegister.containsKey(coords)) {
				this.ventRegister.put(coords, this.ventRegister.get(coords) + 1);
			} else {
				this.ventRegister.put(coords,  1);
			}
		}
	}
	
	public Map<Pair, Integer> getVentRegister() {
		return ventRegister;
	}
}
