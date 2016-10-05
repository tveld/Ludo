package ludo;

class BoardSquare {
	private BoardSquareType squareType;
	private PlayerColors playersAllowed;
	private GamePiece gamePiece;
	private Position position;
	
	public BoardSquare() {
		squareType = BoardSquareType.REGULAR;
		playersAllowed = PlayerColors.ALL;
		gamePiece = null;
		position = new Position();
	}
	
	public BoardSquare (BoardSquareType pSquareType, PlayerColors pPlayersAllowed){
		squareType = pSquareType;
		playersAllowed = pPlayersAllowed;
	}
	
	public void setPosition (int pX, int pY) {
		position.setX(pX);
		position.setY(pY);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setBoardSquare(BoardSquareType pType, PlayerColors pPlayers, GamePiece pGamePiece){
		squareType = pType;
		playersAllowed = pPlayers;
		gamePiece = pGamePiece;
	}

	public BoardSquareType getSquareType() {
		return squareType;
	}

	public void setSquareType(BoardSquareType squareType) {
		this.squareType = squareType;
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
