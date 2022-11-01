package main;

import java.io.FileNotFoundException;
import java.util.List;

import decoder.ReportDecoder;
import utils.FileTransformer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to List
		String path = Main.class.getResource("../input/input.txt").getFile();
	    List<String> data = FileTransformer.fileToList(path);
	    
	    // Decode diagnostic report
	    ReportDecoder d = new ReportDecoder(data);
	    int lifeRate = d.getLifeRate();

	    // Print result
	    System.out.println(lifeRate);
	}
}
