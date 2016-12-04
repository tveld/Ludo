package ludo.view;

import ludo.model.GamePiece;
import ludo.model.LudoGame;
import ludo.model.Player;

/**
 * A class that represents the view portion of the MVC.
 * 
 * @author Katie Mulder
 *
 */
public class LudoView {
  /**
   * A constant representing the size of a board size.
   */
  private static final int BOARD_SIZE = 15;
  /**
   * A constant representing the number of players.
   */
  private static final int NUMBER_PLAYERS = 4;
  /**
   * A constant string array holding the default values to display.
   */
  private static final String[][] BOARD_COLORS = new String[][] {
      { "RR", "**", "**", "**", "**", "**", "  ", "  ", "  ", "**", "**", "**",
          "**", "**", "BB" },
      { "**", "  ", "**", "**", "  ", "**", "  ", "**", "**", "**", "  ", "**",
          "**", "  ", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**",
          "**", "**", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**",
          "**", "**", "**" },
      { "**", "  ", "**", "**", "  ", "**", "  ", "**", "  ", "**", "  ", "**",
          "**", "  ", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**",
          "**", "**", "**" },
      { "  ", "**", "  ", "  ", "  ", "  ", "##", "##", "##", "  ", "  ", "  ",
          "  ", "  ", "  " },
      { "  ", "**", "**", "**", "**", "**", "##", "##", "##", "**", "**", "**",
          "**", "**", "  " },
      { "  ", "  ", "  ", "  ", "  ", "  ", "##", "##", "##", "  ", "  ", "  ",
          "  ", "**", "  " },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**",
          "**", "**", "**" },
      { "**", "  ", "**", "**", "  ", "**", "  ", "**", "  ", "**", "  ", "**",
          "**", "  ", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**",
          "**", "**", "**" },
      { "**", "**", "**", "**", "**", "**", "  ", "**", "  ", "**", "**", "**",
          "**", "**", "**" },
      { "**", "  ", "**", "**", "  ", "**", "**", "**", "  ", "**", "  ", "**",
          "**", "  ", "**" },
      { "YY", "**", "**", "**", "**", "**", "  ", "  ", "  ", "**", "**", "**",
          "**", "**", "GG" } };
  /**
   * An instance of the mapper class.
   */
  private Mapper mapper;

  /**
   * Default constructor for LudoView. Creates the variables and triggers the
   * set up of mappings between the LudoModel board and the LudoView diplay.
   */
  public LudoView() {
    mapper = new Mapper();
  }

  /**
   * Creates the mappings from the LudoModel 1D array game board to a 2D array
   * game board to display.
   * 
   * @param model
   *          the LudoModel containing the state to display
   */
  public final void printBoard(final LudoGame model) {
    // ludoPanel.displayBoard(model);
    String[][] tempBoard = new String[BOARD_SIZE][BOARD_SIZE];
    Position tempPosition = new Position();
    GamePiece tempGamePiece;

    for (int i = 0; i < NUMBER_PLAYERS; i++) {
      tempGamePiece = model.getPlayer(Player.RED).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = mapper.getPositionMapping(tempGamePiece.getPosition());
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] =
          "R" + i;
    }

    for (int i = 0; i < NUMBER_PLAYERS; i++) {
      tempGamePiece = model.getPlayer(Player.YELLOW).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = mapper.getPositionMapping(tempGamePiece.getPosition());
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] =
          "Y" + i;
    }

    for (int i = 0; i < NUMBER_PLAYERS; i++) {
      tempGamePiece = model.getPlayer(Player.GREEN).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = mapper.getPositionMapping(tempGamePiece.getPosition());
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] =
          "G" + i;
    }

    for (int i = 0; i < NUMBER_PLAYERS; i++) {
      tempGamePiece = model.getPlayer(Player.BLUE).getGamePiece(i);
      if (tempGamePiece.getPosition() != GamePiece.IN_HOME) {
        tempPosition = mapper.getPositionMapping(tempGamePiece.getPosition());
      }
      tempBoard[tempPosition.getPositionX()][tempPosition.getPositionY()] =
          "B" + i;
    }

    System.out.println("     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14");
    System.out.println("    -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
    for (int y = 0; y < BOARD_SIZE; y++) {
      System.out.printf("%2d|", y);
      for (int x = 0; x < BOARD_SIZE; x++) {
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
}
