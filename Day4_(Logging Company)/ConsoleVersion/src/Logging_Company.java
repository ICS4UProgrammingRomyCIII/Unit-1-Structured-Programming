/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Logging Company)
 * This program ... Calculates the number of logs that can fit in a truck.
*/

import java.util.Scanner;

public class Logging_Company {
	//These are constants for the log's weight and the truck's carrying capacity.
	static final int MAPLE_LOG_WEIGHT = 20;
	static final int MAX_CARRY_CAPACITY = 1100;
	
	//This scanner will be used to get the user's input in the console.
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Calls the CalculateNLogs procedure.
		CalculateNLogs();
	}
	
	//This procedure is used to calculate and output the number of logs given the length by the user.
	public static void CalculateNLogs() {
		//These are temporary variables for... 
		int numLogs; 		//The number of logs (This will be printed in the console as the answer.)
		double logLength;	//This variable is to store the user's input from the console.
		
		//This try-catch loop will catch any errors that occur during runtime.
		//The procedure will try to...
		try {
			System.out.print("Please type in a length for the logs.....");  //Ask the user to input any real number.
			String usrInput = scan.nextLine();								//Store the user's input.
			//If the input isn't empty...
			if (usrInput != null) {
				//Parse the input as a double.
				logLength = Double.parseDouble(usrInput);
			//This else statement is only here to prevent the following lines from giving a not initialized error.
			} else {
				//When the procedure returns, will will create an error that will be caught by the catch statement.
				return;
			}
			//Calculates the number of logs and casts it as an integer.
			numLogs = (int)(MAX_CARRY_CAPACITY / (MAPLE_LOG_WEIGHT * logLength));
			//Prints the output into the console.
			System.out.println("The number of logs with a length of " + logLength + "m that can fit on the truck is " + numLogs);
		}
		//If an exception occurs during runtime...
		catch (Exception e){
			//Tell the user that they have inputed an invalid number.
			System.out.println("You Have Inputed an Invalid Number!!");
			//Call the procedure again.
			CalculateNLogs();
			
		}
	}
}
