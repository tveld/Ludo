package ludo.view;

import ludo.model.GamePiece;
import ludo.model.LudoModel;
import ludo.model.Player;

public class LudoView {
  private static Position[] POSITION_MAPPINGS;
  private static Position[][] START_POSITIONS;
  private static int SINGLE_ARRAY_SIZE = 52;
  private static int BOARD_SIZE = 15;

  private static final String[][] BOARD_COLORS = new String[][] {
      { "rr", "rr", "rr", "rr", "rr", "rr", "  ", "  ", "  ", "yy", "yy", "yy", "yy", "yy", "yy" },
      { "rr", "  ", "rr", "rr", "  ", "rr", "rr", "rr", "  ", "yy", "  ", "yy", "yy", "  ", "yy" },
      { "rr", "rr", "rr", "rr", "rr", "rr", "  ", "rr", "  ", "yy", "yy", "yy", "yy", "yy", "yy" },
      { "rr", "rr", "rr", "rr", "rr", "rr", "  ", "rr", "  ", "yy", "yy", "yy", "yy", "yy", "yy" },
      { "rr", "  ", "rr", "rr", "  ", "rr", "  ", "rr", "  ", "yy", "  ", "yy", "yy", "  ", "yy" },
      { "rr", "rr", "rr", "rr", "rr", "rr", "  ", "rr", "  ", "yy", "yy", "yy", "yy", "yy", "yy" },
      { "  ", "  ", "  ", "  ", "  ", "  ", "HH", "HH", "HH", "  ", "  ", "  ", "  ", "yy", "  " },
      { "  ", "bb", "bb", "bb", "bb", "bb", "HH", "HH", "HH", "yy", "yy", "yy", "yy", "yy", "  " },
      { "  ", "bb", "  ", "  ", "  ", "  ", "HH", "HH", "HH", "  ", "  ", "  ", "  ", "  ", "  " },
      { "bb", "bb", "bb", "bb", "bb", "bb", "  ", "gg", "  ", "gg", "gg", "gg", "gg", "gg", "gg" },
      { "bb", "  ", "bb", "bb", "  ", "bb", "  ", "gg", "  ", "gg", "  ", "gg", "gg", "  ", "gg" },
      { "bb", "bb", "bb", "bb", "bb", "bb", "  ", "gg", "  ", "gg", "gg", "gg", "gg", "gg", "gg" },
      { "bb", "bb", "bb", "bb", "bb", "bb", "  ", "gg", "  ", "gg", "gg", "gg", "gg", "gg", "gg" },
      { "bb", "  ", "bb", "bb", "  ", "bb", "  ", "gg", "gg", "gg", "  ", "gg", "gg", "  ", "gg" },
      { "bb", "bb", "bb", "bb", "bb", "bb", "  ", "  ", "  ", "gg", "gg", "gg", "gg", "gg",
          "gg" } };

  /**
   * Default constructor for LudoView. Creates the variables and triggers the
   * set up of mappings between the LudoModel board and the LudoView diplay.
   */
  public LudoView() {
    POSITION_MAPPINGS = new Position[SINGLE_ARRAY_SIZE];
    START_POSITIONS = new Position[4][4];
    setPositionMappings();
  }

