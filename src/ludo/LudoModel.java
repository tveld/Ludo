package ludo;

public class LudoModel {
	private static final int BOARD_SIZE = 15;
	BoardSquare[][] board;
	Player[] playerList;

	public LudoModel() {
		playerList = new Player[4];
		playerList[0] = new Player(0, PlayerColors.RED);
		playerList[1] = new Player(1, PlayerColors.BLUE);
		playerList[2] = new Player(2, PlayerColors.YELLOW);
		playerList[3] = new Player(3, PlayerColors.GREEN);

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
		board[1][1].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[0].getGamePiece(0));
		board[1][4].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[0].getGamePiece(1));
		board[4][4].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[0].getGamePiece(2));
		board[4][1].setBoardSquare(BoardSquareType.START, PlayerColors.RED, playerList[0].getGamePiece(3));

		board[10][1].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[1].getGamePiece(0));
		board[13][1].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[1].getGamePiece(1));
		board[10][4].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[1].getGamePiece(2));
		board[13][4].setBoardSquare(BoardSquareType.START, PlayerColors.BLUE, playerList[1].getGamePiece(3));

		board[1][10].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[2].getGamePiece(0));
		board[4][10].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[2].getGamePiece(1));
		board[1][13].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[2].getGamePiece(2));
		board[4][13].setBoardSquare(BoardSquareType.START, PlayerColors.YELLOW, playerList[2].getGamePiece(3));

		board[10][10].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[3].getGamePiece(0));
		board[10][13].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[3].getGamePiece(1));
		board[13][10].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[3].getGamePiece(2));
		board[13][13].setBoardSquare(BoardSquareType.START, PlayerColors.GREEN, playerList[3].getGamePiece(3));
	}

	public void printBoard() {
		System.out.println(" -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print("|");
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j].getSquareType() == BoardSquareType.DISABLED) {
					System.out.print("  ");
				} else if (board[i][j].getGamePiece() != null) {
					if(board[i][j].getGamePiece().getPlayer() == PlayerColors.RED) {
						System.out.print("RR");
					} else if(board[i][j].getGamePiece().getPlayer() == PlayerColors.YELLOW) {
						System.out.print("YY");
					} else if(board[i][j].getGamePiece().getPlayer() == PlayerColors.BLUE) {
						System.out.print("BB");
					} else {
						System.out.print("GG");
					}
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
