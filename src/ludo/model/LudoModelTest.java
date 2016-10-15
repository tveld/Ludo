package ludo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LudoModelTest {
  LudoModel lmodel;

  @Before
  public void init() {
    lmodel = new LudoModel();
  }

  @Test
  public void testConstructor() {
    assertNotNull(lmodel.getPlayer(Player.RED));
    assertNotNull(lmodel.getPlayer(Player.GREEN));
    assertNotNull(lmodel.getPlayer(Player.YELLOW));
    assertNotNull(lmodel.getPlayer(Player.BLUE));
  }

  @Test
  public void testNextPlayerTurn() {
    assertEquals(Player.RED, lmodel.getCurrentPlayer());
    lmodel.nextPlayerTurn();
    assertEquals(Player.BLUE, lmodel.getCurrentPlayer());
    lmodel.nextPlayerTurn();
    assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    lmodel.nextPlayerTurn();
    assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    lmodel.nextPlayerTurn();
    assertEquals(Player.RED, lmodel.getCurrentPlayer());
  }

  @Test
  public void testRollDice() {
    int testRoll0 = lmodel.rollDice();
    int testRoll1 = lmodel.rollDice();
    int testRoll2 = lmodel.rollDice();

    assertTrue(testRoll0 >= 0 && testRoll0 <= 6);
    assertTrue(testRoll1 >= 0 && testRoll1 <= 6);
    assertTrue(testRoll2 >= 0 && testRoll2 <= 6);

    int testRoll3 = lmodel.rollDice();
    int testRoll4 = lmodel.rollDice();
    int testRoll5 = lmodel.rollDice();

    assertTrue(testRoll3 >= 0 && testRoll3 <= 6);
    assertTrue(testRoll4 >= 0 && testRoll4 <= 6);
    assertTrue(testRoll5 >= 0 && testRoll5 <= 6);
  }

  @Test
  public void testGetPlayer() {
    assertNotNull(lmodel.getPlayer(Player.RED));
    assertNotNull(lmodel.getPlayer(Player.GREEN));
    assertNotNull(lmodel.getPlayer(Player.YELLOW));
    assertNotNull(lmodel.getPlayer(Player.BLUE));
    assertNull(lmodel.getPlayer(-1));
    assertNull(lmodel.getPlayer(4));
    assertNull(lmodel.getPlayer(5));
    assertNull(lmodel.getPlayer(6));
  }

}
