package ludo;

public class GamePiece {
  private PlayerColors player;
  private Position position;

  public GamePiece(PlayerColors pPlayerColor) {
    player = pPlayerColor;
    position = new Position();
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(int pX, int pY) {
    position.setX(pX);
    position.setY(pY);
  }

  public PlayerColors getPlayer() {
    return player;
  }

  public void setPlayer(PlayerColors player) {
    this.player = player;
  }

}
