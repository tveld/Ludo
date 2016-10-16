package ludo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GamePieceTest {
  GamePiece testGamePiece;
  Player testPlayer;
  LudoModel testModel;

  int startPlayerColor = Player.RED;
  int startPieceNumber = 0;

  @Before
  public void initialize() {
    testGamePiece = new GamePiece(Player.RED, 0);
  }

  @Test
  public void testGamePieceConstructor() {
    int expectedPosition = GamePiece.IN_START;
    assertEquals(startPlayerColor, testGamePiece.getPlayer());
    assertEquals(startPieceNumber, testGamePiece.getPieceNumber());
    assertEquals(expectedPosition, testGamePiece.getPosition());
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
