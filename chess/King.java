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
		boolean isFree= false;
		isFree= Board.hasPiece(i2,j2);

		if (!isFree || Board.getPiece(i2, j2).getColour() != Board.getPiece(i1, j1).getColour()) 
		{

        }
        else 
        {
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
