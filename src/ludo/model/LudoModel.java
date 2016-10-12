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

    board[START_POSITIONS[Player.RED]].setSquareType(BoardSquare.START_POSITION);
    board[START_POSITIONS[Player.BLUE]].setSquareType(BoardSquare.START_POSITION);
    board[START_POSITIONS[Player.GREEN]].setSquareType(BoardSquare.START_POSITION);
    board[START_POSITIONS[Player.YELLOW]].setSquareType(BoardSquare.START_POSITION);

    board[SAFE_ADJACENT_POSITIONS[Player.RED]].setSquareType(BoardSquare.SAFE_ADJACENT, Player.RED);
    board[SAFE_ADJACENT_POSITIONS[Player.BLUE]].setSquareType(BoardSquare.SAFE_ADJACENT,
        Player.BLUE);
    board[SAFE_ADJACENT_POSITIONS[Player.GREEN]].setSquareType(BoardSquare.SAFE_ADJACENT,
        Player.GREEN);
    board[SAFE_ADJACENT_POSITIONS[Player.YELLOW]].setSquareType(BoardSquare.SAFE_ADJACENT,
        Player.YELLOW);

  }

  /**
   * This method simulates rolling a dice.
   * 
   * @return The random integer representing the dice roll
   */
  private int rollDice() {
    return rand.nextInt(6) + 1;
  }

  private void setNextPlayer() {
    currentPlayer = (currentPlayer + 1) % 4;
  }

  
  private boolean move(int oldPos, int newPos, int diceRoll){
	  checkMove(oldPos, newPos, diceRoll);
	  
	  return false;
  }
  

  private boolean checkMove(int oldPos, int newPos, int diceRoll){
	  if(alreadyThere(oldPos, newPos)){
		  return false;
	  }
	  return false;
  }
  
  private boolean alreadyThere(int oldPos, int newPos){
	  GamePiece atNew = board[newPos].getGamePiece();
	  
	  // check if a piece is in newPos
	  if(atNew != null){
		  
		  int playerAtNew = atNew.getPlayer();
		 
		  // current player already there. Illegal move.
		  if(playerAtNew == currentPlayer){
			return true;
			
		  // need move piece to start.  Still legal move.
		  } else {
			  //move current piece to start
			  GamePiece atOld = board[oldPos].getGamePiece();
			  int playerAtOld = atOld.getPlayer();
			  atOld.setPosition(START_POSITIONS[playerAtOld]);
			  return false;
		  }
	  }
	  return false;
  }
  /**
   * A getter for a player, player number must be between 0 and 3.
   * @param playerNumber The number of the player to return
   * @return The player
   */
  public Player getPlayer(int playerNumber) {
    if (playerNumber >= 0 && playerNumber <= 3) {
      return playerList[playerNumber];
    } else {
      return null;
    }
  }
}
