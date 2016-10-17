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
  public BoardSquare(int paramSquareType, int paramPlayersAllowed, int paramPosition) {
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
  public void setBoardSquare(int paramType, int paramPlayers, int paramPosition) {
    playersAllowed = paramPlayers;
    position = paramPosition;
    squareType = paramType;
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
   * Set the square type, if the square is next to a safe area, create the array
   * of safe positions.
   * 
   * @param paramSquareType
   *          The square type
   */
  public void setSquareType(int paramSquareType) {
    this.squareType = paramSquareType;
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
   * @param gamePiece
   *          the gamePiece to set
   */
  public void setGamePiece(GamePiece gamePiece) {
    this.gamePiece = gamePiece;
    if(gamePiece != null){
    	this.gamePiece.setPosition(position);
    }
  }

  /**
   * The getter for position.
   *
   * @return the position
   */
  public int getPosition() {
    return position;
  }
}
