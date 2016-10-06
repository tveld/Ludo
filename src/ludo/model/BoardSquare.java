package ludo.model;

public class BoardSquare {
	private BoardSquareType squareType;
	private PlayerColors playersAllowed;
	private GamePiece gamePiece;
	private int position;
	private BoardSquare[] array;

	public BoardSquare() {
		squareType = BoardSquareType.REGULAR;
		gamePiece = null;
		array = null;
		position = -1;
	}

	public BoardSquare(BoardSquareType pSquareType, PlayerColors pPlayersAllowed, int pPosition) {
		squareType = pSquareType;
		playersAllowed = pPlayersAllowed;
		position = pPosition;
		if (pSquareType == BoardSquareType.SAFE_ADJACENT) {
			array = new BoardSquare[6];
			array[0] = new BoardSquare(BoardSquareType.SAFE, pPlayersAllowed, 0);
			array[1] = new BoardSquare(BoardSquareType.SAFE, pPlayersAllowed, 1);
			array[2] = new BoardSquare(BoardSquareType.SAFE, pPlayersAllowed, 2);
			array[3] = new BoardSquare(BoardSquareType.SAFE, pPlayersAllowed, 3);
			array[4] = new BoardSquare(BoardSquareType.SAFE, pPlayersAllowed, 4);
			array[5] = new BoardSquare(BoardSquareType.HOME, pPlayersAllowed, 5);
		}
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int pPosition) {
		position = pPosition;
	}

	public void setBoardSquare(BoardSquareType pType, PlayerColors pPlayers, int pPosition) {
		squareType = pType;
		playersAllowed = pPlayers;
		position = pPosition;
	}

	public BoardSquareType getSquareType() {
		return squareType;
	}

	public void setSquareType(BoardSquareType squareType) {
		this.squareType = squareType;
	}

	public void setSquareType(BoardSquareType squareType, PlayerColors playerColor) {
		this.squareType = squareType;
		if (array == null && squareType == BoardSquareType.SAFE_ADJACENT) {
			array = new BoardSquare[6];
			array[0] = new BoardSquare(BoardSquareType.SAFE, playerColor, 0);
			array[1] = new BoardSquare(BoardSquareType.SAFE, playerColor, 1);
			array[2] = new BoardSquare(BoardSquareType.SAFE, playerColor, 2);
			array[3] = new BoardSquare(BoardSquareType.SAFE, playerColor, 3);
			array[4] = new BoardSquare(BoardSquareType.SAFE, playerColor, 4);
			array[5] = new BoardSquare(BoardSquareType.HOME, playerColor, 5);
		}
	}

	public PlayerColors getPlayersAllowed() {
		return playersAllowed;
	}

	public void setPlayersAllowed(PlayerColors playersAllowed) {
		this.playersAllowed = playersAllowed;
	}

	public GamePiece getGamePiece() {
		return gamePiece;
	}

	public void setGamePiece(GamePiece gamePiece) {
		this.gamePiece = gamePiece;
	}
}
