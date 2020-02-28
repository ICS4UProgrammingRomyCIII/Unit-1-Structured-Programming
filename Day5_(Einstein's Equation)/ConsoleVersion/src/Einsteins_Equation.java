/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Einstein's Equation)
 * This program ... Calculates E (energy) from Einstein's equation E=mc^2
*/

import java.util.Scanner;

public class Einsteins_Equation {
	static Scanner scan = new Scanner(System.in);  //This scanner is used to check for user input.
	static final double SPEED_OF_LIGHT =  2.998e8; //This is a constant for the speed of light.
	
	//Automatically created...
	public static void main(String[] args) {
		//This calls the CalculateEnergy() procedure.
		CalculateEnergy();
	}

	public static void CalculateEnergy() {
		Double massObject; //This creates temporary variable for the mass of the object.
		
		//This try-catch loop will catch any errors that occur during runtime.
		//The procedure will try to...
		try {
			System.out.print("Please type in a number....."); //Tell the user to input a number.
			String usrInput = scan.nextLine();		  //Check for the user input.
			//If the user's input isn't blank...
			if (usrInput != null) {
				massObject = Double.parseDouble(usrInput);//Parse the user's input as a double
				double energy = massObject * (SPEED_OF_LIGHT * SPEED_OF_LIGHT); //Calculates the energy.
				//Outputs the answer to the console.
				System.out.println("The energy of an object with a mass of " + massObject + "kg is " + energy + "J");
			}
		}
		//If an exception occurs during runtime...
		catch (Exception e){
			System.out.println("Invalid Number"); //Tell the user that they inputed an invalid number.
			CalculateEnergy();		      //Call the CalculateEnergy() Procedure again.
		}
	}
}
