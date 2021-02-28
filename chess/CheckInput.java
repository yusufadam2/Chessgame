package chess;
public class CheckInput {
	
	//This method requires your input
	public boolean checkCoordinateValidity(String input){
		//ensures 2 characters have been inputted
		if (input.length()!=2)
		{
			return false;	
		}

		//ensures number input is between 0 and 9
		int num = Character.getNumericValue(input.charAt(0));

		if (0< num && num<9)
		{
			//letter is valid
			if("abcdefgh".indexOf(input.charAt(1)) != -1)
			{
				return true;
			}
		}

		return false;
		// else if ((input.chartAt(0) !="1") || (input.chartAt(0) !="2") || (input.charAt(0) !="3") || (input.chartAt(0) !="4") || (input.chartAt(0) !="5") || (input.chartAt(0) !="6") || (input.chartAt(0) !="7") || (input.chartAt(0) !="8"))
		// {
		// 	return false;
		// }
		// else if ((input.chartAt(1) !="a") || (input.chartAt(1) !="b") || (input.chartAt(1) !="c") || (input.chartAt(1) !="d") || (input.chartAt(1) !="e") || (input.chartAt(1) !="f") || (input.chartAt(1) !="g") || (input.chartAt(1) !="h"))
		// {
		// 	return false;
		// }
		// else
		// {
		// 	return true;
		// }
	}
}
