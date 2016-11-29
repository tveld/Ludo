package ludo.model;

import java.util.Random;

/**
 * 
 * @author Katie Mulder, Troy Veldhuizen, Adam Caldwell
 *
 */
public class LudoGame {
  /**
   * The size of the board array in the model.
   */
  private static final int BOARD_SIZE = 88;
  /**
   * The size of the main board.
   */
  private static final int MAIN_BOARD_SIZE = 52;
  /**
   * A constant for the number of players.
   */
  private static final int NUMBER_PLAYERS = 4;
  /**
   * A constant for the random number generator.
   */
  private static final int DICE_VALUE = 6;
  /**
   * An array that holds the start positions of each player.
   */
  static final int[] START_POSITIONS = { 72, 76, 80, 84 };
  /**
   * An array that holds the enter positions of each player.
   */
  static final int[] PIECE_ENTER_POSITIONS = { 0, 13, 26, 39 };
  /**
   * An array that holds the safe adjacent positions of each player.
   */
  static final int[] SAFE_ADJACENT_POSITIONS = { 50, 11, 24, 37 };
  /**
   * An array that holds the first safe positions of each player.
   */
  static final int[] SAFE_POSITION_0 = { 52, 57, 62, 67 };
  /**
   * A constant representing index 0.
   */
  private static final int INDEX_0 = 0;
  /**
   * A constant representing index 1.
   */
  private static final int INDEX_1 = 1;
  /**
   * A constant representing index 2.
   */
  private static final int INDEX_2 = 2;
  /**
   * A constant representing index 3.
   */
  private static final int INDEX_3 = 3;
  /**
   * A constant representing the number of safe positions.
   */
  private static final int NUM_SPACES_SAFE = 5;
  /**
   * A variable that holds the current player.
   */
  private int currentPlayer;
  /**
   * A source of random numbers.
   */
  private Random rand;
  /**
   * An array that holds the board.
   */
  private BoardSquare[] board;
  /**
   * An array of players.
   */
  private Player[] playerList;

  /**
   * Default constructor for LudoModel. Initializes random number generator,
   * sets up the board, creates the players, and sets the current player to RED.
   */
  public LudoGame() {
    rand = new Random();

    playerList = new Player[NUMBER_PLAYERS];
    playerList[Player.RED] = new Player(Player.RED, "redPiece.png");
    playerList[Player.BLUE] = new Player(Player.BLUE, "bluePiece.png");
    playerList[Player.GREEN] = new Player(Player.GREEN, "greenPiece.png");
    playerList[Player.YELLOW] = new Player(Player.YELLOW, "yellowPiece.png");

    setUpBoard();

    currentPlayer = Player.RED;
  }

