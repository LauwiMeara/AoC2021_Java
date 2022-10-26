package main;

import java.io.FileNotFoundException;
import java.util.List;

import depthCounter.DepthCounter;
import utils.FileTransformer;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to ArrayList
		String path = Main.class.getResource("../input/input.txt").getFile();
	    List<Integer> data = FileTransformer.fileToIntList(path);
	    
	    // Count depth increases
	    int counter = DepthCounter.countDepthIncreases(data);
	    
	    // Print result
	    System.out.println(counter);
	}
}
