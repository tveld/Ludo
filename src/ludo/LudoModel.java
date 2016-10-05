package ludo;

public class LudoModel {
	private static final int BOARD_SIZE = 15;
	BoardSquare[][] board;
	
	public LudoModel (){
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
		board[1][1].setBoardTypeAndPlayer(BoardSquareType.START,Players.RED);
		board[1][4].setBoardTypeAndPlayer(BoardSquareType.START,Players.RED);
		board[4][4].setBoardTypeAndPlayer(BoardSquareType.START,Players.RED);
		board[4][1].setBoardTypeAndPlayer(BoardSquareType.START,Players.RED);
		
		board[10][1].setBoardTypeAndPlayer(BoardSquareType.START,Players.BLUE);
		board[13][1].setBoardTypeAndPlayer(BoardSquareType.START,Players.BLUE);
		board[10][4].setBoardTypeAndPlayer(BoardSquareType.START,Players.BLUE);
		board[13][4].setBoardTypeAndPlayer(BoardSquareType.START,Players.BLUE);
		
		board[1][10].setBoardTypeAndPlayer(BoardSquareType.START,Players.YELLOW);
		board[4][10].setBoardTypeAndPlayer(BoardSquareType.START,Players.YELLOW);
		board[1][13].setBoardTypeAndPlayer(BoardSquareType.START,Players.YELLOW);
		board[4][13].setBoardTypeAndPlayer(BoardSquareType.START,Players.YELLOW);
		
		board[10][10].setBoardTypeAndPlayer(BoardSquareType.START,Players.GREEN);
		board[10][13].setBoardTypeAndPlayer(BoardSquareType.START,Players.GREEN);
		board[13][10].setBoardTypeAndPlayer(BoardSquareType.START,Players.GREEN);
		board[13][13].setBoardTypeAndPlayer(BoardSquareType.START,Players.GREEN);






	}
	
	public void printBoard() {
		System.out.println(" -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
		for(int i = 0; i<BOARD_SIZE; i++){
			System.out.print("|");
			for(int j = 0; j<BOARD_SIZE; j++) {
				if(board[i][j].getSquareType() == BoardSquareType.DISABLED){
					System.out.print("  ");
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
