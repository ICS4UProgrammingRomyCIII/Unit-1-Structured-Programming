/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Einstein's Equation)
 * This program ... Calculates E (energy) from Einstein's equation E=mc^2
*/

import java.util.Scanner;

public class Einsteins_Equation {
	static Scanner scan = new Scanner(System.in);
	static final double SPEED_OF_LIGHT =  2.998e8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculateEnergy();
	}
	
	public static void CalculateEnergy() {
		Double massObject;
		try {
			System.out.print("Please type in a number.....");
			String usrInput = scan.nextLine();
			if (usrInput != null) {
				massObject = Double.parseDouble(usrInput);
			}
			else {
				return;
			}
			double energy = massObject * (SPEED_OF_LIGHT * SPEED_OF_LIGHT);
			System.out.println("The energy of an object with a mass of " + massObject + "kg is " + energy + "J");
		}
		catch (Exception e){
			System.out.println("Invalid Number");
			CalculateEnergy();
		}
	}
}
