package ludo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
  
  @Test
  public void testCantMoveFromStartRed1(){
	assertEquals(Player.RED, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.RED], LudoModel.PIECE_ENTER_POSITIONS[Player.RED] + 1, 1) );
  }
  
  @Test
  public void testCantMoveFromStartRed2() {
	assertEquals(Player.RED, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.RED], LudoModel.PIECE_ENTER_POSITIONS[Player.RED] + 2, 2) );
  }
  
  @Test
  public void testCantMoveFromStartRed3() {
	assertEquals(Player.RED, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.RED], LudoModel.PIECE_ENTER_POSITIONS[Player.RED] + 3, 3) );
  }
  
  @Test
  public void testCantMoveFromStartRed4() {
	assertEquals(Player.RED, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.RED], LudoModel.PIECE_ENTER_POSITIONS[Player.RED] + 4, 4) );
  }
  
  @Test
  public void testCantMoveFromStartRed5() {
	assertEquals(Player.RED, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.RED], LudoModel.PIECE_ENTER_POSITIONS[Player.RED] + 5, 5) );
  }
  
  @Test
  public void testCanMoveFromStartRed6() {
	assertEquals(Player.RED, lmodel.getCurrentPlayer());
    assertTrue(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.RED], LudoModel.PIECE_ENTER_POSITIONS[Player.RED] + 6, 6) );
  }
  
  @Test
  public void testCantMoveFromStartBlue1() {
	lmodel.nextPlayerTurn();
	assertEquals(Player.BLUE, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE], LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE] + 1, 1) );
  }
  
  @Test
  public void testCantMoveFromStartBlue2() {
	lmodel.nextPlayerTurn();
	assertEquals(Player.BLUE, lmodel.getCurrentPlayer());	  
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE], LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE] + 2, 2) );
  }
  
  @Test
  public void testCantMoveFromStartBlue3() {
	lmodel.nextPlayerTurn();
	assertEquals(Player.BLUE, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE], LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE] + 3, 3) );
  }
  
  @Test
  public void testCantMoveFromStartBlue4() {
	lmodel.nextPlayerTurn();
	assertEquals(Player.BLUE, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE], LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE] + 4, 4) );
  }
  
  @Test
  public void testCantMoveFromStartBlue5() {
	lmodel.nextPlayerTurn();
	assertEquals(Player.BLUE, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE], LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE] + 5, 5) );
  }
  
  @Test
  public void testCanMoveFromStartBlue6() {
	lmodel.nextPlayerTurn();
	assertEquals(Player.BLUE, lmodel.getCurrentPlayer());
    assertTrue(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE], LudoModel.PIECE_ENTER_POSITIONS[Player.BLUE] + 6, 6) );
  }
  
  @Test
  public void testCantMoveFromStartGreen1() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN], LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN] + 1, 1) );
  }
  
  @Test
  public void testCantMoveFromStartGreen2() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN], LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN] + 2, 2) );
  }
  
  @Test
  public void testCantMoveFromStartGreen3() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN], LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN] + 3, 3) );
  }
  
  @Test
  public void testCantMoveFromStartGreen4() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN], LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN] + 4, 4) );
  }
  
  @Test
  public void testCantMoveFromStartGreen5() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN], LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN] + 5, 5) );
  }
  
  @Test
  public void testCanMoveFromStartGreen6() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.GREEN, lmodel.getCurrentPlayer());
    assertTrue(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN], LudoModel.PIECE_ENTER_POSITIONS[Player.GREEN] + 6, 6) );
  }
  
  @Test
  public void testCantMoveFromStartYellow1() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW], LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW] + 1, 1) );
  }
  
  @Test
  public void testCantMoveFromStartYellow2() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW], LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW] + 2, 2) );
  }
  
  @Test
  public void testCantMoveFromStartYellow3() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW], LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW] + 3, 3) );
  }
  
  @Test
  public void testCantMoveFromStartYellow4() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW], LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW] + 4, 4) );
  }
  
  @Test
  public void testCantMoveFromStartYellow5() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    assertFalse(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW], LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW] + 5, 5) );
  }
  
  @Test
  public void testCanMoveFromStartYellow6() {
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	lmodel.nextPlayerTurn();
	assertEquals(Player.YELLOW, lmodel.getCurrentPlayer());
    assertTrue(lmodel.move(LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW], LudoModel.PIECE_ENTER_POSITIONS[Player.YELLOW] + 6, 6) );
  }
  
 


}
