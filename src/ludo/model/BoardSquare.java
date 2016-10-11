package ludo.model;

public class BoardSquare {
  public static final int DISABLED = 0;
  public static final int REGULAR = 1;
  public static final int START = 2;
  public static final int START_POSITION = 3;
  public static final int SAFE = 4;
  public static final int SAFE_ADJACENT = 5;
  public static final int HOME = 6;
  private int squareType;
  private int playersAllowed;
  private GamePiece gamePiece;
  private int position;
  private BoardSquare[] array;

  /**
   * Default constructor for a BoardSquare.
   */
  public BoardSquare() {
    squareType = REGULAR;
    gamePiece = null;
    array = null;
    position = -1;
    playersAllowed = Player.ALL;
  }

  /**
   * Constructor to initialize a BoardSquare with the parameter values.
   * 
   * @param paramSquareType The type of BoardSquare
   * @param paramPlayersAllowed The players allowed to be on this BoardSquare
   * @param paramPosition The position of this BoardSquare in the LudoModel
   *          array
   */
  public BoardSquare(int paramSquareType, int paramPlayersAllowed, int paramPosition) {
    squareType = paramSquareType;
    playersAllowed = paramPlayersAllowed;
    position = paramPosition;
    setSquareType(paramSquareType, paramPlayersAllowed);
  }

  /**
   * Create a BoardSquare with the specified values.
   * 
   * @param paramType The type of BoardSquare
   * @param paramPlayers The players allowed on the BoardSquare
   * @param paramPosition The position in the LudoModel array
   */
  public void setBoardSquare(int paramType, int paramPlayers, int paramPosition) {
    squareType = paramType;
    playersAllowed = paramPlayers;
    position = paramPosition;
  }

  /**
   * The getter for squareType.
   *
   * @return the squareType
   */
  public int getSquareType() {
    return squareType;
  }

  /**
   * The setter for squareType.
   *
   * @param squareType the squareType to set
   */
  public void setSquareType(int squareType) {
    setSquareType(squareType, Player.ALL);
  }

  /**
   * Set the square type, if the square is next to a safe area, create the array
   * of safe positions.
   * 
   * @param paramSquareType The square type
   * @param paramPlayerColor The player to which the safe array belongs, if the
   *          square type is SAFE_ADJACENT
   */
  public void setSquareType(int paramSquareType, int paramPlayerColor) {
    this.squareType = paramSquareType;
    if (array == null && paramSquareType == SAFE_ADJACENT) {
      array = new BoardSquare[6];
      array[0] = new BoardSquare(SAFE, paramPlayerColor, 0);
      array[1] = new BoardSquare(SAFE, paramPlayerColor, 1);
      array[2] = new BoardSquare(SAFE, paramPlayerColor, 2);
      array[3] = new BoardSquare(SAFE, paramPlayerColor, 3);
      array[4] = new BoardSquare(SAFE, paramPlayerColor, 4);
      array[5] = new BoardSquare(HOME, paramPlayerColor, 5);
    }
  }

  /**
   * The getter for playersAllowed.
   *
   * @return the playersAllowed
   */
  public int getPlayersAllowed() {
    return playersAllowed;
  }

  /**
   * The setter for playersAllowed.
   *
   * @param playersAllowed the playersAllowed to set
   */
  public void setPlayersAllowed(int playersAllowed) {
    this.playersAllowed = playersAllowed;
  }

  /**
   * The getter for gamePiece.
   *
   * @return the gamePiece
   */
  public GamePiece getGamePiece() {
    return gamePiece;
  }

  /**
   * The setter for gamePiece.
   *
   * @param gamePiece the gamePiece to set
   */
  public void setGamePiece(GamePiece gamePiece) {
    this.gamePiece = gamePiece;
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

  /**
   * The getter for array.
   *
   * @return the array
   */
  public BoardSquare[] getArray() {
    return array;
  }

  /**
   * The setter for array.
   *
   * @param array the array to set
   */
  public void setArray(BoardSquare[] array) {
    this.array = array;
  }
}
