package main;

import java.io.FileNotFoundException;

import fishRegister.FishRegister;
import utils.FileTransformer;

// Days 6.1 and 6.2 are combined in one project, as only one value (DAYS) differs
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		final int DAYS1 = 80;
		final int DAYS2 = 256;
		
		// Transform txt file to array of Strings
		String path = Main.class.getResource("../input/input.txt").getFile();
		String[] data = FileTransformer.fileToArray(path, ",");

		// Create fish register
		FishRegister fr = new FishRegister(data);
		
		// Go through the number of given days and print result
		for (int day = 1; day <= DAYS1; day++) {
			fr.registerFishReproduction();
		}
		System.out.println(fr.getNumberOfFish());
		
		for (int day = DAYS1 + 1; day <= DAYS2; day++) {
			fr.registerFishReproduction();
		}
		System.out.println(fr.getNumberOfFish());
	}
}
