package chess;

public class Queen extends Piece{

	public Queen(PieceColour p)
	{
		colour= p;
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
		Rook queen1= new Rook(colour);
		Bishop queen2= new Bishop(colour);
		boolean q1= queen1.isLegitMove(i1, j1, i2, j2);
		boolean q2= queen2.isLegitMove(i1, j1, i2, j2);

		return q1 || q2;
	}	

}
