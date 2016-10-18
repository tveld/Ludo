package ludo.model;

/**
 * A class representing a square on the board.
 * 
 * @author Katie Mulder
 *
 */
public class BoardSquare {
  /**
   * A constant representing a regular square.
   */
  public static final int REGULAR = 1;
  /**
   * A constant representing a starting square.
   */
  public static final int START = 2;
  /**
   * A constant representing a start position square.
   */
  public static final int START_POSITION = 3;
  /**
   * A constant representing a safe square.
   */
  public static final int SAFE = 4;
  /**
   * A constant representing a safe adjacent square.
   */
  public static final int SAFE_ADJACENT = 5;
  /**
   * A constant representing a home square.
   */
  public static final int HOME = 6;
  /**
   * A variable holding the square type.
   */
  private int squareType;
  /**
   * The players allowed to land on a square.
   */
  private int playersAllowed;
  /**
   * The game piece on the square.
   */
  private GamePiece gamePiece;
  /**
   * THe position of the square.
   */
  private int position;

  /**
   * Constructor to initialize a BoardSquare with the parameter values.
   * 
   * @param paramSquareType
   *          The type of BoardSquare
   * @param paramPlayersAllowed
   *          The players allowed to be on this BoardSquare
   * @param paramPosition
   *          The position of this BoardSquare in the LudoModel array
   */
  public BoardSquare(final int paramSquareType, final int paramPlayersAllowed,
      final int paramPosition) {
    position = paramPosition;
    squareType = paramSquareType;
    playersAllowed = paramPlayersAllowed;
  }

  /**
   * Create a BoardSquare with the specified values.
   * 
   * @param paramType
   *          The type of BoardSquare
   * @param paramPlayers
   *          The players allowed on the BoardSquare
   * @param paramPosition
   *          The position in the LudoModel array
   */
  public final void setBoardSquare(final int paramType, final int paramPlayers,
      final int paramPosition) {
    playersAllowed = paramPlayers;
    position = paramPosition;
    squareType = paramType;
  }

  /**
   * The getter for squareType.
   *
   * @return the squareType
   */
  public final int getSquareType() {
    return squareType;
  }

  /**
   * Set the square type, if the square is next to a safe area, create the array
   * of safe positions.
   * 
   * @param paramSquareType
   *          The square type
   */
  public final void setSquareType(final int paramSquareType) {
    this.squareType = paramSquareType;
  }

  /**
   * The getter for playersAllowed.
   *
   * @return the playersAllowed
   */
  public final int getPlayersAllowed() {
    return playersAllowed;
  }

  /**
   * The getter for gamePiece.
   *
   * @return the gamePiece
   */
  public final GamePiece getGamePiece() {
    return gamePiece;
  }

  /**
   * The setter for gamePiece.
   *
   * @param paramGamePiece
   *          the gamePiece to set
   */
  public final void setGamePiece(final GamePiece paramGamePiece) {
    this.gamePiece = paramGamePiece;
    if (paramGamePiece != null) {
      this.gamePiece.setPosition(position);
    }
  }

  /**
   * The getter for position.
   *
   * @return the position
   */
  public final int getPosition() {
    return position;
  }
}