  /**
   * This method creates the board and sets the starting positions of the game
   * pieces.
   */
  public final void setUpBoard() {
    board = new BoardSquare[BOARD_SIZE];

    // Create the regular board squares
    for (int i = 0; i < SAFE_POSITION_0[Player.RED]; i++) {
      board[i] = new BoardSquare(BoardSquare.REGULAR, Player.ALL, i);
    }

    // Create the red safe squares
    for (int i = SAFE_POSITION_0[Player.RED]; i < SAFE_POSITION_0[Player.BLUE];
        i++) {
      board[i] = new BoardSquare(BoardSquare.SAFE, Player.RED, i);
    }

    // Create the blue safe squares
    for (int i = SAFE_POSITION_0[Player.BLUE];
        i < SAFE_POSITION_0[Player.GREEN]; i++) {
      board[i] = new BoardSquare(BoardSquare.SAFE, Player.BLUE, i);
    }

    // Create the green safe squares
    for (int i = SAFE_POSITION_0[Player.GREEN];
        i < SAFE_POSITION_0[Player.YELLOW]; i++) {
      board[i] = new BoardSquare(BoardSquare.SAFE, Player.GREEN, i);
    }

    // Create the yellow safe squares
    for (int i = SAFE_POSITION_0[Player.YELLOW];
        i < START_POSITIONS[Player.RED]; i++) {
      board[i] = new BoardSquare(BoardSquare.SAFE, Player.YELLOW, i);
    }

    // Create the red start squares
    int counter = 0;
    for (int i = START_POSITIONS[Player.RED]; i < START_POSITIONS[Player.BLUE];
        i++) {
      board[i] = new BoardSquare(BoardSquare.START, Player.RED, i);
      board[i].setGamePiece(playerList[Player.RED].getGamePiece(counter));
      counter++;
    }
    // Create the blue start squares
    counter = 0;
    for (int i = START_POSITIONS[Player.BLUE];
        i < START_POSITIONS[Player.GREEN]; i++) {
      board[i] = new BoardSquare(BoardSquare.START, Player.BLUE, i);
      board[i].setGamePiece(playerList[Player.BLUE].getGamePiece(counter));
      counter++;
    }
    // Create the green start squares
    counter = 0;
    for (int i = START_POSITIONS[Player.GREEN];
        i < START_POSITIONS[Player.YELLOW]; i++) {
      board[i] = new BoardSquare(BoardSquare.START, Player.GREEN, i);
      board[i].setGamePiece(playerList[Player.GREEN].getGamePiece(counter));
      counter++;
    }
    // Create the yellow start squares
    counter = 0;
    for (int i = START_POSITIONS[Player.YELLOW]; i < BOARD_SIZE; i++) {
      board[i] = new BoardSquare(BoardSquare.START, Player.YELLOW, i);
      board[i].setGamePiece(playerList[Player.YELLOW].getGamePiece(counter));
      counter++;
    }

    for (int i = 0; i < NUMBER_PLAYERS; i++) {
      board[PIECE_ENTER_POSITIONS[i]].setSquareType(BoardSquare.START_POSITION);
      board[SAFE_ADJACENT_POSITIONS[i]]
          .setSquareType(BoardSquare.SAFE_ADJACENT);
    }
  }

  /**
   * This method simulates rolling a dice.
   * 
   * @return The random integer representing the dice roll
   */
  public final int rollDice() {
    return rand.nextInt(DICE_VALUE) + 1;
  }

  /**
   * This method advances the player counter and returns current player.
   * 
   * @return The new current player
   */
  public final int nextPlayerTurn() {
    currentPlayer = (currentPlayer + 1) % NUMBER_PLAYERS;
    return currentPlayer;
  }

  /**
   * This method moves a piece from oldPos to newPos if it is a valid move.
   * 
   * @param oldPos
   *          The current position of the piece
   * @param diceRoll
   *          The number of squares the move is supposed to be
   * @return True if the move was successful, false if it failed
   */
  public final boolean move(final int oldPos, final int diceRoll) {
    int newPos = (oldPos + diceRoll) % MAIN_BOARD_SIZE;

    if (oldPos >= START_POSITIONS[currentPlayer]) {
      newPos = PIECE_ENTER_POSITIONS[currentPlayer];
    }

    if (validMove(oldPos, newPos, diceRoll)) {
      GamePiece movePiece = board[oldPos].getGamePiece();
      board[oldPos].setGamePiece(null);
      board[newPos].setGamePiece(movePiece);

      return true;
    } else if (moveSafeSpots(oldPos, diceRoll) != -1) {
      newPos = moveSafeSpots(oldPos, diceRoll);
      GamePiece movePiece = board[oldPos].getGamePiece();
      board[oldPos].setGamePiece(null);
      board[newPos].setGamePiece(movePiece);

      return true;
    } else {
      return false;
    }
  }

