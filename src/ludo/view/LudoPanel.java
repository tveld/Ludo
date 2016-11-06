package ludo.view;

import ludo.model.GamePiece;
import ludo.model.LudoGame;
import ludo.model.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LudoPanel extends JPanel {
  /**
   * A constant representing the board array size.
   */
  private static final int SINGLE_ARRAY_SIZE = 88;
  /**
   * A constant representing the size of a board size.
   */
  private static final int BOARD_SIZE = 15;
  /**
   * A constant representing the number of players.
   */
  private static final int NUMBER_PLAYERS = 4;
  private static final int BUTTON_SIZE = 65;
  private static final int GUI_SIZE = 600;

  private static final Color RED = Color.RED;
  private static final Color BLUE = Color.BLUE;
  private static final Color GREEN = Color.GREEN;
  private static final Color YELLOW = Color.YELLOW;
  private static final Color WHITE = Color.WHITE;
  private static final Color GRAY = Color.GRAY;

  private static final int[] HOME_POSITIONS = new int[] { 0, 11, 0, 11 };

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
  private static final int NUM_PIECES = 4;
  private static final int NUM_PLAYERS = 4;
  private static final int[] PLAYERS =
      new int[] { Player.RED, Player.BLUE, Player.GREEN, Player.YELLOW };
  private Mapper mapper;
  private JButton[][] board;
  private JButton[] topHome;
  private JButton[] bottomHome;
  private JPanel boardPanel;
  private JMenuBar menu;
  private JMenu file;
  private JMenuItem quit, restart;
  private JFrame gui;
  private ButtonListener buttonListener = new ButtonListener();
  private int fromRow = -1, toRow = -1;
  private int fromCol = -1, toCol = -1;
  private int clickCount = 0;

  public LudoPanel(LudoGame lmodel) {
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

    gui.add(boardPanel);
    gui.pack();
    gui.setSize(GUI_SIZE, GUI_SIZE);
    gui.setVisible(true);

    mapper = new Mapper();
    displayBoard(lmodel);
  }

  /**
   * A method that updates the board.
   * 
   * @param lgame
   *          The ludo model to display
   */
  public void displayBoard(LudoGame lgame) {
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
  }

  private static class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
  }
}
