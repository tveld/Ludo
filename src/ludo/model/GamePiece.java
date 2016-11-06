package ludo.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import sun.awt.IconInfo;

/**
 * This class contains variables and methods used to represent a Game Piece.
 * 
 * @author Katie Mulder
 *
 */
public class GamePiece {
  /**
   * The position value for a piece that is in home.
   */
  public static final int IN_HOME = -2;
  /**
   * The value of a piece with an unassigned position.
   */
  private static final int UNASSIGNED_POSITION = -99;
  /**
   * The player number that the piece belongs to.
   */
  private int player;
  /**
   * The number of this piece.
   */
  private int pieceNumber;
  /**
   * The position of this piece on the board.
   */
  private int position;
  
  private ImageIcon icon;

  /**
   * Constructor that creates a GamePiece with the specified values.
   * 
   * @param paramPlayerColor
   *          The player that this GamePiece belongs to.
   * @param paramPieceNumber
   *          The number of this GamePiece
   */
  public GamePiece(final int paramPlayerColor, final int paramPieceNumber, String iconName) {
    player = paramPlayerColor;
    this.position = UNASSIGNED_POSITION;
    this.pieceNumber = paramPieceNumber;
    this.icon = new ImageIcon(iconName);
  }
  
  /**
   * Constructor that creates a GamePiece with the specified values.
   * 
   * @param paramPlayerColor
   *          The player that this GamePiece belongs to.
   * @param paramPieceNumber
   *          The number of this GamePiece
   */
  public GamePiece(final int paramPlayerColor, final int paramPieceNumber) {
    player = paramPlayerColor;
    this.position = UNASSIGNED_POSITION;
    this.pieceNumber = paramPieceNumber;
  }

  /**
   * The getter for player.
   *
   * @return the player
   */
  public final int getPlayer() {
    return player;
  }

  /**
   * The getter for pieceNumber.
   *
   * @return the pieceNumber
   */
  public final int getPieceNumber() {
    return pieceNumber;
  }

  /**
   * The getter for position.
   *
   * @return the position
   */
  public final int getPosition() {
    return position;
  }

  /**
   * The setter for position.
   *
   * @param paramPosition
   *          the position to set
   */
  public final void setPosition(final int paramPosition) {
    this.position = paramPosition;
  }

  public ImageIcon getIcon() {
    return icon;
  }
}
