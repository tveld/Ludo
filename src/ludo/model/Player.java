package ludo.model;

public class Player {
	/**
	 * A constant representing the red player's index.
	 */
	public static final int RED = 0;
	/**
	 * A constant representing the blue player's index.
	 */
	public static final int BLUE = 1;
	/**
	 * A constant representing the green player's index.
	 */
	public static final int GREEN = 2;
	/**
	 * A constant representing the yellow player's index.
	 */
	public static final int YELLOW = 3;
	/**
	 * A constant representing all of the players.
	 */
	public static final int ALL = 4;
	
	int playerColor;
	GamePiece[] gamePieces;

	public Player(int paramPlayerNumber) {
		playerColor = paramPlayerNumber;
		gamePieces = new GamePiece[4];
		gamePieces[0] = new GamePiece(RED, 0);
		gamePieces[1] = new GamePiece(RED, 1);
		gamePieces[2] = new GamePiece(RED, 2);
		gamePieces[3] = new GamePiece(RED, 3);
	}

	public void setGamePiece(int paramPosition, GamePiece paramGamePiece) {
		gamePieces[paramPosition] = paramGamePiece;
	}

	public GamePiece getGamePiece(int paramPosition) {
		return gamePieces[paramPosition];
	}

	public int getPlayerNumber() {
		return playerColor;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerColor = playerNumber;
	}

	public int getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(int playerColor) {
		this.playerColor = playerColor;
	}

	public GamePiece[] getGamePieces() {
		return gamePieces;
	}

	public void setGamePieces(GamePiece[] gamePieces) {
		this.gamePieces = gamePieces;
	}
}
