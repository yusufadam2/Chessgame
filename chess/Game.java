package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		int turns = 0;
		Console keyboardConsole = System.console();

		while (!gameEnd)
		{
			boolean originCheck= false;
			boolean destinationCheck= false;
			boolean colourCheck= false;

			//white move
			if (turns%2 = 0)
			{
				System.out.println("- - - - - - Whites move - - - - - -");
				while(originCheck== false)
				{
					String origin;
					origin= keyboardConsole.readLine("Enter origin");
					originCheck= CheckInput.checkCoordinateValidity(origin);	
				}
				
				while(destinationCheck== false)
				{
					String destination;
					destination= keyboardConsole.readLine("Enter destination:");
					destinationCheck= CheckInput.checkCoordinateValidity(destination);
				}
				turns= turns +1;
			}

			//black move
			else if (turns%2=1)
			{
				System.out.println("- - - - - - Blacks move - - - - - -");
				while(originCheck== false)
				{
					String origin;
					origin= keyboardConsole.readLine("Enter origin");
					originCheck= CheckInput.checkCoordinateValidity(origin);	
				}
				
				while(destinationCheck== false)
				{
					String destination;
					destination= keyboardConsole.readLine("Enter destination:");
					destinationCheck= CheckInput.checkCoordinateValidity(destination);
				}
			}
			turns= turns+1;
		}		
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
