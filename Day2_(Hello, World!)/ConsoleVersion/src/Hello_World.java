/*
 * Created by: Romy I. Chu III
 * Created on: 03-Feb-2019
 * Created for: ICS4U
 * Day #2 (Hello, World!)
 * This program ... Displays the string "Hello World! My name is Romy III" onto the console 10 times.
*/

public class Hello_World {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables
		int i;
		String firstWord = "Hello";
		String secondWord = "World";
		String exclMark = "!";
		String name = "Romy III";
		String statement = "My name is ";
		
		//Code
		for (i=0; i<= 10; i++) {
			System.out.println(firstWord + " " + secondWord + exclMark + " " + statement + name);
		}
	}
}
