/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Logging Company)
 * This program ... Calculates the number of logs that can fit in a truck.
*/

import java.util.Scanner;

public class Logging_Company {
	static final int MAPLE_LOG_WEIGHT = 20;
	static final int MAX_CARRY_CAPACITY = 1100;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		CalculateNLogs();
	}
	
	public static void CalculateNLogs() {
		int numLogs; 
		double logLength;
		try {
			System.out.print("Please type in a length for the logs.....");
			String usrInput = scan.nextLine();
			if (usrInput != null) {
				logLength = Double.parseDouble(usrInput);
			}
			else {
				return;
			}
			numLogs = (int)(MAX_CARRY_CAPACITY / (MAPLE_LOG_WEIGHT * logLength));
			System.out.println("The number of logs with a length of " + logLength + "m that can fit on the truck is " + numLogs);
		}
		catch (Exception e){
			System.out.println("Invalid Number");
			CalculateNLogs();
			
		}
	}
}