  void setPositionMappings() {
    int currPosition = 0;
    // Set positions 0-5
    for (int i = 1; i <= 5; i++) {
      POSITION_MAPPINGS[currPosition] = new Position(i, 6);
      currPosition++;
    }
    // Set positions 5-10
    for (int i = 5; i >= 0; i--) {
      POSITION_MAPPINGS[currPosition] = new Position(6, i);
      currPosition++;
    }
    // Set position 11
    POSITION_MAPPINGS[currPosition] = new Position(7, 0);
    currPosition++;
    // Set positions 12-17
    for (int i = 0; i <= 5; i++) {
      POSITION_MAPPINGS[currPosition] = new Position(8, i);
      currPosition++;
    }
    // Set positions 18-23
    for (int i = 9; i <= 14; i++) {
      POSITION_MAPPINGS[currPosition] = new Position(i, 6);
      currPosition++;
    }
    // Set position 24
    POSITION_MAPPINGS[currPosition] = new Position(14, 7);
    currPosition++;
    // Set positions 25 - 30
    for (int i = 14; i >= 9; i--) {
      POSITION_MAPPINGS[currPosition] = new Position(i, 8);
      currPosition++;
    }
    // Set positions 31-36
    for (int i = 9; i <= 14; i++) {
      POSITION_MAPPINGS[currPosition] = new Position(8, i);
      currPosition++;
    }
    // Set position 37
    POSITION_MAPPINGS[currPosition] = new Position(7, 14);
    currPosition++;
    // Set positions 38-43
    for (int i = 14; i >= 9; i--) {
      POSITION_MAPPINGS[currPosition] = new Position(6, i);
      currPosition++;
    }
    // Set positions 44-49
    for (int i = 5; i >= 0; i--) {
      POSITION_MAPPINGS[currPosition] = new Position(i, 8);
      currPosition++;
    }
    // Set position 50
    POSITION_MAPPINGS[currPosition] = new Position(0, 7);
    currPosition++;
    // Set position 51
    POSITION_MAPPINGS[currPosition] = new Position(0, 6);

    // Set player starting positions
    START_POSITIONS[Player.RED][0] = new Position(1, 1);
    START_POSITIONS[Player.RED][1] = new Position(1, 4);
    START_POSITIONS[Player.RED][2] = new Position(4, 1);
    START_POSITIONS[Player.RED][3] = new Position(4, 4);

    START_POSITIONS[Player.BLUE][0] = new Position(10, 1);
    START_POSITIONS[Player.BLUE][1] = new Position(10, 4);
    START_POSITIONS[Player.BLUE][2] = new Position(13, 1);
    START_POSITIONS[Player.BLUE][3] = new Position(13, 4);

    START_POSITIONS[Player.YELLOW][0] = new Position(1, 10);
    START_POSITIONS[Player.YELLOW][1] = new Position(1, 13);
    START_POSITIONS[Player.YELLOW][2] = new Position(4, 10);
    START_POSITIONS[Player.YELLOW][3] = new Position(4, 13);

    START_POSITIONS[Player.GREEN][0] = new Position(10, 10);
    START_POSITIONS[Player.GREEN][1] = new Position(10, 13);
    START_POSITIONS[Player.GREEN][2] = new Position(13, 10);
    START_POSITIONS[Player.GREEN][3] = new Position(13, 13);
  }

  /**
   * Creates the mappings from the LudoModel 1D array game board to a 2D array
   * game board to display.
   * 
   * @param model
   *          the LudoModel containing the state to display
   */
  public void printBoard(LudoModel model) {
    String[][] tempBoard = new String[BOARD_SIZE][BOARD_SIZE];
    Position tempPosition = new Position();
    for (int i = 0; i < 4; i++) {
      if (model.getPlayerList()[Player.RED].getGamePiece(i).getPosition() == GamePiece.IN_START) {
        tempPosition = START_POSITIONS[Player.RED][i];
      } else if (model.getPlayerList()[Player.RED].getGamePiece(i)
          .getPosition() != GamePiece.IN_HOME) {
        tempPosition = POSITION_MAPPINGS[model.getPlayerList()[Player.RED].getGamePiece(i)
            .getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "R" + i;
    }

    for (int i = 0; i < 4; i++) {
      if (model.getPlayerList()[Player.YELLOW].getGamePiece(i)
          .getPosition() == GamePiece.IN_START) {
        tempPosition = START_POSITIONS[Player.YELLOW][i];
      } else if (model.getPlayerList()[Player.YELLOW].getGamePiece(i)
          .getPosition() != GamePiece.IN_HOME) {
        tempPosition = POSITION_MAPPINGS[model.getPlayerList()[Player.YELLOW].getGamePiece(i)
            .getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "Y" + i;
    }

    for (int i = 0; i < 4; i++) {
      if (model.getPlayerList()[Player.GREEN].getGamePiece(i).getPosition() == GamePiece.IN_START) {
        tempPosition = START_POSITIONS[Player.GREEN][i];
      } else if (model.getPlayerList()[Player.GREEN].getGamePiece(i)
          .getPosition() != GamePiece.IN_HOME) {
        tempPosition = POSITION_MAPPINGS[model.getPlayerList()[Player.GREEN].getGamePiece(i)
            .getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "G" + i;
    }

    for (int i = 0; i < 4; i++) {
      if (model.getPlayerList()[Player.BLUE].getGamePiece(i).getPosition() == GamePiece.IN_START) {
        tempPosition = START_POSITIONS[Player.BLUE][i];
      } else if (model.getPlayerList()[Player.BLUE].getGamePiece(i)
          .getPosition() != GamePiece.IN_HOME) {
        tempPosition = POSITION_MAPPINGS[model.getPlayerList()[Player.BLUE].getGamePiece(i)
            .getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "B" + i;
    }

    System.out.println(" ------------------------------");
    for (int i = 0; i < 15; i++) {
      System.out.print("|");
      for (int j = 0; j < 15; j++) {
        if (tempBoard[i][j] != null) {
          System.out.print(tempBoard[i][j]);
        } else {
          System.out.print(BOARD_COLORS[i][j]);
        }
      }
      System.out.println("|");
    }
    System.out.println(" ------------------------------");

  }
}
