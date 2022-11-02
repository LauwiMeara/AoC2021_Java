package main;

import java.io.FileNotFoundException;

import crabSwarm.CrabSwarm;
import utils.FileTransformer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to array of Strings
		String path = Main.class.getResource("../input/input.txt").getFile();
		String[] data = FileTransformer.fileToArray(path, ",");
		
		// Calculate min amount of fuel needed of crab alignment
		CrabSwarm cs = new CrabSwarm(data);
		long minFuel = cs.calculateMinFuel();

	    // Print result
		System.out.println(minFuel);
	}
}
