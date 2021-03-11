package chess;

public class Rook extends Piece{

	public Rook(PieceColour p)
	{
		colour= p;
		if (p== PieceColour.WHITE)
		{
			setSymbol("♖");

		}
		
		else if(p== PieceColour.BLACK)
		{
			setSymbol("♜");
		}
	}

	@Override
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

		//calc direction 
		int rowDiff= i2- i1;
		int columnDiff= j2-j1;
		int rowIncrementPerStep;
		int columnIncrementPerStep;


		if(rowDiff == 0 && columnDiff > 0)
			{
			// right
			rowIncrementPerStep=0;
			columnIncrementPerStep=1;
			}
		else if(rowDiff == 0 && columnDiff < 0)
		{
			// left
			rowIncrementPerStep=0;
			columnIncrementPerStep= -1;
			
		}
		else if(rowDiff < 0 && columnDiff == 0)
		{
			// up
			rowIncrementPerStep= -1;
			columnIncrementPerStep=0;

		}
		else if(rowDiff > 0 && columnDiff == 0)
		{
			// down
			rowIncrementPerStep= +1;
			columnIncrementPerStep=0;
		
		}
		else
		{
			// not moving diagonally
			return false;
		}

		
		int currentRow = i1 + rowIncrementPerStep;
		int currentColumn = j1 + columnIncrementPerStep;
		while(true)
		{
			if(currentRow == i2 && currentColumn == j2){
				break;
			}
			if(Board.hasPiece(currentRow, currentColumn))
			{
				if(currentRow == i2 && currentColumn == j2)
				{
					break;
				}
				else{
					return false;
				}
				
			}

			currentRow += rowIncrementPerStep;
			currentColumn += columnIncrementPerStep;
		}
		return true;
	}	
}
