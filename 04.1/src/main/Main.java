package main;

import java.io.FileNotFoundException;
import java.util.List;

import bingo.BingoGame;
import bingo.BingoTransformer;
import utils.FileTransformer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Transform txt file to ArrayList
		String path = Main.class.getResource("../input/input.txt").getFile();
		List<String> data = FileTransformer.fileToList(path);
	    
	    // Divide data in separate data structures
		BingoTransformer b = new BingoTransformer(data);
		int[] draws = b.getDraws();
		List<int[][]> cards = b.getCards();
		
	    // Play bingo
		BingoGame game = new BingoGame(draws, cards);
		game.play();
		
	    // Calculate and print result
		int calledNumber = draws[game.getRound() - 1];
		int[][] winningCard = game.getWinningCard();
		int sum = 0;
		for (int row = 0; row < winningCard.length; row++) {
			for (int col = 0; col < winningCard[row].length; col++) {
				if (winningCard[row][col] != game.MARKED) {
					sum += winningCard[row][col];
				}
			}
		}
		System.out.println(sum * calledNumber);
	}
}
