package ludo.controller;

import ludo.model.LudoModel;
import ludo.view.LudoView;

import java.util.Scanner;



public class LudoController {
  private static final String[] PLAYER_NAMES = new String[] { "Red", "Blue", "Green", "Yellow" };

  /**
   * This class is the controller portion of the MVC.
   * 
   * @param args
   *          command-line arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LudoModel ludoModel = new LudoModel();
    LudoView ludoView = new LudoView();

    ludoView.printBoard(ludoModel);

    int currentPlayer = ludoModel.getCurrentPlayer();
    int pieceToMove;
    int diceRoll;
    int destinationX;
    int destinationY;

    while (ludoModel.getGameWon() == false) {
      System.out.println("It is player " + PLAYER_NAMES[ludoModel.getCurrentPlayer()] + "'s turn.");
      diceRoll = ludoModel.rollDice();
      System.out.println("Player has rolled a " + diceRoll + ".");
      System.out.print("Enter piece number to move: ");
      pieceToMove = scanner.nextInt();
      while (!(pieceToMove == 0 || pieceToMove == 1 || pieceToMove == 2 || pieceToMove == 3)) {
        System.out.print("Invalid piece number. Try again: ");
        pieceToMove = scanner.nextInt();
      }
      System.out.print("Enter X coordinate of destination square: ");
      destinationX = scanner.nextInt();
      while (destinationX < 0 || destinationX > 14) {
        System.out.print("Invalid x-coordinate. Try again: ");
        destinationX = scanner.nextInt();
      }
      System.out.print("Enter Y coordinate of destination square: ");
      destinationY = scanner.nextInt();
      while (destinationY < 0 || destinationY > 14) {
        System.out.print("Invalid y-coordinate. Try again: ");
        destinationY = scanner.nextInt();
      }

      System.out.println("Piece: " + PLAYER_NAMES[currentPlayer].charAt(0) + pieceToMove + " roll: "
          + diceRoll + " destination (" + destinationX + " , " + destinationY + ") index "
          + ludoView.getIndexMapping(destinationX, destinationY) + "\n");
      boolean goodMove = ludoModel.move(
          ludoModel.getPlayer(currentPlayer).getGamePiece(pieceToMove).getPosition(),
          ludoView.getIndexMapping(destinationX, destinationY), diceRoll);
      ludoView.printBoard(ludoModel);
      if (goodMove == false) {
        System.out.println("Invalid move. Try again.");
      } else {
        currentPlayer = ludoModel.nextPlayerTurn();
      }
    }
    scanner.close();
  }
}
