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
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LudoModel ludoModel = new LudoModel();
		LudoView ludoView = new LudoView();

		ludoView.printBoard(ludoModel);

		int currentPlayer = ludoModel.getCurrentPlayer();
		int pieceToMove;
		int diceRoll = -1;
		boolean invalidMove = false;

		while (ludoModel.getGameWon() == false) {
			System.out.println("It is player " + PLAYER_NAMES[ludoModel.getCurrentPlayer()] + "'s turn.");
			if (invalidMove == false) {
				diceRoll = ludoModel.rollDice();
			}
			System.out.println("Player has rolled a " + diceRoll + ".");
			System.out.print("Enter piece number to move (-1 if you can't move a piece): ");
			pieceToMove = scanner.nextInt();

			if (pieceToMove != -1) {

				boolean goodMove;

				if (pieceToMove >= 0 && pieceToMove <= 3) {

					System.out.println(
							"Piece: " + PLAYER_NAMES[currentPlayer].charAt(0) + pieceToMove + " roll: " + diceRoll);
					goodMove = ludoModel
							.move(ludoModel.getPlayer(currentPlayer).getGamePiece(pieceToMove).getPosition(), diceRoll);
					ludoView.printBoard(ludoModel);
				} else {
					goodMove = false;
				}
				
				if (goodMove == false) {
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
