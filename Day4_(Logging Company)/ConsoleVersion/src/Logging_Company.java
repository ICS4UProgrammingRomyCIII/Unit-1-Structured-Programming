/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Logging Company)
 * This program ... Calculates the number of logs that can fit in a truck.
*/

public class Logging_Company {
	static final int MAPLE_LOG_WEIGHT = 20;
	static final int MAX_CARRY_CAPACITY = 1100;
	
	public static void main(String[] args) {
		int i;
		double[] logLengths = new double[] {0.25, 0.5, 1.0};
		
		for (i = 0; i < 3; i++){
			int totalLogs;
			totalLogs = CalculateNLogs(logLengths[i]);
			System.out.println("The number of logs with a length of " + logLengths[i] + "m that can fit on the truck is " + totalLogs);
		}
	}
	
	static int CalculateNLogs(double length) {
		int numLogs; 
		numLogs = (int)(MAX_CARRY_CAPACITY / (MAPLE_LOG_WEIGHT * length));
		return numLogs;
	}
}
