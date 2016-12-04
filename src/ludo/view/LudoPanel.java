package ludo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ludo.model.GamePiece;
import ludo.model.LudoGame;
import ludo.model.Player;

/**
 * This class creates and displays the game. It also contains the control logic.
 * 
 * @author Katie Mulder
 *
 */
public class LudoPanel extends JPanel {
  /**
   * A constant representing the size of a board size.
   */
  private static final int BOARD_SIZE = 15;
  /**
   * The size to display a button as.
   */
  private static final int BUTTON_SIZE = 65;
  /**
   * The size to display the GUI as.
   */
  private static final int GUI_SIZE = 600;
  /**
   * A color constant for red.
   */
  private static final Color RED = Color.RED;
  /**
   * A color constant for blue.
   */
  private static final Color BLUE = Color.BLUE;
  /**
   * A color constant for green.
   */
  private static final Color GREEN = Color.GREEN;
  /**
   * A color constant for yellow.
   */
  private static final Color YELLOW = Color.YELLOW;
  /**
   * A color constant for white.
   */
  private static final Color WHITE = Color.WHITE;
  /**
   * A color constant for light gray.
   */
  private static final Color GRAY = Color.LIGHT_GRAY;
  /**
   * A constant holding the indexes of the home spaces.
   */
  private static final int[] HOME_POSITIONS = new int[] { 0, 11, 0, 11 };
  /**
   * A 2d array holding the coloring of the board squares.
   */
  private static final Color[][] BOARD_COLORS = new Color[][] {
      { RED, RED, RED, RED, RED, RED, WHITE, WHITE, WHITE, BLUE, BLUE, BLUE,
          BLUE, BLUE, BLUE },
      { RED, WHITE, RED, RED, WHITE, RED, WHITE, BLUE, BLUE, BLUE, WHITE, BLUE,
          BLUE, WHITE, BLUE },
      { RED, RED, RED, RED, RED, RED, WHITE, BLUE, WHITE, BLUE, BLUE, BLUE,
          BLUE, BLUE, BLUE },
      { RED, RED, RED, RED, RED, RED, WHITE, BLUE, WHITE, BLUE, BLUE, BLUE,
          BLUE, BLUE, BLUE },
      { RED, WHITE, RED, RED, WHITE, RED, WHITE, BLUE, WHITE, BLUE, WHITE, BLUE,
          BLUE, WHITE, BLUE },
      { RED, RED, RED, RED, RED, RED, WHITE, BLUE, WHITE, BLUE, BLUE, BLUE,
          BLUE, BLUE, BLUE },
      { WHITE, RED, WHITE, WHITE, WHITE, WHITE, GRAY, GRAY, GRAY, WHITE, WHITE,
          WHITE, WHITE, WHITE, WHITE },
      { WHITE, RED, RED, RED, RED, RED, GRAY, GRAY, GRAY, GREEN, GREEN, GREEN,
          GREEN, GREEN, WHITE },
      { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, GRAY, GRAY, GRAY, WHITE,
          WHITE, WHITE, WHITE, GREEN, WHITE },
      { YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, WHITE, YELLOW, WHITE,
          GREEN, GREEN, GREEN, GREEN, GREEN, GREEN },
      { YELLOW, WHITE, YELLOW, YELLOW, WHITE, YELLOW, WHITE, YELLOW, WHITE,
          GREEN, WHITE, GREEN, GREEN, WHITE, GREEN },
      { YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, WHITE, YELLOW, WHITE,
          GREEN, GREEN, GREEN, GREEN, GREEN, GREEN },
      { YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, WHITE, YELLOW, WHITE,
          GREEN, GREEN, GREEN, GREEN, GREEN, GREEN },
      { YELLOW, WHITE, YELLOW, YELLOW, WHITE, YELLOW, YELLOW, YELLOW, WHITE,
          GREEN, WHITE, GREEN, GREEN, WHITE, GREEN },
      { YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, WHITE, WHITE, WHITE,
          GREEN, GREEN, GREEN, GREEN, GREEN, GREEN } };

