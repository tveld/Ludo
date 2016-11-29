package ludo.view;

/**
 * A class that represents a position.
 * 
 * @author Katie Mulder
 *
 */
public class Position {
  /**
   * The default value of a position.
   */
  private static final int DEFAULT_VALUE = -1;
  /**
   * The x coordinate of the position.
   */
  private int positionX;
  /**
   * The y coordinate of the position.
   */
  private int positionY;

  /**
   * A default constructor for a position.
   */
  public Position() {
    positionX = DEFAULT_VALUE;
    positionY = DEFAULT_VALUE;
  }

  /**
   * Create a Position with the specified values.
   * 
   * @param paramPositionX
   *          The X position
   * @param paramPositionY
   *          The Y position
   */
  public Position(final int paramPositionX, final int paramPositionY) {
    positionX = paramPositionX;
    positionY = paramPositionY;
  }

  /**
   * Setter for PositionX and PositionY.
   * 
   * @param paramPositionX
   *          The value to set as positionX
   * @param paramPositionY
   *          The value to set as positionY
   */
  public final void setPositionXandY(final int paramPositionX,
      final int paramPositionY) {
    positionX = paramPositionX;
    positionY = paramPositionY;
  }

  /**
   * The getter for positionX.
   *
   * @return the positionX
   */
  public final int getPositionX() {
    return positionX;
  }

  /**
   * The setter for positionX.
   *
   * @param paramPositionX
   *          the positionX to set
   */
  public final void setPositionX(final int paramPositionX) {
    this.positionX = paramPositionX;
  }

  /**
   * The getter for positionY.
   *
   * @return the positionY
   */
  public final int getPositionY() {
    return positionY;
  }

  /**
   * The setter for positionY.
   *
   * @param paraPositionY
   *          the positionY to set
   */
  public final void setPositionY(final int paraPositionY) {
    this.positionY = paraPositionY;
  }
}
