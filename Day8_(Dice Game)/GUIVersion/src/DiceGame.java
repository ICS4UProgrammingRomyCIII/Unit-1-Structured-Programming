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
	protected Shell frmDiceGame;
	static final int MIN = 1;
	static final int MAX = 6;
	static int guessesSoFar = 0;
	Random ranNum = new Random();
	int randomNumber = ranNum.nextInt((MAX - MIN) + 1) + MIN;
	
	public static void main(String[] args) {
		try {
			DiceGame window = new DiceGame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		btnGuess.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CheckNumber(lblGuessesSoFar, lblCorrectNumber, nudGuess);
			}
		});
		btnGuess.setBounds(10, 51, 75, 25);
		btnGuess.setText("Guess");
	}
	
	public void CheckNumber(Label lblGuesses, Label lblAns, Spinner nud) {
		guessesSoFar++;
		
		int guess = Integer.parseInt(nud.getText());
		if (guess == randomNumber) {
			lblAns.setText("The Correct Number is : " + randomNumber);
		}
		else {
			lblGuesses.setText("Guesses So Far : " + guessesSoFar);
		}
	}
}
