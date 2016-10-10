package ludo.view;

public class Position {
	private int x;
	private int y;
	private String gamePieceName;

	public Position() {
		x = y = -1;
	}

	public Position(int pX, int pY) {
		x = pX;
		y = pY;
	}

	public void setXY(int pX, int pY) {
		x = pX;
		y = pY;
	}

	public int getX() {
		return x;
	}

	public void setX(int pX) {
		x = pX;
	}

	public int getY() {
		return y;
	}

	public void setY(int pY) {
		y = pY;
	}

	public String getGamePieceName() {
		return gamePieceName;
	}

	public void setGamePieceName(String gamePieceName) {
		this.gamePieceName = gamePieceName;
	}
}
