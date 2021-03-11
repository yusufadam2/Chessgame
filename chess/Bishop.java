package chess;

public class Bishop extends Piece{

	public Bishop(PieceColour p)
	{
		colour= p;
		if (p== PieceColour.WHITE)
		{
			setSymbol("♗");
		}
		
		else if(p== PieceColour.BLACK)
		{
			setSymbol("♝");
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

		//calc direction 
		int rowDiff= i2- i1;
		int columnDiff= j2-j1;
		int rowIncrementPerStep;
		int columnIncrementPerStep;


		if(rowDiff == -columnDiff && columnDiff > 0)
			{
			// up right
			rowIncrementPerStep= -1;
			columnIncrementPerStep= 1;
			}
		else if(rowDiff == columnDiff && columnDiff > 0)
		{
			// down right
			rowIncrementPerStep= 1;
			columnIncrementPerStep= 1;
			
		}
		else if(rowDiff == -columnDiff && columnDiff <0)
		{
			// down left
			rowIncrementPerStep= 1;
			columnIncrementPerStep= -1;

		}
		else if(rowDiff == columnDiff && columnDiff<0)
		{
			// up left
			rowIncrementPerStep= -1;
			columnIncrementPerStep= -1;
		
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
