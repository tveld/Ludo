package ludo.view;

import ludo.model.*;

public class LudoView {
	private static Position[] POSITION_MAPPINGS;
	private static int SINGLE_ARRAY_SIZE = 52;
	private static int BOARD_SIZE = 15;
	private static SquareColors[][] SQUARE_COLORS;

	public LudoView() {
		POSITION_MAPPINGS = new Position[52];
		SQUARE_COLORS = new SquareColors[15][15];
		setSquareColors();
		setPositionMappings();
	}

	private void setPositionMappings() {

	}

	private void setSquareColors() {
		// Set up the square colors to display
		for (int i = 0; i < 15; i++) {
			for (int j = 0; i < 15; j++) {
				if (i <= 5 && j <= 5) {
					SQUARE_COLORS[i][j] = SquareColors.RED;
				} else if (i >= 9 && j <= 5) {
					SQUARE_COLORS[i][j] = SquareColors.BLUE;
				} else if (i >= 9 && j >= 9) {
					SQUARE_COLORS[i][j] = SquareColors.GREEN;
				} else if (i <= 5 && j >= 9) {
					SQUARE_COLORS[i][j] = SquareColors.YELLOW;
				} else if (i >=6 && i <=8 && j >=6 && j <=8) {
					SQUARE_COLORS[i][j] = SquareColors.PURPLE;
				} else {
					SQUARE_COLORS[i][j] = SquareColors.WHITE;
				}
			}
		}
		SQUARE_COLORS[1][6] = SquareColors.RED;
		for (int i = 1; i <= 5; i++) {
			SQUARE_COLORS[i][7] = SquareColors.RED;
		}
		SQUARE_COLORS[13][8] = SquareColors.GREEN;
		for (int i = 9; i <= 14; i++) {
			SQUARE_COLORS[i][7] = SquareColors.GREEN;
		}
		SQUARE_COLORS[8][1] = SquareColors.BLUE;
		for(int i = 1; i<=5; i++){
			SQUARE_COLORS[7][i] = SquareColors.BLUE;
		}
		SQUARE_COLORS[6][13] = SquareColors.BLUE;
		for(int i = 9; i<=13; i++){
			SQUARE_COLORS[7][i] = SquareColors.BLUE;
		}
	}

	public void printBoard(BoardSquare[] board) {

	}
}
