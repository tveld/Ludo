package ludo.model;

public class GamePiece {
  public static final int IN_START = -1;
  public static final int IN_HOME = -2;
  private int player;
  private int pieceNumber;
  private int position;

  /** 
   * Constructor that creates a GamePiece with the specified values.
   * 
   * @param paramPlayerColor The player that this GamePiece belongs to.
   * @param paramPieceNumber The number of this GamePiece
   */
  public GamePiece(int paramPlayerColor, int paramPieceNumber) {
    player = paramPlayerColor;
    position = IN_START;
    this.pieceNumber = paramPieceNumber;
  }

  /**
   * The getter for player.
   *
   * @return the player
   */
  public int getPlayer() {
    return player;
  }

  /**
   * The getter for pieceNumber.
   *
   * @return the pieceNumber
   */
  public int getPieceNumber() {
    return pieceNumber;
  }

  /**
   * The getter for position.
   *
   * @return the position
   */
  public int getPosition() {
    return position;
  }

  /**
   * The setter for position.
   *
   * @param position the position to set
   */
  public void setPosition(int position) {
    this.position = position;
  }
}
