package main;

import java.io.FileNotFoundException;

import fishRegister.FishRegister;
import utils.FileTransformer;

// Days 6.1 and 6.2 are combined in one project, as only one value (DAYS) differs
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		final int DAYS1 = 80;
		final int DAYS2 = 256;
		
		// Transform txt file to List
		String path = Main.class.getResource("../input/input.txt").getFile();
		String[] data = FileTransformer.fileToArray(path, ",");

		// Create fish register
		FishRegister fr1 = new FishRegister(data);
		FishRegister fr2 = new FishRegister(data);
		
		// Go through the number of given days
		for (int day = 1; day <= DAYS1; day++) {
			fr1.registerFishReproduction();
		}
		for (int day = 1; day <= DAYS2; day++) {
			fr2.registerFishReproduction();
		}
		
	    // Print result
		System.out.println(fr1.getNumberOfFish());
		System.out.println(fr2.getNumberOfFish());
	}
}
