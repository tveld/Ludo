package ludo.model;

public class GamePiece {
	public final int IN_START = -1;
	public final int IN_HOME = -2;
	private PlayerColors player;
	private int position;

	public GamePiece(PlayerColors pPlayerColor) {
		player = pPlayerColor;
		position = IN_START;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int pPosition) {
		position = pPosition;
	}

	public PlayerColors getPlayer() {
		return player;
	}

	public void setPlayer(PlayerColors player) {
		this.player = player;
	}

}