  private static final long serialVersionUID = 1L;
  /**
   * The number of pieces each player has.
   */
  private static final int NUM_PIECES = 4;
  /**
   * The initial value of the dice when implementing the fast start logic.
   */
  private static final int DICE_START_VALUE = 6;
  /**
   * An array holding the player numbers.
   */
  private static final int[] PLAYERS =
      new int[] { Player.RED, Player.BLUE, Player.GREEN, Player.YELLOW };
  /**
   * The size of the empty borders.
   */
  private static final int BORDER_SIZE = 10;
  /**
   * The amount to add lengthwise to the GUI.
   */
  private static final int GUI_MOD = 200;
  /**
   * The number of rows in the grid.
   */
  private static final int NUM_ROWS_GRID = 3;
  /**
   * An instance of the mapper class.
   */
  private Mapper mapper;
  /**
   * The 2d array of JButtons representing the board.
   */
  private static JButton[][] board;
  /**
   * The JButton allowing a player to pass on a turn.
   */
  private JButton passButton;
  /**
   * The array of spaces to display the pieces in home.
   */
  private JButton[] topHome;
  /**
   * The array of spaces to display the pieces in home.
   */
  private JButton[] bottomHome;
  /**
   * The panel to hold the board buttons.
   */
  private JPanel boardPanel;
  /**
   * The labels holding the messages to the players.
   */
  private JLabel currentPlayerLabel, currentDiceRollLabel, errorMessageLabel;
  /**
   * The JFrame that holds the GUI.
   */
  private JFrame gui;
  /**
   * The listener that triggers events.
   */
  private ButtonListener buttonListener = new ButtonListener();
  /**
   * The instance of the game.
   */
  private LudoGame ludoGame;
  /**
   * A boolean representing if the error message should be displayed.
   */
  private boolean invalidMove = false;
  /**
   * A boolean indicating whether the attempted move was valid.
   */
  private boolean goodMove = true;
  /**
   * The current dice roll.
   */
  private int diceRoll;
  /**
   * A boolean array indicating whether the player has moved in the game.
   */
  private boolean[] firstMove = { true, true, true, true };

