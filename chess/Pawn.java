package chess;

public class Pawn extends Piece
{

	public Pawn(PieceColour p)
	{
		colour= p;
		if (p== PieceColour.WHITE)
		{
			setSymbol("♙");
		}
		
		else if(p== PieceColour.BLACK)
		{
			setSymbol("♟︎");
		}
	}

	public Boolean isLegitMove(int i1, int j1, int i2, int j2)
	{
		boolean isCapturable= false;
		boolean isFree= false;
		Piece targetPiece= Board.getPiece(i2,j2);

		//checks if square is free
		isFree= Board.hasPiece(i2,j2);

		//cehck for legit move
		if(!isFree)
		{
			if( j1 == j2)
			{
				// same column
				if(colour == PieceColour.WHITE)
				{
					// white
					if((i1-1 == i2) || (i1==6 && i1-2==i2))
					{
						// move one up
						return true;
					}
					else
					{
						System.out.println("not moving one up");
						return false;
					}
				}
				else
				{
					// black
					if((i1+1 == i2) || (i1==1 && i1+2==i2))
					{
						// move one down
						return true;
					}
					else
					{
						System.out.println("not moving one down");
						return  false;
					}
				}
			}
			else
			{
				// not the same column
				System.out.println("not staying in same column");
				return false;
			}


		}
		else if(Board.getPiece(i2, j2).getColour() != Board.getPiece(i1, j1).getColour())
		{
			if( j1+1 == j2 || j1-1 == j2)
			{
				// one column to the right or left
				if(colour == PieceColour.WHITE )
				{
					// white
					if( i1-1 == i2 )
					{
						// move one up
						return true;
					}
					else
					{
						System.out.println("not moving one down");
						return false;
					}
				}
				else
				{
					// black
					if( i1+1 == i2 )
					{
						// move one down
						return true;
					}
					else
					{
						System.out.println("not moving one up");
						return false;
					}
				}
			}
		}
		else
		{
			//not legit move
			System.out.println("Target square not free or capturable");
			return false;
		}

		return false;

	}	
	
}
