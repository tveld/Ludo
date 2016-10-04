package ludo;

class BoardSquare {
	BoardSquareType squareType;
	Players playersAllowed;
	
	public BoardSquare (BoardSquareType pSquareType, Players pPlayersAllowed){
		squareType = pSquareType;
		playersAllowed = pPlayersAllowed;
	}

}
