package ludo.model;

public class GamePiece {
	public static final int IN_START = -1;
	public static final int IN_HOME = -2;
	private int player;
	private int pieceNumber;
	private int position;

	public GamePiece(int pPlayerColor, int pieceNumber) {
		player = pPlayerColor;
		position = IN_START;
		this.pieceNumber = pieceNumber;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int pPosition) {
		position = pPosition;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getPieceNumber() {
		return pieceNumber;
	}

	public void setPieceNumber(int pieceNumber) {
		this.pieceNumber = pieceNumber;
	}

	public int getIN_START() {
		return IN_START;
	}

	public int getIN_HOME() {
		return IN_HOME;
	}
}
