/*
 * Created by: Romy I. Chu III
 * Created on: 10-Feb-2019
 * Created for: ICS4U
 * Day #8 (Dice Game)
 * This program ... Is a game where a dice is rolled and the user tries to predict the number.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import java.util.Random;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class DiceGame {
	// These are variables for the objects that will be created later.
	protected Shell frmDiceGame;
	
	Random ranNum = new Random();				  // Random object to generate a random int
	static final int MIN = 1;				  // Variable for the minimum random value.
	static final int MAX = 6;				  // Variable for the maximum random value.
	static int guessesSoFar = 0;				  // Variable to track the total number of guesses.
	int randomNumber = ranNum.nextInt((MAX - MIN) + 1) + MIN;
	
	//Automatically Created...
	public static void main(String[] args) {
		try {
			DiceGame window = new DiceGame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Automatically Created...
	public void open() {
		Display display = Display.getDefault();
		createContents();
		frmDiceGame.open();
		frmDiceGame.layout();
		while (!frmDiceGame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	//Automatically Created...
	protected void createContents() {
		frmDiceGame = new Shell();
		frmDiceGame.setSize(450, 144);
		frmDiceGame.setText("Dice Game");
		
		Label lblPickYourPoison = new Label(frmDiceGame, SWT.NONE);
		lblPickYourPoison.setBounds(10, 10, 106, 15);
		lblPickYourPoison.setText("Enter your guess : ");
		
		Spinner nudGuess = new Spinner(frmDiceGame, SWT.BORDER);
		nudGuess.setMaximum(6);
		nudGuess.setMinimum(1);
		nudGuess.setBounds(113, 7, 47, 22);
		
		Label lblGuessesSoFar = new Label(frmDiceGame, SWT.NONE);
		lblGuessesSoFar.setBounds(10, 30, 376, 15);
		lblGuessesSoFar.setText("Guesses So Far : ");
		
		Label lblCorrectNumber = new Label(frmDiceGame, SWT.NONE);
		lblCorrectNumber.setBounds(10, 82, 376, 15);
		lblCorrectNumber.setText("The Correct Number is : ");
		
		Button btnGuess = new Button(frmDiceGame, SWT.NONE);
		// This Block of code creates an action listener and attaches it to the button. 
		btnGuess.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// When the button is pressed it calls CheckNumber() passing lblGuessesSoFar, lblCorrectNumber, and nudGuess as arguments.
				CheckNumber(lblGuessesSoFar, lblCorrectNumber, nudGuess); 
			}
		});
		btnGuess.setBounds(10, 51, 75, 25);
		btnGuess.setText("Guess");
	}
	
	// This procedure checks whether or not the user's guess is the same as the randomly generated number.
	public void CheckNumber(Label lblGuesses, Label lblAns, Spinner nud) {
		guessesSoFar++;							  // When the procedure is called, the number of guesses increases.
		int guess = Integer.parseInt(nud.getText());			  // Gets the user's guess from the numeric up-down box.
		if (guess == randomNumber) {					  // If the user guesses correctly...
			lblAns.setText("The Correct Number is : " + randomNumber);// Change the answer label to tell the user.
		}
		else {								  // Otherwise...
			lblGuesses.setText("Guesses So Far : " + guessesSoFar);   // Increase the user's amount of guesses.
		}
	}
}
