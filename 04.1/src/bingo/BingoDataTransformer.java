package bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class to transform bingo data.
 * @author Laura Luijben
 *
 */
public class BingoDataTransformer {
	private final int BINGO_SIZE = 5;
	private List<String> data;
	
	public BingoDataTransformer(List<String> data) {
		this.data = data;
	}
	
	/**
	 * Gives back the draws in its own data structure.
	 * @return	Draws as integer values.
	 */
	public int[] getDraws() {
		return Stream.of(data.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
	}
	
	/**
	 * Gives back the cards in its own data structure.
	 * @return	List of cards as multidimensional matrices.
	 */
	public ArrayList<int[][]> getCards() {
		ArrayList<int[][]> cards = new ArrayList<>();
		int row = 0;
		int cardNumber = -1;
		
		for (int line = 1; line < data.size(); line++) {
			if (data.get(line) == "") {
				// If the line is blank, a new card begins
				row = 0;
				cardNumber++;
				cards.add(new int[BINGO_SIZE][]);
			} else {
				// If the line has values, save the matrix of row and columns in the card in integer values
				int[][] card = cards.get(cardNumber);
				int[] cols = Stream.of(data.get(line).split(" ")).filter(col -> col.length() > 0).mapToInt(Integer::parseInt).toArray();
				card[row] = cols;
				row++;
			}
		}
		
		return cards;
	}
}
