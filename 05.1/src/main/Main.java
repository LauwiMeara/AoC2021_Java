package main;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.FileTransformer;
import utils.Pair;
import ventSystem.VentSystem;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to List
		String path = Main.class.getResource("../input/input.txt").getFile();
	    List<String> rawData = FileTransformer.fileToList(path);
	    
	    // Split data even further
	    List<List<String[]>> data = rawData.stream()
	    		.map(line -> Arrays.stream(line.split(" -> "))
	    				.map(xy -> xy.split(",")).collect(Collectors.toList()))
	    		.collect(Collectors.toList());
	    
	    // Create VentSystem
	    VentSystem vs = new VentSystem(data);
	    
	    // Get all overlapping vents
	    Map<Pair, Integer> register = vs.getVentRegister();
	    long overlappingVents = register.entrySet().stream().filter(e -> e.getValue() > 1).count();

	    // Print result
	    System.out.println(overlappingVents);
	}
}
