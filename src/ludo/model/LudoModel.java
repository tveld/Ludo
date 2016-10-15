package ludo.model;

import java.util.Random;

public class LudoModel {
  /**
   * The size of the board array in the model.
   */
  private static final int BOARD_SIZE = 52;

  private int currentPlayer;

  static final int[] START_POSITIONS = { 0, 13, 26, 39 };
  static final int[] SAFE_ADJACENT_POSITIONS = { 50, 11, 24, 37 };

  Random rand;

  BoardSquare[] board;
  Player[] playerList;

  /**
   * Default constructor for LudoModel. Initializes random number generator,
   * sets up the board, creates the players, and sets the current player to RED.
   */
  public LudoModel() {
    rand = new Random();

    playerList = new Player[4];
    playerList[Player.RED] = new Player(Player.RED);
    playerList[Player.BLUE] = new Player(Player.BLUE);
    playerList[Player.GREEN] = new Player(Player.GREEN);
    playerList[Player.YELLOW] = new Player(Player.YELLOW);

    setUpBoard();

    currentPlayer = Player.RED;
  }

  /**
   * This method creates the board and sets the starting positions of the game
   * pieces.
   */
  public void setUpBoard() {
    board = new BoardSquare[BOARD_SIZE];

    for (int i = 0; i < BOARD_SIZE; i++) {
      board[i] = new BoardSquare(BoardSquare.REGULAR, Player.ALL, i);
    }

    board[START_POSITIONS[Player.RED]].setSquareTypeAndPlayersAllowed(BoardSquare.START_POSITION,
        Player.ALL);
    board[START_POSITIONS[Player.BLUE]].setSquareTypeAndPlayersAllowed(BoardSquare.START_POSITION,
        Player.ALL);
    board[START_POSITIONS[Player.GREEN]].setSquareTypeAndPlayersAllowed(BoardSquare.START_POSITION,
        Player.ALL);
    board[START_POSITIONS[Player.YELLOW]].setSquareTypeAndPlayersAllowed(BoardSquare.START_POSITION,
        Player.ALL);

    board[SAFE_ADJACENT_POSITIONS[Player.RED]]
        .setSquareTypeAndPlayersAllowed(BoardSquare.SAFE_ADJACENT, Player.RED);
    board[SAFE_ADJACENT_POSITIONS[Player.BLUE]]
        .setSquareTypeAndPlayersAllowed(BoardSquare.SAFE_ADJACENT, Player.BLUE);
    board[SAFE_ADJACENT_POSITIONS[Player.GREEN]]
        .setSquareTypeAndPlayersAllowed(BoardSquare.SAFE_ADJACENT, Player.GREEN);
    board[SAFE_ADJACENT_POSITIONS[Player.YELLOW]]
        .setSquareTypeAndPlayersAllowed(BoardSquare.SAFE_ADJACENT, Player.YELLOW);
  }

  /**
   * This method simulates rolling a dice.
   * 
   * @return The random integer representing the dice roll
   */
  public int rollDice() {
    return rand.nextInt(6) + 1;
  }

  /**
   * This method advances the player counter and returns current player.
   * 
   * @return The new current player
   */
  public int nextPlayerTurn() {
    currentPlayer = (currentPlayer + 1) % 4;
    return currentPlayer;
  }

  private boolean move(int oldPos, int newPos, int diceRoll) {
    if (validMove(oldPos, newPos, diceRoll)) {
      return false;
    }
    return true;
  }

  /**
   * Check if all Ludo rules are satisfied before moving.
   * 
   * @param int
   *          oldPos, the old position we are attempting to move from
   * @param int
   *          newPos, the new position we are attempting to move to
   * @param int
   *          diceRoll, the number of positions to move forward
   * @return boolean, true if can't move, false if can move
   */
  private boolean validMove(int oldPos, int newPos, int diceRoll){
	  
	  if(isOccupied(oldPos, newPos)){
		  return false;  
		 
	  } else if(cantMove(oldPos, newPos, diceRoll)){
		  return false;
		  
	  }
	  return true;
  }

  /**
   * Check if the new position is occupied.
   * 
   * @param int
   *          oldPos, the old position we are attempting to move from
   * @param int
   *          newPos, the new position we are attempting to move to
   * @return boolean, true if can't move, false if can move
   */
  private boolean isOccupied(int oldPos, int newPos) {
    GamePiece atNew = board[newPos].getGamePiece();

    // check if a piece is in newPos.
    if (atNew != null) {

      int playerAtNew = atNew.getPlayer();

      // current player already there. Illegal move.
      if (playerAtNew == currentPlayer) {
        return true;

        // need move piece to start. Still legal move.
      } else {
        // move current piece to start
        GamePiece atOld = board[oldPos].getGamePiece();
        atOld.setPosition(GamePiece.IN_START, false);
        return false;
      }
    }
    return false;
  }

  /**
   * Check if a player can't move piece.
   * 
   * @param int
   *          oldPos, the old position we are attempting to move from
   * @param int
   *          newPos, the new position we are attempting to move to
   * @param int
   *          diceRoll, the number of positions to move forward
   * @return boolean, true if can't move, false if can move
   */
  private boolean cantMove(int oldPos, int newPos, int diceRoll) {
    // check if in start position
    if (oldPos == START_POSITIONS[currentPlayer]) {

      // need a roll greater than 6 to leave start
      if (diceRoll < 6) {
        return true;

        // can't move backwards
      } else if (newPos < oldPos) {
        return true;
      }
    }
    return false;
  }

  /**
   * A getter for a player, player number must be between 0 and 3.
   * 
   * @param playerNumber
   *          The number of the player to return
   * @return The player
   */
  public Player getPlayer(int playerNumber) {
    if (playerNumber >= 0 && playerNumber <= 3) {
      return playerList[playerNumber];
    } else {
      return null;
    }
  }

  /**
   * Getter for the current player.
   * 
   * @return The current player
   */
  public int getCurrentPlayer() {
    return currentPlayer;
  }
}
