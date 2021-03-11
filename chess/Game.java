package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		int turns = 0;
		Console keyboardConsole = System.console();
		CheckInput check= new CheckInput();
		while (!gameEnd)
		{
			boolean originCheck= false;
			boolean destinationCheck= false;
			boolean colourCheck= false;
			boolean legitCheck= false;
			int sourceRow=0;
			int sourceColumn=0;
			int destRow=0;
			int destColumn=0;
			//white move
			if (turns%2 == 0)
			{
				System.out.println("------ Whites move ------");
				while(colourCheck== false && !gameEnd)
				{
					try
					{
						String origin;
						origin= keyboardConsole.readLine("Enter origin: ");
						
						if(origin.equals("END"))
						{
							gameEnd= true;
						}
						else
						{
							originCheck= check.checkCoordinateValidity(origin);
						}
						

						if(originCheck== true && !gameEnd)
						{
							sourceRow= Character.getNumericValue(origin.charAt(0))-1;
							sourceColumn= "abcdefgh".indexOf(origin.charAt(1));

							//check for white
							if(Board.getPiece(sourceRow,sourceColumn).getColour()==PieceColour.WHITE)
							{
								colourCheck= true;
							}
							else if(Board.getPiece(sourceRow,sourceColumn).getColour()==PieceColour.BLACK)
							{
								colourCheck= false;
								System.out.println("Piece is not white");
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("No piece on square");
						continue;
					}

				}
				
				while(legitCheck== false && !gameEnd)
				{
					String destination;
					destination= keyboardConsole.readLine("Enter destination: ");
					if(destination.equals("END"))
					{
						gameEnd= true;
					}
					else
					{
						destinationCheck= check.checkCoordinateValidity(destination);
					}

					if(destinationCheck== true && !gameEnd)
					{
						destRow= Character.getNumericValue(destination.charAt(0))-1;
						destColumn= "abcdefgh".indexOf(destination.charAt(1));

						if(Board.getPiece(sourceRow,sourceColumn).isLegitMove(sourceRow,sourceColumn,destRow,destColumn))
						{
							legitCheck= true;
						}

					}
				}
				if(legitCheck && colourCheck && !gameEnd)
				{
					if(Board.movePiece(sourceRow,sourceColumn,destRow,destColumn,Board.getPiece(sourceRow,sourceColumn)))
					{
						gameEnd=true;
						System.out.println("White wins!");
					}
					else
					{
						Board.printBoard();
						turns= turns+1;
					}
				}


			}

			//black move
			else if (turns%2 ==1)
			{
				System.out.println("------ Blacks move ------");
				while(colourCheck== false && !gameEnd)
				{
					try
					{
						String origin;
						origin= keyboardConsole.readLine("Enter origin: ");
						if(origin.equals("END"))
						{
							gameEnd= true;
						}
						else
						{
							originCheck= check.checkCoordinateValidity(origin);
						}

						if(originCheck== true && !gameEnd)
						{
							sourceRow= Character.getNumericValue(origin.charAt(0))-1;
							sourceColumn= "abcdefgh".indexOf(origin.charAt(1));

							//check for white
							if(Board.getPiece(sourceRow,sourceColumn).getColour()==PieceColour.BLACK)
							{
								colourCheck= true;
							}
							else if(Board.getPiece(sourceRow,sourceColumn).getColour()==PieceColour.WHITE)
							{
								colourCheck= false;
								System.out.println("Piece is not black");
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("No piece on square");
						continue;
					}

				}
				
				while(legitCheck== false && !gameEnd)
				{
					String destination;
					destination= keyboardConsole.readLine("Enter destination: ");
					
					if(destination.equals("END"))
					{
						gameEnd= true;
					}
					else
					{
						destinationCheck= check.checkCoordinateValidity(destination);
					}

					if(destinationCheck== true && !gameEnd)
					{
						destRow= Character.getNumericValue(destination.charAt(0))-1;
						destColumn= "abcdefgh".indexOf(destination.charAt(1));

						if(Board.getPiece(sourceRow,sourceColumn).isLegitMove(sourceRow,sourceColumn,destRow,destColumn))
						{
							legitCheck= true;
						}

					}
				}
				if(legitCheck && colourCheck && !gameEnd)
				{
					if(Board.movePiece(sourceRow,sourceColumn,destRow,destColumn,Board.getPiece(sourceRow,sourceColumn)))
					{
						gameEnd=true;
						System.out.println("Black wins!");
					}
					else
					{
						Board.printBoard();
						turns= turns+1;
					}
				}
			}
		}
	}		
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	
	}

}
