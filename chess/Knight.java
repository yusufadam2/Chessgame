package chess;

public class Knight extends Piece{

	public Knight(PieceColour p)
	{
		colour= p;
		if (p== PieceColour.WHITE)
		{
			setSymbol("♘");
		}
		
		else if(p== PieceColour.BLACK)
		{
			setSymbol("♞");
		}
	}

	public Boolean isLegitMove(int i1, int j1, int i2, int j2)
	{
		boolean isCapturable= false;
		boolean isFree= false;
		Piece targetPiece= Board.getPiece(i2,j2);

		//checks if square is free
		isFree= Board.hasPiece(i2,j2);

		//checks if square is capturable
		if((targetPiece.getColour()!= colour) && (isFree== false))
		{
			isCapturable= true;
		}
		else
		{
			isCapturable= false;
		}

		//cehck for legit move
		if(isFree || isCapturable)
		{
			//pass
		}
		else
		{
			//not legit move
			System.out.println("Target square not free or capturable");
			return false;
		}

		if( i1+2 == i2 && j1+1 == j2)
		{
			// move up up right
			return true;
		}
		else if( i1+1 == i2 && j1+2 == j2)
		{
			// move up right right
			return true;
		}
		else if( i1-1 == i2 && j1+2 == j2)
		{
			// move down right right
			return true;
		}
		else if( i1-2 == i2 && j1+1 == j2)
		{
			// move down down right
			return true;
		}
		else if( i1-2 == i2 && j1-1 == j2)
		{
			// move down down left
			return true;
		}
		else if( i1-1 == i2 && j1-2 == j2)
		{
			// move down left left
			return true;
		}
		else if( i1+1 == i2 && j1-2 == j2)
		{
			// move up left left
			return true;
		}
		else if( i1+2 == i2 && j1-1 == j2)
		{
			// move up up left
			return true;
		}
		else
		{
			System.out.println("Invalid move pattern");
			return false;
		}
	}	

}
