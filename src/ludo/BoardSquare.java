package ludo;

class BoardSquare {
	private BoardSquareType squareType;
	private Players playersAllowed;
	private int positionX;
	private int positionY;
	
	public BoardSquare() {
		squareType = BoardSquareType.REGULAR;
		playersAllowed = Players.ALL;
	}
	
	public BoardSquare (BoardSquareType pSquareType, Players pPlayersAllowed){
		squareType = pSquareType;
		playersAllowed = pPlayersAllowed;
	}
	
	public void setPosition (int x, int y) {
		positionX = x;
		positionY = y;
	}
	
	public void setBoardTypeAndPlayer(BoardSquareType pType, Players pPlayers){
		squareType = pType;
		playersAllowed = pPlayers;
	}

	public BoardSquareType getSquareType() {
		return squareType;
	}

	public void setSquareType(BoardSquareType squareType) {
		this.squareType = squareType;
	}

	public Players getPlayersAllowed() {
		return playersAllowed;
	}

	public void setPlayersAllowed(Players playersAllowed) {
		this.playersAllowed = playersAllowed;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
