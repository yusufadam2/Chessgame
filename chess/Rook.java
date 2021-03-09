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
			rowIncrementPerStep= 1;
			columnIncrementPerStep=0;
		
		}
		else
		{
			// not moving diagonally
			System.out.println("not moving straight");
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
				System.out.println("pieces in between source and target");
				return false;
			}

			currentRow += rowIncrementPerStep;
			currentColumn += columnIncrementPerStep;
		}
		return true;
	}	
}
