package chess;

public class Queen extends Piece{

	public Queen(PieceColour p)
	{
		if (p== PieceColour.WHITE)
		{
			setSymbol("♕");
		}
		
		else if(p== PieceColour.BLACK)
		{
			setSymbol("♛");
		}
	}

	public Boolean isLegitMove(int i1, int j1, int i2, int j2)
	{

	}	

}
