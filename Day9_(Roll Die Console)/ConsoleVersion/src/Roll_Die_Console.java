/*
 * Created by: Romy I. Chu III
 * Created on: 14-Feb-2019
 * Created for: ICS4U
 * Day #4 (Roll Die Console)
 * This program ... Generates a random number, given the maximum number by the user.
*/

import java.util.Random;
import java.util.Scanner;

public class Roll_Die_Console {
	static Scanner scan = new Scanner(System.in); // This scanner is used to get the user's input from the console.
	static final int MIN = 1;		      // This is the minimum number for the random number.
	
	// Automatically created...
	public static void main(String[] args) {
		GetUsrIn(); // When the program starts, call the GetUsrIn() procedure.
	}

	// This procedure will get the user's input.
	public static void GetUsrIn() {
		//This try-catch loop will catch any errors that occur during runtime.
		//The procedure will try to...
		try {
			System.out.print("Please type in a max number.....");	    // Tell the user to input a number.
			String usrInput = scan.nextLine();			    // Scan the next line for the user's input and store it in a string.
			if (usrInput != null) {					    // If the user didn't input nothing...
				int maxNumber = Integer.parseInt(usrInput);	    // Parse the user's input as an int and store it in a variable.
				System.out.println(GenerateRandomNumber(maxNumber));// Call GenerateRandomNumber() passing maxNumber as an argument and prints the output to the console.
			}
		}
		//If an exception occurs during runtime...
		catch (Exception exc) {
			System.out.println("Invalid Number"); //Tell the user that they inputed an invalid number.
			GetUsrIn();			      //Call GetUsrIn().
		}
	}
	
	// This function will generate a random number, taking an int as an argument.
	// It then return the random number. 
	public static int GenerateRandomNumber(int max) {	 	   
		Random ranNum = new Random();				  // Create a new Random object.
		int randomNumber = ranNum.nextInt((max - MIN) + 1) + MIN; // Generate a random number.
		return randomNumber;					  // Return the random number.
	}
}
