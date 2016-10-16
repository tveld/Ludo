package ludo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BoardSquareTest {
  int initSquareType = BoardSquare.REGULAR;
  int initPlayersAllowed = Player.ALL;
  int initPosition = 1;

  BoardSquare testBoardSquare;

  @Before
  public void init() {
    testBoardSquare = new BoardSquare(initSquareType, initPlayersAllowed, initPosition);
  }

  @Test
  public void testConstructor() {
    assertEquals(initSquareType, testBoardSquare.getSquareType());
    assertEquals(null, testBoardSquare.getGamePiece());
    assertEquals(initPosition, testBoardSquare.getPosition());
    assertEquals(initPlayersAllowed, testBoardSquare.getPlayersAllowed());
    assertNull(testBoardSquare.getGamePiece());
  }

  @Test
  public void testSetBoardSquare() {
    int expectedSquareType = BoardSquare.SAFE_ADJACENT;
    int expectedPlayersAllowed = Player.GREEN;
    int expectedPosition = 2;

    testBoardSquare.setBoardSquare(expectedSquareType, expectedPlayersAllowed, expectedPosition);
    assertEquals(expectedSquareType, testBoardSquare.getSquareType());
    assertEquals(expectedPlayersAllowed, testBoardSquare.getPlayersAllowed());
    assertEquals(expectedPosition, testBoardSquare.getPosition());
  }
  
  @Test
  public void testSetGamePiece() {
    GamePiece expectedGamePiece = new GamePiece(Player.RED, 0);
    testBoardSquare.setGamePiece(expectedGamePiece);
    assertEquals(expectedGamePiece, testBoardSquare.getGamePiece());
    
    testBoardSquare = new BoardSquare(BoardSquare.SAFE, Player.RED, 0);
    testBoardSquare.setGamePiece(expectedGamePiece);
    assertEquals(expectedGamePiece, testBoardSquare.getGamePiece());
  }
}
