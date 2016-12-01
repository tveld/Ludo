package ludo.model;

/**
 * This class contains methods and variables that represent a game player.
 * 
 * @author Katie Mulder
 *
 */
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
  /**
   * A constant that represents the number of game pieces.
   */
  private static final int NUMBER_PIECES = 4;
  /**
   * A constant that represents an index.
   */
  private static final int INDEX_0 = 0;
  /**
   * A constant that represents an index.
   */
  private static final int INDEX_1 = 1;
  /**
   * A constant that represents an index.
   */
  private static final int INDEX_2 = 2;
  /**
   * A constant that represents an index.
   */
  private static final int INDEX_3 = 3;

  /**
   * An integer representing the player color.
   */
  private int playerColor;
  /**
   * The array to hold the game pieces that belong to a player.
   */
  private GamePiece[] gamePieces;

  /**
   * Constructor for a player with the given number.
   * 
   * @param paramPlayerNumber
   *          The number of this player
   * @param iconName
   *          The icon for this game piece
   */
  public Player(final int paramPlayerNumber, final String iconName) {
    playerColor = paramPlayerNumber;
    gamePieces = new GamePiece[NUMBER_PIECES];
    gamePieces[INDEX_0] = new GamePiece(paramPlayerNumber, INDEX_0, iconName);
    gamePieces[INDEX_1] = new GamePiece(paramPlayerNumber, INDEX_1, iconName);
    gamePieces[INDEX_2] = new GamePiece(paramPlayerNumber, INDEX_2, iconName);
    gamePieces[INDEX_3] = new GamePiece(paramPlayerNumber, INDEX_3, iconName);
  }

  /**
   * Constructor for a player with the given number.
   * 
   * @param paramPlayerNumber
   *          The number of this player
   */
  public Player(final int paramPlayerNumber) {
    playerColor = paramPlayerNumber;
    gamePieces = new GamePiece[NUMBER_PIECES];
    gamePieces[INDEX_0] = new GamePiece(paramPlayerNumber, INDEX_0);
    gamePieces[INDEX_1] = new GamePiece(paramPlayerNumber, INDEX_1);
    gamePieces[INDEX_2] = new GamePiece(paramPlayerNumber, INDEX_2);
    gamePieces[INDEX_3] = new GamePiece(paramPlayerNumber, INDEX_3);
  }

  /**
   * The getter for playerColor.
   *
   * @return the playerColor
   */
  public final int getPlayerColor() {
    return playerColor;
  }

  /**
   * The getter for gamePieces[index].
   *
   * @param index
   *          The index of the GamePiece to return
   * @return the gamePieces[index]
   */
  public final GamePiece getGamePiece(final int index) {
    return gamePieces[index];
  }
}
