package main;

import java.io.FileNotFoundException;

import utils.FileTransformer;
import submarine.Submarine;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to multidimensional array
		String path = Main.class.getResource("../input/input.txt").getFile();
	    String[][] data = FileTransformer.fileToMultidimensionalArray(path, " ");
	    
	    // Follow travel commands
	    Submarine submarine = new Submarine();
	    for (String[] command : data) {
	    	int unit = Integer.parseInt(command[1]);
	    	switch (command[0]) {
		    	case "forward":
		    		submarine.goForward(unit);
		    		break;
		    	case "down":
		    		submarine.goDown(unit);
		    		break;
		    	case "up":
		    		submarine.goUp(unit);
		    		break;
		    	default:
		    		break;
	    	}
	    }
	    
	    // Print result
	    System.out.println(submarine.getPos() * submarine.getDepth());
	}
}
