package ludo;

class Player {
	int playerNumber;
	PlayerColors playerColor;
	GamePiece[] gamePieces;
	
	public Player (int pPlayerNumber, PlayerColors pPlayerColor) {
		playerColor = pPlayerColor;
		playerNumber = pPlayerNumber;
		gamePieces = new GamePiece[4];
		gamePieces[0] = new GamePiece(playerColor);
		gamePieces[1] = new GamePiece(playerColor);
		gamePieces[2] = new GamePiece(playerColor);
		gamePieces[3] = new GamePiece(playerColor);
	}
	
	public void setGamePiece(int position, GamePiece pGamePiece) {
		gamePieces[position] = pGamePiece;
	}
	
	public GamePiece getGamePiece(int position) {
		return gamePieces[position];
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public PlayerColors getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(PlayerColors playerColor) {
		this.playerColor = playerColor;
	}

	public GamePiece[] getGamePieces() {
		return gamePieces;
	}

	public void setGamePieces(GamePiece[] gamePieces) {
		this.gamePieces = gamePieces;
	}
}
