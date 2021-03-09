package chess;

//This class requires your input
public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String s)
	{
		symbol= s;
	}

	public PieceColour getColour()
	{
		return colour;
	}

	public abstract Boolean isLegitMove(int i1, int j1, int i2, int j2);
	
}