  /**
   * Check if all Ludo rules are satisfied before moving.
   * 
   * @param oldPos
   *          the old position we are attempting to move from
   * @param newPos
   *          the new position we are attempting to move to
   * @param diceRoll
   *          the number of positions to move forward
   * @return boolean true if can't move, false if can move
   */
  private boolean validMove(final int oldPos, final int newPos,
      final int diceRoll) {

    if (!cantMove(oldPos, newPos, diceRoll)) {
      if (board[newPos].getGamePiece() != null) {
        GamePiece atNew = board[newPos].getGamePiece();
        atNew.setPosition(
            START_POSITIONS[atNew.getPlayer()] + atNew.getPieceNumber());
      }
      return true;
    } else {
      return false;
    }

  }

  /**
   * Check if the new position is occupied.
   * 
   * @param oldPos
   *          the old position we are attempting to move from
   * @param newPos
   *          the new position we are attempting to move to
   * @return boolean true if can't move, false if can move
   */
  private boolean isOccupied(final int oldPos, final int newPos) {
    GamePiece atNew = board[newPos].getGamePiece();
    // check if a piece is in newPos.
    if (atNew != null) {
      int playerAtNew = atNew.getPlayer();
      return playerAtNew == currentPlayer;
    } else {
      return false;
    }
  }

  /**
   * Check if a piece should move into a safe position.
   * 
   * @param oldPos
   *          The current position of the piece
   * @param diceRoll
   *          The number of spaces to move
   * @return The new position of the piece, or -1 if there is not a valid move
   *         into a safe position
   */
  private int moveSafeSpots(final int oldPos, final int diceRoll) {
    int newPos = -1;
    int dr = diceRoll;

    if (currentPlayer == Player.RED) {
      if (oldPos <= SAFE_ADJACENT_POSITIONS[currentPlayer]
          && oldPos + diceRoll > SAFE_ADJACENT_POSITIONS[currentPlayer]) {
        dr -= SAFE_ADJACENT_POSITIONS[currentPlayer] - oldPos;
        newPos = SAFE_POSITION_0[currentPlayer] + dr - 1;
      }
    } else if (currentPlayer == Player.BLUE) {
      if (oldPos <= SAFE_ADJACENT_POSITIONS[currentPlayer]
          && oldPos + diceRoll > SAFE_ADJACENT_POSITIONS[currentPlayer]) {
        dr -= SAFE_ADJACENT_POSITIONS[currentPlayer] - oldPos;
        newPos = SAFE_POSITION_0[currentPlayer] + dr - 1;
      }
    } else if (currentPlayer == Player.GREEN) {
      if (oldPos <= SAFE_ADJACENT_POSITIONS[currentPlayer]
          && oldPos + diceRoll > SAFE_ADJACENT_POSITIONS[currentPlayer]) {
        dr -= SAFE_ADJACENT_POSITIONS[currentPlayer] - oldPos;
        newPos = SAFE_POSITION_0[currentPlayer] + dr - 1;
      }
    } else if (currentPlayer == Player.YELLOW) {
      if (oldPos <= SAFE_ADJACENT_POSITIONS[currentPlayer]
          && oldPos + diceRoll > SAFE_ADJACENT_POSITIONS[currentPlayer]) {
        dr -= SAFE_ADJACENT_POSITIONS[currentPlayer] - oldPos;
        newPos = SAFE_POSITION_0[currentPlayer] + dr - 1;
      }
    }
    return newPos;
  }

  /**
   * Checks if valid move from start position.
   * 
   * @param oldPos
   *          the position you are moving from
   * @param newPos
   *          the position you are moving to
   * @param diceRoll
   *          the role of the dice
   * @return if the move is a valid start move
   */
  private boolean isValidStart(final int oldPos, final int newPos,
      final int diceRoll) {
    return (oldPos >= START_POSITIONS[currentPlayer]
        && oldPos <= START_POSITIONS[currentPlayer] + NUMBER_PLAYERS - 1
        && diceRoll == DICE_VALUE
        && newPos == PIECE_ENTER_POSITIONS[currentPlayer]);
  }

