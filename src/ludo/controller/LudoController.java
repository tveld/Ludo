package ludo.controller;

import ludo.model.LudoGame;
import ludo.view.LudoPanel;
import ludo.view.LudoView;

import java.util.Scanner;

/**
 * A class that implements the controller portion of the MVC design.
 * 
 * @author Katie Mulder
 *
 */
public final class LudoController {
  /**
   * An array of player names.
   */
  private static final String[] PLAYER_NAMES =
      new String[] { "Red", "Blue", "Green", "Yellow" };
  /**
   * A constant representing the number of players.
   */
  private static final int NUMBER_PLAYERS = 4;

  /**
   * A private constructor to make LudoController a utility class.
   */
  private LudoController() {
  }

  /**
   * This class is the controller portion of the MVC.
   * 
   * @param args
   *          command-line arguments
   */
  public static void main(final String[] args) {
    Scanner scanner = new Scanner(System.in);
    LudoGame ludoModel = new LudoGame();
    LudoView ludoView = new LudoView();
    LudoPanel ludoPanel = new LudoPanel(ludoModel);

    ludoView.printBoard(ludoModel);

    int currentPlayer = ludoModel.getCurrentPlayer();
    int pieceToMove;
    int diceRoll = -1;
    boolean invalidMove = false;

    while (!ludoModel.getGameWon()) {
      System.out.println("It is player "
          + PLAYER_NAMES[ludoModel.getCurrentPlayer()] + "'s turn.");
      if (!invalidMove) {
        diceRoll = ludoModel.rollDice();
      }
      System.out.println("Player has rolled a " + diceRoll + ".");
      System.out
          .print("Enter piece number to move (-1 if you can't move a piece): ");
      pieceToMove = scanner.nextInt();

      if (pieceToMove != -1) {

        boolean goodMove;

        if (pieceToMove >= 0 && pieceToMove <= NUMBER_PLAYERS - 1) {

          System.out.println("Piece: " + PLAYER_NAMES[currentPlayer].charAt(0)
              + pieceToMove + " roll: " + diceRoll);
          goodMove = ludoModel.move(ludoModel.getPlayer(currentPlayer)
              .getGamePiece(pieceToMove).getPosition(), diceRoll);
          ludoView.printBoard(ludoModel);
          ludoPanel.displayBoard(ludoModel);
        } else {
          goodMove = false;
        }

        if (!goodMove) {
          System.out.println("Invalid move. Try again.");
          invalidMove = true;
        } else {
          currentPlayer = ludoModel.nextPlayerTurn();
          invalidMove = false;
        }

      } else {
        currentPlayer = ludoModel.nextPlayerTurn();
        invalidMove = false;
      }

    }
    scanner.close();
  }
}
