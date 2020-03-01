/*
 * Created by: Romy I. Chu III
 * Created on: 18-Feb-2019
 * Created for: ICS4U
 * Day #10 (Rock, Paper, Scissor)
 * This program ... Allows the user to play Rock, Paper, Scissor with a computer.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.util.Random;
import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RockPaperScissors {
	// These are variables for the objects that will be created later.
	protected Shell frmRockPaperScissor;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	public Button btnCompRock;
	public Button btnCompPaper;
	public Button btnCompScissor;
	
	static final int INT_RANGE = 3; 	  // 0 == Rock, 1 == Paper, 2 == Scissor. Random() is Exclusive (incl 0, excl last number).
	static int playerWins = 0;		  // A counter for the player's total wins.	
	static int compWins = 0;		  // A counter for the computer's total wins.
	static String tie = "It was a Tie!!";     // A string to output when there is a tie.
	static String pWin = "The Player won!!";  // A string to output when the player wins.
	static String cWin = "The Computer won!!";// A string to output when the computer wins.
	

	// Automatically Created...
	public static void main(String[] args) {
		try {
			RockPaperScissors window = new RockPaperScissors();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Automatically Created...
	public void open() {
		Display display = Display.getDefault();
		createContents();
		frmRockPaperScissor.open();
		frmRockPaperScissor.layout();
		while (!frmRockPaperScissor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	// Automatically Created...
	protected void createContents() {
		frmRockPaperScissor = new Shell();
		frmRockPaperScissor.setSize(270, 239);
		frmRockPaperScissor.setText("Rock, Paper, Scissor!");
		
		Composite composite = formToolkit.createComposite(frmRockPaperScissor, SWT.NONE);
		composite.setBounds(10, 105, 110, 90);
		formToolkit.paintBordersFor(composite);
		
		Label lblCompChoice = new Label(composite, SWT.NONE);
		lblCompChoice.setText("Comp. Choice : ");
		lblCompChoice.setBounds(10, 0, 90, 15);
		formToolkit.adapt(lblCompChoice, true, true);
		
		btnCompRock = new Button(composite, SWT.RADIO);
		btnCompRock.setEnabled(false);
		btnCompRock.setText("Rock");
		btnCompRock.setBounds(10, 20, 90, 16);
		formToolkit.adapt(btnCompRock, true, true);
		
		btnCompPaper = new Button(composite, SWT.RADIO);
		btnCompPaper.setEnabled(false);
		btnCompPaper.setText("Paper");
		btnCompPaper.setBounds(10, 42, 90, 16);
		formToolkit.adapt(btnCompPaper, true, true);
		
		btnCompScissor = new Button(composite, SWT.RADIO);
		btnCompScissor.setEnabled(false);
		btnCompScissor.setText("Scissor");
		btnCompScissor.setBounds(10, 64, 90, 16);
		formToolkit.adapt(btnCompScissor, true, true);
	
		
		
		
		Label lblPlayerScore = new Label(frmRockPaperScissor, SWT.NONE);
		lblPlayerScore.setBounds(126, 10, 125, 15);
		formToolkit.adapt(lblPlayerScore, true, true);
		lblPlayerScore.setText("Player Score : ");
		
		Label lblCompScore = new Label(frmRockPaperScissor, SWT.NONE);
		lblCompScore.setText("Comp's Score :");
		lblCompScore.setBounds(126, 31, 125, 15);
		formToolkit.adapt(lblCompScore, true, true);
		
		Label lblWhoWin = new Label(frmRockPaperScissor, SWT.NONE);
		lblWhoWin.setBounds(126, 105, 118, 15);
		formToolkit.adapt(lblWhoWin, true, true);
		lblWhoWin.setText("");
		
		
		
		Composite grbUser = formToolkit.createComposite(frmRockPaperScissor, SWT.NONE);
		grbUser.setBounds(10, 10, 110, 90);
		formToolkit.paintBordersFor(grbUser);
		
		Button btnUsrRock = new Button(grbUser, SWT.RADIO);
		btnUsrRock.setBounds(10, 19, 90, 16);
		formToolkit.adapt(btnUsrRock, true, true);
		btnUsrRock.setText("Rock");
		
		Button btnUsrPaper = new Button(grbUser, SWT.RADIO);
		btnUsrPaper.setBounds(10, 41, 90, 16);
		formToolkit.adapt(btnUsrPaper, true, true);
		btnUsrPaper.setText("Paper");
		
		Button btnUsrScissor = new Button(grbUser, SWT.RADIO);
		btnUsrScissor.setBounds(10, 63, 90, 16);
		formToolkit.adapt(btnUsrScissor, true, true);
		btnUsrScissor.setText("Scissor");
		
		Label lblUsrChoice = new Label(grbUser, SWT.NONE);
		lblUsrChoice.setBounds(10, 0, 90, 15);
		formToolkit.adapt(lblUsrChoice, true, true);
		lblUsrChoice.setText("User's Choice : ");
		
		Button btnCheck = new Button(frmRockPaperScissor, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnCheck.addSelectionListener(new SelectionAdapter() {
			//0 == Rock, 1 == Paper, 2 == Scissor.
			//0 beats 2, Loses to 1; 1 Beats 0, Loses to 2; 2 Beats 1, Loses to 0. 
			public void widgetSelected(SelectionEvent e) {
				int CompChoice = GenerateRandomChoice(); 			      // Generates a random choice for the computer.
				if (CompChoice == 0/*Rock*/) {		  			      // If the Computer chooses ROCK...
					if(btnUsrRock.getSelection()) {  			      // If the player chooses ROCK...
						lblWhoWin.setText(tie);				      // Tell the user that there was a tie.
					} else if(btnUsrPaper.getSelection()) { 		      // If the player chooses PAPER...
						lblWhoWin.setText(pWin);	 		      // Tell the user that they won.
						playerWins++;			 		      // Increase the player's wins.
						lblPlayerScore.setText("Player Score :" + playerWins);// Change the text to reflect the total wins. 
					} else if(btnUsrScissor.getSelection()) {		      // If the Player chooses SCISSOR...
						lblWhoWin.setText(cWin);	 		      // Tell the user that the computer won.
						compWins++;			 		      // Increase the computer's wins
						lblCompScore.setText("Comp's Score : " + compWins);   // Change the text to reflect the total wins.
					}															
				} else if (CompChoice == 1/*Paper*/) {  			      // If the Computer chooses PAPER...
					if(btnUsrRock.getSelection()) {  			      // If the player chooses ROCK...
						lblWhoWin.setText(cWin);	 		      // Tell the user that the computer won.
						compWins++;					      // Increase the computer's wins
						lblCompScore.setText("Comp's Score :" + compWins);    // Change the text to reflect the total wins. 
					} else if(btnUsrPaper.getSelection()) { 		      // If the player chooses PAPER...
						lblWhoWin.setText(tie);				      // Tell the user that there was a tie.
					} else if(btnUsrScissor.getSelection()) {		      // If the Player chooses SCISSOR...
						lblWhoWin.setText(pWin);	 		       // Tell the user that they won.
						playerWins++;			 		       // Increase the player's wins.
						lblPlayerScore.setText("Player Score : " + playerWins);// Change the text to reflect the total wins. 
					}
				} else if (CompChoice == 2/*Scissor*/) {  			       // If the Computer chooses PAPER...
					if(btnUsrRock.getSelection()) {  			       // If the player chooses ROCK...
						lblWhoWin.setText(pWin);	 		       // Tell the user that they won.
						playerWins++;			 		       // Increase the player's wins.
						lblPlayerScore.setText("Player Score : " + playerWins);// Change the text to reflect the total wins. 
					} else if(btnUsrPaper.getSelection()) {   		       // If the player chooses PAPER...
						lblWhoWin.setText(cWin);	 		       // Tell the user that the computer won.
						compWins++;			 		       // Increase the computer's wins
						lblCompScore.setText("Comp's Score :" + compWins);     // Change the text to reflect the total wins. 
					} else if(btnUsrScissor.getSelection()) {		       // If the Player chooses SCISSOR...
						lblWhoWin.setText(tie);				       // Tell the user that there was a tie.
					}
				}
				
				
			}
		});
		btnCheck.setBounds(126, 74, 75, 25);
		formToolkit.adapt(btnCheck, true, true);
		btnCheck.setText("Check");
	}
	
	//This function will generate a random choice for the computer and return that choice.
	public int GenerateRandomChoice() {
		btnCompRock.setSelection(false);	  // Set the button selection to false.
		btnCompPaper.setSelection(false);	  // Set the button selection to false.
		btnCompScissor.setSelection(false);	  // Set the button selection to false.
		
		Random ranNum = new Random(); 		  // Creates a new Random object.
		int randomInt = ranNum.nextInt(INT_RANGE);//Generates a random integer
		if (randomInt == 0) {			  // If ROCK is selected...
			btnCompRock.setSelection(true);   // Set the button selection to true.
		} else if(randomInt == 1) {		  // If ROCK is selected...
			btnCompPaper.setSelection(true);  // Set the button selection to true.
		}else if (randomInt == 2) {		  // If ROCK is selected...
			btnCompScissor.setSelection(true);// Set the button selection to true.
		}
		return randomInt;			  // Return the chosen selection.
	}
}
