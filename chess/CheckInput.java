package chess;
public class CheckInput {
	
	//This method requires your input
	public boolean checkCoordinateValidity(String input){
		//ensures 2 characters have been inputted
		if (input.length()!=2)
		{
			System.out.println("Input must be 2 characters");
			return false;
		}

		//ensures number input is between 0 and 9
		int numVal = Character.getNumericValue(input.charAt(0));

		if (0< numVal && numVal<9)
		{
			//letter is valid
			if("abcdefgh".indexOf(input.charAt(1)) != -1)
			{
				return true;
			}
		}

		System.out.println("Invalid input, try again");
		return false;
	}
}
