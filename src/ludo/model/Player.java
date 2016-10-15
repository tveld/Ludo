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

  /**
   * Constructor for a player with the given number.
   * 
   * @param paramPlayerNumber The number of this player
   */
  public Player(int paramPlayerNumber) {
    playerColor = paramPlayerNumber;
    gamePieces = new GamePiece[4];
    gamePieces[0] = new GamePiece(RED, 0);
    gamePieces[1] = new GamePiece(RED, 1);
    gamePieces[2] = new GamePiece(RED, 2);
    gamePieces[3] = new GamePiece(RED, 3);
  }

  /**
   * The getter for playerColor.
   *
   * @return the playerColor
   */
  public int getPlayerColor() {
    return playerColor;
  }

  /**
   * The getter for gamePieces[index].
   *
   * @param index The index of the GamePiece to return
   * @return the gamePieces[index]
   */
  public GamePiece getGamePiece(int index) {
    return gamePieces[index];
  }
}
