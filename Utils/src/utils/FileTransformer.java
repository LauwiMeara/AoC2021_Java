package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Class to read txt files and transform them in ArrayLists.
 * @author Laura Luijben
 *
 */
public class FileTransformer {
	
	/**
	 * Transforms a txt file into a list of Strings.
	 * @param path	The path to the txt file.
	 * @return		The data in a list.
	 * @throws FileNotFoundException
	 */
	public static List<String> fileToList(String path) throws FileNotFoundException {
		try {
			File input = new File(path);
			Scanner scan = new Scanner(input);
			ArrayList<String> data = new ArrayList<>();
			while (scan.hasNextLine()) {
				data.add(scan.nextLine());
			}
			scan.close();
			return data;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new FileNotFoundException("Input file doesn't exist.");
		}
	}
	
	/**
	 * Transforms a txt file into a list of Integers.
	 * @param path	The path to the txt file.
	 * @return		The data in a list.
	 * @throws FileNotFoundException
	 */
	public static List<Integer> fileToIntList(String path) throws FileNotFoundException {
		List<String> list = fileToList(path);
		return list.stream().mapToInt(Integer::parseInt).boxed().toList();
	}
	
	/**
	 * Transforms a txt file into an array of Strings, which were divided by a given separator.
	 * @param path		The path to the txt file.
	 * @param separator	The substring to separate the strings.
	 * @return			The data in an array.
	 * @throws FileNotFoundException
	 */
	public static String[] fileToArray(String path, String separator) throws FileNotFoundException {
		List<String> list = fileToList(path);
		return list.stream().flatMap(line -> Stream.of(line.split(separator))).toArray(size -> new String[size]);
	}
	
	/**
	 * Transforms a txt file into a multidimensional array of Strings.
	 * @param path		The path to the txt file.
	 * @param separator	The substring to separate the strings.
	 * @return			The data in a multidimensional array.
	 * @throws FileNotFoundException
	 */
	public static String[][] fileToMultidimensionalArray(String path, String separator) throws FileNotFoundException {
		List<String> rawData = fileToList(path);
		String[][] data = new String[rawData.size()][];
	    for (int i = 0; i < rawData.size(); i++) {
	    	String[] splitString = rawData.get(i).split(separator);
	    	data[i] = new String[splitString.length];
	    	for (int j = 0; j < splitString.length; j++) {
	    		data[i][j] = splitString[j];
	    	}
	    }
	    return data;
	}
	
	
}

