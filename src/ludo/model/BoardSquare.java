package ludo.model;

public class BoardSquare {
	public static final int DISABLED = 0;
	public static final int REGULAR = 1; 
	public static final int START = 2;
	public static final int START_POSITION = 3; 
	public static final int SAFE = 4;
	public static final int SAFE_ADJACENT = 5;
	public static final int HOME = 6;
	private int squareType;
	private int playersAllowed;
	private GamePiece gamePiece;
	private int position;
	private BoardSquare[] array;

	public BoardSquare() {
		squareType = REGULAR;
		gamePiece = null;
		array = null;
		position = -1;
		playersAllowed = Player.ALL;
	}

	public BoardSquare(int pSquareType, int pPlayersAllowed, int pPosition) {
		squareType = pSquareType;
		playersAllowed = pPlayersAllowed;
		position = pPosition;
		setSquareType(pSquareType, pPlayersAllowed);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int pPosition) {
		position = pPosition;
	}

	public void setBoardSquare(int pType, int pPlayers, int pPosition) {
		squareType = pType;
		playersAllowed = pPlayers;
		position = pPosition;
	}

	public int getSquareType() {
		return squareType;
	}

	public void setSquareType(int squareType) {
		this.squareType = squareType;
	}

	public void setSquareType(int squareType, int playerColor) {
		this.squareType = squareType;
		if (array == null && squareType == SAFE_ADJACENT) {
			array = new BoardSquare[6];
			array[0] = new BoardSquare(SAFE, playerColor, 0);
			array[1] = new BoardSquare(SAFE, playerColor, 1);
			array[2] = new BoardSquare(SAFE, playerColor, 2);
			array[3] = new BoardSquare(SAFE, playerColor, 3);
			array[4] = new BoardSquare(SAFE, playerColor, 4);
			array[5] = new BoardSquare(HOME, playerColor, 5);
		}
	}

	public int getPlayersAllowed() {
		return playersAllowed;
	}

	public void setPlayersAllowed(int playersAllowed) {
		this.playersAllowed = playersAllowed;
	}

	public GamePiece getGamePiece() {
		return gamePiece;
	}

	public BoardSquare[] getArray() {
		return array;
	}

	public void setArray(BoardSquare[] array) {
		this.array = array;
	}

	public void setGamePiece(GamePiece gamePiece) {
		this.gamePiece = gamePiece;
	}
}
