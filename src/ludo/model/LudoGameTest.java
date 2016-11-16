package ludo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LudoGameTest {
  LudoGame lgame;

  @Before
  public void init() {
    lgame = new LudoGame();
  }

  @Test
  public void testConstructor() {
    assertNotNull(lgame.getPlayer(Player.RED));
    assertNotNull(lgame.getPlayer(Player.GREEN));
    assertNotNull(lgame.getPlayer(Player.YELLOW));
    assertNotNull(lgame.getPlayer(Player.BLUE));
  }

  @Test
  public void testNextPlayerTurn() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    lgame.nextPlayerTurn();
    assertEquals(Player.RED, lgame.getCurrentPlayer());
  }

  @Test
  public void testRollDice() {
    int testRoll0 = lgame.rollDice();
    int testRoll1 = lgame.rollDice();
    int testRoll2 = lgame.rollDice();

    assertTrue(testRoll0 >= 0 && testRoll0 <= 6);
    assertTrue(testRoll1 >= 0 && testRoll1 <= 6);
    assertTrue(testRoll2 >= 0 && testRoll2 <= 6);

    int testRoll3 = lgame.rollDice();
    int testRoll4 = lgame.rollDice();
    int testRoll5 = lgame.rollDice();

    assertTrue(testRoll3 >= 0 && testRoll3 <= 6);
    assertTrue(testRoll4 >= 0 && testRoll4 <= 6);
    assertTrue(testRoll5 >= 0 && testRoll5 <= 6);
  }

  @Test
  public void testGetPlayer() {
    assertNotNull(lgame.getPlayer(Player.RED));
    assertNotNull(lgame.getPlayer(Player.GREEN));
    assertNotNull(lgame.getPlayer(Player.YELLOW));
    assertNotNull(lgame.getPlayer(Player.BLUE));
    assertNull(lgame.getPlayer(-1));
    assertNull(lgame.getPlayer(4));
    assertNull(lgame.getPlayer(5));
    assertNull(lgame.getPlayer(6));
  }

  @Test
  public void testCantMoveFromStartRed1() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.RED], 1));
  }

  @Test
  public void testCantMoveFromStartRed2() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.RED], 2));
  }

  @Test
  public void testCantMoveFromStartRed3() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.RED], 3));
  }

  @Test
  public void testCantMoveFromStartRed4() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.RED], 4));
  }

  @Test
  public void testCantMoveFromStartRed5() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.RED], 5));
  }

  @Test
  public void testCanMoveFromStartRed6() {
    assertEquals(Player.RED, lgame.getCurrentPlayer());
    assertTrue(lgame.move(LudoGame.START_POSITIONS[Player.RED], 6));
  }

  @Test
  public void testCantMoveFromStartBlue1() {
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.BLUE], 1));
  }

  @Test
  public void testCantMoveFromStartBlue2() {
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.BLUE], 2));
  }

  @Test
  public void testCantMoveFromStartBlue3() {
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.BLUE], 3));
  }

  @Test
  public void testCantMoveFromStartBlue4() {
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.BLUE], 4));
  }

  @Test
  public void testCantMoveFromStartBlue5() {
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.BLUE], 5));
  }

  @Test
  public void testCanMoveFromStartBlue6() {
    lgame.nextPlayerTurn();
    assertEquals(Player.BLUE, lgame.getCurrentPlayer());
    assertTrue(lgame.move(LudoGame.START_POSITIONS[Player.BLUE], 6));
  }

  @Test
  public void testCantMoveFromStartGreen1() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.GREEN], 1));
  }

  @Test
  public void testCantMoveFromStartGreen2() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.GREEN], 2));
  }

  @Test
  public void testCantMoveFromStartGreen3() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.GREEN], 3));
  }

  @Test
  public void testCantMoveFromStartGreen4() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.GREEN], 4));
  }

  @Test
  public void testCantMoveFromStartGreen5() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.GREEN], 5));
  }

  @Test
  public void testCanMoveFromStartGreen6() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.GREEN, lgame.getCurrentPlayer());
    assertTrue(lgame.move(LudoGame.START_POSITIONS[Player.GREEN], 6));
  }

  @Test
  public void testCantMoveFromStartYellow1() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 1));
  }

  @Test
  public void testCantMoveFromStartYellow2() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 2));
  }

  @Test
  public void testCantMoveFromStartYellow3() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 3));
  }

  @Test
  public void testCantMoveFromStartYellow4() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 4));
  }

  @Test
  public void testCantMoveFromStartYellow5() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 5));
  }

  @Test
  public void testCanMoveFromStartYellow6() {
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    assertEquals(Player.YELLOW, lgame.getCurrentPlayer());
    assertTrue(lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 6));
  }

  @Test
  public void testMoveFromStartTwice() {
    lgame.move(LudoGame.START_POSITIONS[Player.RED], 6);
    assertFalse(lgame.move(LudoGame.START_POSITIONS[Player.RED] + 1, 6));

  }

  @Test
  public void testMoveIntoOccupied() {
    lgame.move(LudoGame.START_POSITIONS[Player.RED], 6);
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();
    lgame.nextPlayerTurn();

    lgame.move(LudoGame.START_POSITIONS[Player.YELLOW], 6);
    assertTrue(lgame.move(LudoGame.PIECE_ENTER_POSITIONS[Player.YELLOW], 13));

  }
  
  @Test
  public void testMovePassedHome() {
	  lgame.move(LudoGame.START_POSITIONS[Player.RED], 6);
	  lgame.move(LudoGame.PIECE_ENTER_POSITIONS[Player.RED], 50);
	  lgame.move(lgame.getPlayer(Player.RED).getGamePiece(0).getPosition(), 3);
	  assertFalse(lgame.move(lgame.getPlayer(Player.RED).getGamePiece(0).getPosition(), 6));
  }

  @Test
  public void testWin() {
    lgame.move(LudoGame.START_POSITIONS[Player.RED], 6);
    assertFalse(lgame.getGameWon());
    lgame.getPlayer(Player.RED).getGamePiece(0).setPosition(GamePiece.IN_HOME);
    assertFalse(lgame.getGameWon());
    lgame.getPlayer(Player.RED).getGamePiece(1).setPosition(GamePiece.IN_HOME);
    assertFalse(lgame.getGameWon());
    lgame.getPlayer(Player.RED).getGamePiece(2).setPosition(GamePiece.IN_HOME);
    assertFalse(lgame.getGameWon());
    lgame.getPlayer(Player.RED).getGamePiece(3).setPosition(GamePiece.IN_HOME);
    assertTrue(lgame.getGameWon());
  }

}
