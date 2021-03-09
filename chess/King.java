package chess;

public class King extends Piece{

	public King(PieceColour p)
	{
		colour= p;
		if (p== PieceColour.WHITE)
		{
			setSymbol("♔");
		}
		
		else if(p== PieceColour.BLACK)
		{
			setSymbol("♚");
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

		if( i1+1 == i2 && j1 == j2)
		{
			return true;
		}
		else if( i1+1 == i2 && j1+1 == j2)
		{
			return true;
		}
		else if( i1 == i2 && j1+1 == j2)
		{
			return true;
		}
		else if( i1-1== i2 && j1+1 == j2)
		{
			return true;
		}
		else if( i1-1 == i2 && j1 == j2)
		{
			return true;
		}
		else if( i1-1 == i2 && j1-1 == j2)
		{
			return true;
		}
		else if( i1 == i2 && j1-1 == j2)
		{
			return true;
		}
		else if( i1+1 == i2 && j1-1 == j2)
		{
			return true;
		}
		else
		{
			System.out.println("Moving too far");
			return false;
		}

	}	
}
