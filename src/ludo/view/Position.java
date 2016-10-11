package ludo.view;

public class Position {
  private int positionX;
  private int positionY;

  public Position() {
    positionX = positionY = -1;
  }

  /**
   * Create a Position with the specified values.
   * 
   * @param paramPositionX The X position
   * @param paramPositionY The Y position
   */
  public Position(int paramPositionX, int paramPositionY) {
    positionX = paramPositionX;
    positionY = paramPositionY;
  }

  /**
   * Setter for PositionX and PositionY.
   * 
   * @param paramPositionX The value to set as positionX
   * @param paramPositionY The value to set as positionY 
   */
  public void setPositionXandY(int paramPositionX, int paramPositionY) {
    positionX = paramPositionX;
    positionY = paramPositionY;
  }

  /**
   * The getter for positionX.
   *
   * @return the positionX
   */
  public int getPositionX() {
    return positionX;
  }

  /**
   * The setter for positionX.
   *
   * @param positionX the positionX to set
   */
  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  /**
   * The getter for positionY.
   *
   * @return the positionY
   */
  public int getPositionY() {
    return positionY;
  }

  /**
   * The setter for positionY.
   *
   * @param positionY the positionY to set
   */
  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }
}
