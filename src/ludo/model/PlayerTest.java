package ludo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  Player testPlayer;

  int startPlayerColor = Player.RED;

  @Before
  public void initialize() {
    testPlayer = new Player(0);
  }

  @Test
  public void testPlayerConstructor() {
    assertEquals(startPlayerColor, testPlayer.getPlayerColor());
    assertEquals(0, testPlayer.getGamePiece(0).getPieceNumber());
    assertEquals(1, testPlayer.getGamePiece(1).getPieceNumber());
    assertEquals(2, testPlayer.getGamePiece(2).getPieceNumber());
    assertEquals(3, testPlayer.getGamePiece(3).getPieceNumber());
  }

}
