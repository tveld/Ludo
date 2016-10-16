package ludo.controller;

import java.util.Scanner;

import ludo.model.LudoModel;
import ludo.view.LudoView;



public class LudoController {
  private static final String[] PLAYER_NAMES = new String[] { "Red", "Blue", "Green", "Yellow" };
  private int[][] positionMappings;

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
      System.out.print("Enter X coordinate of destination square: ");
      destinationX = scanner.nextInt();
      System.out.print("Enter Y coordinate of destination square: ");
      destinationY = scanner.nextInt();

      ludoView.printBoard(ludoModel);
    }
    scanner.close();
  }
}
