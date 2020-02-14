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
	static Scanner scan = new Scanner(System.in);
	static final int MIN = 1;
	static int maxNumber;
	
	public static void main(String[] args) {
		GetUsrIn();
	}
	
	public static void GetUsrIn() {
		try {
			System.out.print("Please type in a number.....");
			String usrInput = scan.nextLine();
			if (usrInput != null) {
				maxNumber = Integer.parseInt(usrInput);
			}
			else {
				return;
			}
			System.out.println(GenerateRandomNumber(maxNumber));
		}
		catch (Exception exc) {
			System.out.println("Invalid Number");
			GetUsrIn();
		}
	}
	
	
	
	public static int GenerateRandomNumber(int max) {
		int randomNumber = 0;
		Random ranNum = new Random();
		randomNumber = ranNum.nextInt((max - MIN) + 1) + MIN;
		return randomNumber;
	}
}
