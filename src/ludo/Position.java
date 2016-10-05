package ludo;

public class Position {
	private int x;
	private int y;
	
	public Position() {
		x = y = -1;
	}
	
	public Position(int pX, int pY) {
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
}
