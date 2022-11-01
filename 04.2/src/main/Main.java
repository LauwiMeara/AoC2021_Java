package main;

import java.io.FileNotFoundException;
import java.util.List;

import bingo.BingoGame;
import bingo.BingoDataTransformer;
import utils.FileTransformer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to List
		String path = Main.class.getResource("../input/input.txt").getFile();
		List<String> data = FileTransformer.fileToList(path);
	    
	    // Divide data in separate data structures
		BingoDataTransformer b = new BingoDataTransformer(data);
		int[] draws = b.getDraws();
		List<int[][]> cards = b.getCards();
		
	    // Play bingo
		BingoGame game = new BingoGame(draws, cards);
		game.play();
		
	    // Calculate and print result
		int calledNumber = draws[game.getRound() - 1];
		int[][] losingCard = game.getLosingCard();
		int sum = 0;
		for (int row = 0; row < losingCard.length; row++) {
			for (int col = 0; col < losingCard[row].length; col++) {
				if (losingCard[row][col] != game.MARKED) {
					sum += losingCard[row][col];
				}
			}
		}
		System.out.println(sum * calledNumber);
	}
}
