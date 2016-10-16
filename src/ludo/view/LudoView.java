package ludo.view;

import ludo.model.GamePiece;
import ludo.model.LudoModel;
import ludo.model.Player;

public class LudoView {
  private static final int SINGLE_ARRAY_SIZE = 88;
  private static final int BOARD_SIZE = 15;
  private static final String[][] BOARD_COLORS = new String[][] {
      { "RR", "**", "**", "**", "**", "**", "  ", "  ", "  ", "**", "**", "**", "**", "**", "BB" },
      { "**", "  ", "**", "**", "  ", "**", "**", "**", "  ", "**", "  ", "**", "**", "  ", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**", "**", "**", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**", "**", "**", "**" },
      { "**", "  ", "**", "**", "  ", "**", "  ", "**", "  ", "**", "  ", "**", "**", "  ", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**", "**", "**", "**" },
      { "  ", "  ", "  ", "  ", "  ", "  ", "##", "##", "##", "  ", "  ", "  ", "  ", "**", "  " },
      { "  ", "**", "**", "**", "**", "**", "##", "##", "##", "**", "**", "**", "**", "**", "  " },
      { "  ", "**", "  ", "  ", "  ", "  ", "##", "##", "##", "  ", "  ", "  ", "  ", "  ", "  " },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**", "**", "**", "**" },
      { "**", "  ", "**", "**", "  ", "**", "  ", "**", "  ", "**", "  ", "**", "**", "  ", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**", "**", "**", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**", "**", "**", "**" },
      { "**", "  ", "**", "**", "  ", "**", "  ", "**", "**", "**", "  ", "**", "**", "  ", "**" },
      { "YY", "**", "**", "**", "**", "**", "  ", "  ", "  ", "**", "**", "**", "**", "**",
          "GG" } };

  private Position[] positionMappings;
  private int[][] indexMappings;

  /**
   * Default constructor for LudoView. Creates the variables and triggers the
   * set up of mappings between the LudoModel board and the LudoView diplay.
   */
  public LudoView() {
    positionMappings = new Position[SINGLE_ARRAY_SIZE];
    setPositionMappings();
    setIndexMappings();
  }

  private void setIndexMappings() {
    indexMappings = new int[BOARD_SIZE][BOARD_SIZE];

    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        indexMappings[i][j] = -1;
      }
    }

    for (int i = 0; i < SINGLE_ARRAY_SIZE; i++) {
      indexMappings[positionMappings[i].getPositionX()][positionMappings[i].getPositionY()] = i;
    }

