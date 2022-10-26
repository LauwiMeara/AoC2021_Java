package bingo;

import java.util.List;

/**
 * Class to keep track of the bingo game.
 * @author Laura Luijben
 *
 */
public class BingoGame {
	// Integer that is used for marked numbers
	public final int MARKED = -1;
	
	private int[] draws;
	private List<int[][]> cards;
	private int[][] winningCard;
	// round and isGameOver start at default values, 0 and false respectively
	private int round;
	private boolean isGameOver;
	
	public BingoGame(int[] draws, List<int[][]> cards) {
		this.draws = draws;
		this.cards = cards;
	}
	
	public int getRound() {
		return round;
	}
	
	public int[][] getWinningCard() {
		return winningCard;
	}
	
	/**
	 * Draws and checks for the winner until the game is won.
	 */
	public void play() {
		while (!isGameOver) {
			draw();
			checkWinner();
		}
	}
	
	/**
	 * Draws and marks the drawn number on all cards.
	 */
	private void draw() {
		int draw = draws[round];
		for (int cardNumber = 0; cardNumber < cards.size(); cardNumber++) {
			int[][] card = cards.get(cardNumber);
			for (int row = 0; row < card.length; row++) {
				for (int col = 0; col < card[row].length; col++)
				{
					if (draw == card[row][col]) {
						card[row][col] = MARKED;
						cards.set(cardNumber, card); 
					}
				}
			}
		}
		round++;
	}
	
	/**
	 * Checks if the game is won (in other words: if a card has a completely marked row or column).
	 */
	private void checkWinner() {
		for (int cardNumber = 0; cardNumber < cards.size(); cardNumber++) {
			int[][] card = cards.get(cardNumber);
			if (hasMarkedRow(card) || hasMarkedColumn(card)) {
				winningCard = card;
				isGameOver = true;
				break;
			}
		}
	}
	
	/**
	 * Checks if any row of a given card is completely marked.
	 * @param card	Matrix of bingo numbers.
	 * @return		True if any row is completely marked, otherwise false.
	 */
	private boolean hasMarkedRow(int[][] card) {
		boolean isMarked = true;
		for (int row = 0; row < card.length; row++) {
			isMarked = true;
			for (int col = 0; col < card[row].length; col++)
			{
				if (card[row][col] != MARKED) {
					isMarked = false;
					break;
				}
			}
			
			if (isMarked) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if any column of a given card is completely marked.
	 * @param card	Matrix of bingo numbers.
	 * @return		True if any column is completely marked, otherwise false.
	 */
	private boolean hasMarkedColumn(int[][] card) {
		boolean isMarked = true;
		for (int col = 0; col < card[0].length; col++) {
			isMarked = true;
			for (int row = 0; row < card.length; row++)
			{
				if (card[row][col] != MARKED) {
					isMarked = false;
					break;
				}
			}
			
			if (isMarked) {
				return true;
			}
		}
		return false;
	}
}
