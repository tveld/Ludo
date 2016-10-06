package ludo.model;

import java.util.Random;

public class LudoModel {
	/**
	 * The size of the board array in the model.
	 */
	private final int BOARD_SIZE = 52;
	/**
	 * A constant representing the red player's index.
	 */
	private final int RED = 0;
	/**
	 * A constant representing the blue player's index.
	 */
	private final int BLUE = 1;
	/**
	 * A constant representing the green player's index.
	 */
	private final int GREEN = 2;
	/**
	 * A constant representing the yellow player's index.
	 */
	private final int YELLOW = 3;

	private int currentPlayer;

	private static final int[] START_POSITIONS = { 0, 13, 26, 39 };
	private static final int[] SAFE_ADJACENT_POSITIONS = { 50, 11, 24, 37 };

	Random rand;

	BoardSquare[] board;
	Player[] playerList;

	public LudoModel() {
		rand = new Random();

		playerList = new Player[4];
		playerList[RED] = new Player(RED, PlayerColors.RED);
		playerList[BLUE] = new Player(BLUE, PlayerColors.BLUE);
		playerList[GREEN] = new Player(GREEN, PlayerColors.GREEN);
		playerList[GREEN] = new Player(GREEN, PlayerColors.GREEN);
		playerList[YELLOW] = new Player(YELLOW, PlayerColors.YELLOW);

		setUpBoard();

		currentPlayer = RED;
	}

	public void setUpBoard() {
		board = new BoardSquare[BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++) {
			board[i] = new BoardSquare(BoardSquareType.REGULAR, PlayerColors.ALL, i);
		}

		board[START_POSITIONS[RED]].setSquareType(BoardSquareType.START_POSITION);
		board[START_POSITIONS[BLUE]].setSquareType(BoardSquareType.START_POSITION);
		board[START_POSITIONS[GREEN]].setSquareType(BoardSquareType.START_POSITION);
		board[START_POSITIONS[YELLOW]].setSquareType(BoardSquareType.START_POSITION);

		board[SAFE_ADJACENT_POSITIONS[RED]].setSquareType(BoardSquareType.SAFE_ADJACENT, PlayerColors.RED);
		board[SAFE_ADJACENT_POSITIONS[BLUE]].setSquareType(BoardSquareType.SAFE_ADJACENT, PlayerColors.BLUE);
		board[SAFE_ADJACENT_POSITIONS[GREEN]].setSquareType(BoardSquareType.SAFE_ADJACENT, PlayerColors.GREEN);
		board[SAFE_ADJACENT_POSITIONS[YELLOW]].setSquareType(BoardSquareType.SAFE_ADJACENT, PlayerColors.YELLOW);
	}

	/**
	 * This method simulates rolling a dice.
	 * 
	 * @return The random integer representing the dice roll
	 */
	private int rollDice() {
		return rand.nextInt(6) + 1;
	}

	private void setNextPlayer() {
		currentPlayer = (currentPlayer + 1) % 4;
	}
}