    for (int i = 6; i <= 9; i++) {
      for (int j = 6; j <= 9; j++) {
        indexMappings[i][j] = -2;
      }
    }
  }

  private void setPositionMappings() {
    int currPosition = 0;
    // Set positions 0-5
    for (int i = 1; i <= 5; i++) {
      positionMappings[currPosition] = new Position(i, 6);
      currPosition++;
    }
    // Set positions 5-10
    for (int i = 5; i >= 0; i--) {
      positionMappings[currPosition] = new Position(6, i);
      currPosition++;
    }
    // Set position 11
    positionMappings[currPosition] = new Position(7, 0);
    currPosition++;
    // Set positions 12-17
    for (int i = 0; i <= 5; i++) {
      positionMappings[currPosition] = new Position(8, i);
      currPosition++;
    }
    // Set positions 18-23
    for (int i = 9; i <= 14; i++) {
      positionMappings[currPosition] = new Position(i, 6);
      currPosition++;
    }
    // Set position 24
    positionMappings[currPosition] = new Position(14, 7);
    currPosition++;
    // Set positions 25 - 30
    for (int i = 14; i >= 9; i--) {
      positionMappings[currPosition] = new Position(i, 8);
      currPosition++;
    }
    // Set positions 31-36
    for (int i = 9; i <= 14; i++) {
      positionMappings[currPosition] = new Position(8, i);
      currPosition++;
    }
    // Set position 37
    positionMappings[currPosition] = new Position(7, 14);
    currPosition++;
    // Set positions 38-43
    for (int i = 14; i >= 9; i--) {
      positionMappings[currPosition] = new Position(6, i);
      currPosition++;
    }
    // Set positions 44-49
    for (int i = 5; i >= 0; i--) {
      positionMappings[currPosition] = new Position(i, 8);
      currPosition++;
    }
    // Set position 50
    positionMappings[currPosition] = new Position(0, 7);
    currPosition++;
    // Set position 51
    positionMappings[currPosition] = new Position(0, 6);
    currPosition++;
    // Set positions 52-56
    for (int i = 1; i <= 5; i++) {
      positionMappings[currPosition] = new Position(i, 7);
      currPosition++;
    }
    // Set position 57-61
    for (int i = 1; i <= 5; i++) {
      positionMappings[currPosition] = new Position(7, i);
      currPosition++;
    }
    // Set positions 62-66
    for (int i = 13; i >= 9; i--) {
      positionMappings[currPosition] = new Position(i, 7);
      currPosition++;
    }
    // Set positions 67-71
    for (int i = 13; i >= 9; i--) {
      positionMappings[currPosition] = new Position(7, i);
      currPosition++;
    }

    // Set red player starting positions
    positionMappings[currPosition] = new Position(1, 1);
    currPosition++;
    positionMappings[currPosition] = new Position(1, 4);
    currPosition++;
    positionMappings[currPosition] = new Position(4, 1);
    currPosition++;
    positionMappings[currPosition] = new Position(4, 4);
    currPosition++;

    // Set blue player starting positions
    positionMappings[currPosition] = new Position(10, 1);
    currPosition++;
    positionMappings[currPosition] = new Position(10, 4);
    currPosition++;
    positionMappings[currPosition] = new Position(13, 1);
    currPosition++;
    positionMappings[currPosition] = new Position(13, 4);
    currPosition++;

    // Set green player starting positions
    positionMappings[currPosition] = new Position(10, 10);
    currPosition++;
    positionMappings[currPosition] = new Position(10, 13);
    currPosition++;
    positionMappings[currPosition] = new Position(13, 10);
    currPosition++;
    positionMappings[currPosition] = new Position(13, 13);
    currPosition++;

    // Set yellow player starting positions
    positionMappings[currPosition] = new Position(1, 10);
    currPosition++;
    positionMappings[currPosition] = new Position(1, 13);
    currPosition++;
    positionMappings[currPosition] = new Position(4, 10);
    currPosition++;
    positionMappings[currPosition] = new Position(4, 13);
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
    GamePiece tempGamePiece;

    for (int i = 0; i < 4; i++) {
      tempGamePiece = model.getPlayer(Player.RED).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = positionMappings[tempGamePiece.getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "R" + i;
    }

    for (int i = 0; i < 4; i++) {
      tempGamePiece = model.getPlayer(Player.YELLOW).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = positionMappings[tempGamePiece.getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "Y" + i;
    }

    for (int i = 0; i < 4; i++) {
      tempGamePiece = model.getPlayer(Player.GREEN).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = positionMappings[tempGamePiece.getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "G" + i;
    }

    for (int i = 0; i < 4; i++) {
      tempGamePiece = model.getPlayer(Player.BLUE).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = positionMappings[tempGamePiece.getPosition()];
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] = "B" + i;
    }

    System.out.println("     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14");
    System.out.println("    -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
    for (int y = 0; y < 15; y++) {
      System.out.printf("%2d|", y);
      for (int x = 0; x < 15; x++) {
        if (tempBoard[x][y] != null) {
          System.out.print(" " + tempBoard[x][y]);
        } else {
          System.out.print(" " + BOARD_COLORS[y][x]);
        }
      }
      System.out.println(" |");
    }
    System.out.println("    -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
  }

  public int getIndexMapping(int positionX, int positionY) {
    return indexMappings[positionX][positionY];
  }
}
