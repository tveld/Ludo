package ludo;

public class LudoModel {
	private static final int BOARD_SIZE = 15;
	private static final int RED = 0;
	private static final int YELLOW = 1;
	private static final int GREEN = 2;
	private static final int BLUE = 3;
	BoardSquare[][] board;
	Player[] playerList;

	public LudoModel() {
		playerList = new Player[4];
		playerList[RED] = new Player(RED, PlayerColors.RED);
		playerList[BLUE] = new Player(BLUE, PlayerColors.BLUE);
		playerList[YELLOW] = new Player(YELLOW, PlayerColors.YELLOW);
		playerList[GREEN] = new Player(GREEN, PlayerColors.GREEN);

		setUpBoard();
	}

	public void setUpBoard() {
		board = new BoardSquare[BOARD_SIZE][BOARD_SIZE];

		// Set up board properties
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = new BoardSquare();
				if (i <= 5 && j <= 5 || i >= 9 && j <= 5 || i <= 5 && j >= 9 || i >= 9 && j >= 9) {
					board[i][j].setSquareType(BoardSquareType.DISABLED);
				}
				board[i][j].setPosition(i, j);
			}
		}

		// Place pieces in their starting positions
		board[1][1].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[RED].getGamePiece(0));
		board[1][4].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[RED].getGamePiece(1));
		board[4][4].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[RED].getGamePiece(2));
		board[4][1].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[RED].getGamePiece(3));

		board[10][1].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[YELLOW].getGamePiece(0));
		board[13][1].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[YELLOW].getGamePiece(1));
		board[10][4].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[YELLOW].getGamePiece(2));
		board[13][4].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[YELLOW].getGamePiece(3));

		board[1][10].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[BLUE].getGamePiece(0));
		board[4][10].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[BLUE].getGamePiece(1));
		board[1][13].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[BLUE].getGamePiece(2));
		board[4][13].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[BLUE].getGamePiece(3));

		board[10][10].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[GREEN].getGamePiece(0));
		board[10][13].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[GREEN].getGamePiece(1));
		board[13][10].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[GREEN].getGamePiece(2));
		board[13][13].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[GREEN].getGamePiece(3));

		// Set the Home squares
		for (int i = 6; i <= 8; i++) {
			for (int j = 6; j <= 8; j++) {
				board[i][j].setSquareType(BoardSquareType.HOME);
			}
		}

		// Set the red safe area
		for (int i = 1; i <= 5; i++) {
			board[i][7].setSquareType(BoardSquareType.PLAYER_ONLY);
			board[i][7].setPlayersAllowed(PlayerColors.BLUE);
		}

		// Set the yellow safe area
		for (int i = 9; i <= 13; i++) {
			board[7][i].setSquareType(BoardSquareType.PLAYER_ONLY);
			board[7][i].setPlayersAllowed(PlayerColors.GREEN);
		}

		// Set the red safe area
		for (int i = 1; i <= 5; i++) {
			board[7][i].setSquareType(BoardSquareType.PLAYER_ONLY);
			board[7][i].setPlayersAllowed(PlayerColors.RED);
		}

		// Set the red safe area
		for (int i = 9; i <= 13; i++) {
			board[i][7].setSquareType(BoardSquareType.PLAYER_ONLY);
			board[i][7].setPlayersAllowed(PlayerColors.YELLOW);
		}
	}

	public void printBoard() {
		System.out.println(" -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print("|");
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j].getSquareType() == BoardSquareType.DISABLED) {
					System.out.print("  ");
				} else if (board[i][j].getGamePiece() != null) {
					if (board[i][j].getGamePiece().getPlayer() == PlayerColors.RED) {
						System.out.print("RR");
					} else if (board[i][j].getGamePiece().getPlayer() == PlayerColors.YELLOW) {
						System.out.print("YY");
					} else if (board[i][j].getGamePiece().getPlayer() == PlayerColors.BLUE) {
						System.out.print("BB");
					} else {
						System.out.print("GG");
					}
				} else if (board[i][j].getSquareType() == BoardSquareType.PLAYER_ONLY) {
					if (board[i][j].getPlayersAllowed() == PlayerColors.RED) {
						System.out.print("rr");
					} else if (board[i][j].getPlayersAllowed() == PlayerColors.YELLOW) {
						System.out.print("yy");
					} else if (board[i][j].getPlayersAllowed() == PlayerColors.BLUE) {
						System.out.print("bb");
					} else {
						System.out.print("gg");
					}
				} else if (board[i][j].getSquareType() == BoardSquareType.HOME) {
					System.out.print("HH");
				} else {
					System.out.print("**");
				}
				System.out.print(" ");
			}
			System.out.println("|");
		}
		System.out.println(" -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
	}
}
