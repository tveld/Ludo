package ludo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GamePieceTest {
  GamePiece testGamePiece;

  int startPlayerColor = Player.RED;
  int startPieceNumber = 0;

  @Before
  public void initialize() {
    testGamePiece = new GamePiece(Player.RED, 0);
  }

  @Test
  public void testGamePieceConstructor() {
    assertEquals(startPlayerColor, testGamePiece.getPlayer());
    assertEquals(startPieceNumber, testGamePiece.getPieceNumber());
  }

  @Test
  public void testGamePieceGetPlayer() {
    assertEquals(startPlayerColor, testGamePiece.getPlayer());
  }

  @Test
  public void testGamePieceGetPieceNumber() {
    assertEquals(startPieceNumber, testGamePiece.getPieceNumber());
  }
}