  /**
   * Check if a player can't move piece.
   * 
   * @param oldPos
   *          the old position we are attempting to move from
   * @param newPos
   *          the new position we are attempting to move to
   * @param diceRoll
   *          the number of positions to move forward
   * @return boolean, true if can't move, false if can move
   */
  private boolean cantMove(final int oldPos, final int newPos,
      final int diceRoll) {
    if (isOccupied(oldPos, newPos)) {
      return true;
    }
    if (isValidStart(oldPos, newPos, diceRoll)) {
      return false;
    }

    if ((oldPos + diceRoll) % MAIN_BOARD_SIZE != newPos) {
      return true;
    }

    // piece cannot move passed home position
    if (oldPos + diceRoll >= SAFE_POSITION_0[currentPlayer] + NUM_SPACES_SAFE) {
      return true;
    }

    // check if piece moved passed safe spots
    if (oldPos <= SAFE_ADJACENT_POSITIONS[currentPlayer]
        && newPos > SAFE_ADJACENT_POSITIONS[currentPlayer]) {

      return true;
    } else if (currentPlayer == Player.RED) {
      if (oldPos <= SAFE_ADJACENT_POSITIONS[currentPlayer]
          && oldPos + diceRoll > SAFE_ADJACENT_POSITIONS[currentPlayer]) {

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
  public final Player getPlayer(final int playerNumber) {
    if (playerNumber >= 0 && playerNumber <= NUMBER_PLAYERS - 1) {
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
  public final int getCurrentPlayer() {
    return currentPlayer;
  }

  /**
   * Getter for the game status.
   * 
   * @return The gameWon variable
   */
  public final boolean getGameWon() {
    for (Player x : playerList) {
      if (x.getGamePiece(INDEX_0).getPosition() == GamePiece.IN_HOME
          && x.getGamePiece(INDEX_1).getPosition() == GamePiece.IN_HOME
          && x.getGamePiece(INDEX_2).getPosition() == GamePiece.IN_HOME
          && x.getGamePiece(INDEX_3).getPosition() == GamePiece.IN_HOME) {
        return true;
      }
    }
    return false;
  }

  /**
   * A method that returns the name of the winning player.
   * 
   * @return The name of the winning player, or null if no one has won.
   */
  public final String getWinningPlayer() {
    if (playerList[Player.RED].getGamePiece(INDEX_0)
        .getPosition() == GamePiece.IN_HOME
        && playerList[Player.RED].getGamePiece(INDEX_1)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.RED].getGamePiece(INDEX_2)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.RED].getGamePiece(INDEX_3)
            .getPosition() == GamePiece.IN_HOME) {
      return "Red";
    } else if (playerList[Player.GREEN].getGamePiece(INDEX_0)
        .getPosition() == GamePiece.IN_HOME
        && playerList[Player.GREEN].getGamePiece(INDEX_1)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.GREEN].getGamePiece(INDEX_2)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.GREEN].getGamePiece(INDEX_3)
            .getPosition() == GamePiece.IN_HOME) {
      return "Green";
    } else if (playerList[Player.YELLOW].getGamePiece(INDEX_0)
        .getPosition() == GamePiece.IN_HOME
        && playerList[Player.YELLOW].getGamePiece(INDEX_1)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.YELLOW].getGamePiece(INDEX_2)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.YELLOW].getGamePiece(INDEX_3)
            .getPosition() == GamePiece.IN_HOME) {
      return "Yellow";
    } else if (playerList[Player.BLUE].getGamePiece(INDEX_0)
        .getPosition() == GamePiece.IN_HOME
        && playerList[Player.BLUE].getGamePiece(INDEX_1)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.BLUE].getGamePiece(INDEX_2)
            .getPosition() == GamePiece.IN_HOME
        && playerList[Player.BLUE].getGamePiece(INDEX_3)
            .getPosition() == GamePiece.IN_HOME) {
      return "Blue";
    }
    return "No Winner";
  }
}