  /**
   * The constructor for a LudoPanel.
   */
  public LudoPanel() {
    diceRoll = DICE_START_VALUE;
    ludoGame = new LudoGame();

    gui = new JFrame("Ludo");
    gui.setVisible(true);
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    boardPanel = new JPanel(new GridLayout(BOARD_SIZE + 2, BOARD_SIZE));

    topHome = new JButton[BOARD_SIZE];
    for (int i = 0; i < BOARD_SIZE; i++) {
      topHome[i] = new JButton();
      topHome[i].setBorderPainted(false);
      topHome[i].setBackground(WHITE);
      topHome[i].setSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
      topHome[i].setOpaque(true);
      boardPanel.add(topHome[i]);

    }

    board = new JButton[BOARD_SIZE][BOARD_SIZE];

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        board[row][col] = new JButton();
        board[row][col].setBackground(BOARD_COLORS[row][col]);
        board[row][col].setSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
        board[row][col].addActionListener(buttonListener);
        boardPanel.add(board[row][col]);
        board[row][col].setOpaque(true);
      }
    }

    bottomHome = new JButton[BOARD_SIZE];
    for (int i = 0; i < BOARD_SIZE; i++) {
      bottomHome[i] = new JButton();
      bottomHome[i].setBorderPainted(false);
      bottomHome[i].setBackground(WHITE);
      bottomHome[i].setSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
      boardPanel.add(bottomHome[i]);
      bottomHome[i].setOpaque(true);
    }

    JPanel labelContainer = new JPanel(new GridLayout(NUM_ROWS_GRID, 1));
    errorMessageLabel = new JLabel();
    currentDiceRollLabel = new JLabel();
    currentPlayerLabel = new JLabel();

    labelContainer.add(errorMessageLabel);
    labelContainer.add(currentPlayerLabel);
    labelContainer.add(currentDiceRollLabel);

    JPanel buttonPanel = new JPanel();
    passButton = new JButton("Pass");
    passButton.addActionListener(buttonListener);
    buttonPanel.add(passButton);

    JPanel controlPanel = new JPanel(new BorderLayout());
    controlPanel.add(labelContainer, BorderLayout.CENTER);
    controlPanel.add(buttonPanel, BorderLayout.EAST);
    controlPanel.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE,
        BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));

    JPanel container = new JPanel(new BorderLayout());
    container.add(boardPanel, BorderLayout.CENTER);
    container.add(controlPanel, BorderLayout.SOUTH);
    container.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE,
        BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
    container.setBackground(Color.WHITE);

    gui.add(container);
    gui.pack();
    gui.setSize(GUI_SIZE, GUI_SIZE + GUI_MOD);
    gui.setResizable(true);
    gui.setVisible(true);

    mapper = new Mapper();
    displayBoard(ludoGame);
  }

  /**
   * A method that updates the board.
   * 
   * @param lgame
   *          The ludo model to display
   */
  public final void displayBoard(final LudoGame lgame) {
    if (lgame.getGameWon()) {
      JOptionPane.showMessageDialog(null,
          "Player " + lgame.getWinningPlayer() + " Wins!");
    } else {
      for (int i = 0; i < BOARD_SIZE; i++) {
        topHome[i].setDisabledIcon(null);
        bottomHome[i].setDisabledIcon(null);
        topHome[i].setIcon(null);
        topHome[i].setEnabled(false);
        bottomHome[i].setIcon(null);
        bottomHome[i].setEnabled(false);
        for (int j = 0; j < BOARD_SIZE; j++) {
          board[i][j].setDisabledIcon(null);
          board[i][j].setIcon(null);
          board[i][j].setEnabled(false);
        }
      }
    }
    for (int x : PLAYERS) {
      for (int i = 0; i < NUM_PIECES; i++) {
        GamePiece tempPiece = lgame.getPlayer(x).getGamePiece(i);
        if (tempPiece.getPosition() == GamePiece.IN_HOME) {
          if (x == Player.RED || x == Player.BLUE) {
            topHome[HOME_POSITIONS[x] + i].setIcon(tempPiece.getIcon());
          } else {
            bottomHome[HOME_POSITIONS[x] + i].setIcon(tempPiece.getIcon());
          }
        } else {
          board[mapper.getPositionMapping(tempPiece.getPosition())
              .getPositionY()][mapper
                  .getPositionMapping(tempPiece.getPosition()).getPositionX()]
                      .setDisabledIcon(tempPiece.getIcon());
          board[mapper.getPositionMapping(tempPiece.getPosition())
              .getPositionY()][mapper
                  .getPositionMapping(tempPiece.getPosition()).getPositionX()]
                      .setIcon(tempPiece.getIcon());
          board[mapper.getPositionMapping(tempPiece.getPosition())
              .getPositionY()][mapper
                  .getPositionMapping(tempPiece.getPosition()).getPositionX()]
                      .setEnabled(true);
        }
      }
    }
    switch (ludoGame.getCurrentPlayer()) {
      case Player.RED:
        currentPlayerLabel.setText("It is Player Red's turn.");
        break;
      case Player.BLUE:
        currentPlayerLabel.setText("It is Player Blue's turn.");
        break;
      case Player.GREEN:
        currentPlayerLabel.setText("It is Player Green's turn.");
        break;
      case Player.YELLOW:
        currentPlayerLabel.setText("It is Player Yellow's turn.");
        break;
      default:
        break;
    }

    if (invalidMove) {
      errorMessageLabel
          .setText("Invalid move. Please choose another move or 'Pass'");
    } else {
      errorMessageLabel.setText("");
    }
    currentDiceRollLabel
        .setText("Please choose a piece to move " + diceRoll + " spaces.");
    if (ludoGame.getGameWon()) {
      currentDiceRollLabel.setText("");
      currentPlayerLabel.setText("");
      errorMessageLabel.setText("");
      JOptionPane.showMessageDialog(gui,
          "Player " + ludoGame.getWinningPlayer() + " has won!");
    }
  }

  /**
   * An inner class that handles the action events in the GUI.
   * 
   * @author Katie Mulder
   */
  private class ButtonListener implements ActionListener {

    /**
     * The method triggered when a button is clicked.
     * 
     * @param e The event that triggered the method.
     */
    public void actionPerformed(final ActionEvent e) {
      int currentPlayer = ludoGame.getCurrentPlayer();

      // pass: next player, roll dice, display board
      if (e.getSource() == passButton) {
        ludoGame.nextPlayerTurn();
        diceRoll = ludoGame.rollDice();
        invalidMove = false;
        displayBoard(ludoGame);

        // other button is pressed
      } else {
        for (int x : PLAYERS) {
          for (int i = 0; i < NUM_PIECES; i++) {
            GamePiece piece = ludoGame.getPlayer(x).getGamePiece(i);
            if (piece.getPosition() == GamePiece.IN_HOME) {
              continue;
            }
            Position pos = mapper.getPositionMapping(piece.getPosition());

            if (e
                .getSource() == board[pos.getPositionY()][pos.getPositionX()]) {
              goodMove =
                  ludoGame.move(mapper.getIndexMapping(pos.getPositionY(),
                      pos.getPositionX()), diceRoll);

              // move complete: next player, roll dice, display board
              if (goodMove) {
                invalidMove = false;
                ludoGame.nextPlayerTurn();
                if (firstMove[ludoGame.getCurrentPlayer()]) {
                  diceRoll = DICE_START_VALUE;
                } else {
                  diceRoll = ludoGame.rollDice();
                }
                displayBoard(ludoGame);
                firstMove[currentPlayer] = false;
                // set invalid to true, display board
              } else {
                invalidMove = true;
                displayBoard(ludoGame);
              }
            }
          }
        }
      }
      displayBoard(ludoGame);
    }
  }
}
