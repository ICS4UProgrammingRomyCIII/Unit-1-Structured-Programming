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
	protected Shell frmRockPaperScissor;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	static final int INT_RANGE = 3; //0 == Rock, 1 == Paper, 2 == Scissor. Random() is Exclusive (incl 0, excl last number).
	static int playerWins = 0;
	static int compWins = 0;
	static String tie = "It was a Tie!!";
	static String pWin = "The Player won!!";
	static String cWin = "The Computer won!!";
	
	public Button btnCompRock;
	public Button btnCompPaper;
	public Button btnCompScissor;
	
	public static void main(String[] args) {
		try {
			RockPaperScissors window = new RockPaperScissors();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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
		btnCheck.addSelectionListener(new SelectionAdapter() {
			//0 == Rock, 1 == Paper, 2 == Scissor.
			//0 beats 2, Loses to 1; 1 Beats 0, Loses to 2; 2 Beats 1, Loses to 0. 
			public void widgetSelected(SelectionEvent e) {
				int CompChoice = GenerateRandomChoice();
				if (CompChoice == 0/*Rock*/) {
					if(btnUsrRock.getSelection()) {
						lblWhoWin.setText(tie);
					} else if(btnUsrPaper.getSelection()) {
						lblWhoWin.setText(pWin);
						playerWins++;
						lblPlayerScore.setText("Player Score :" + playerWins);
					} else if(btnUsrScissor.getSelection()) {
						lblWhoWin.setText(cWin);
						compWins++;
						lblPlayerScore.setText("Comp's Score : " + compWins);
					}
				} else if (CompChoice == 1/*Paper*/) {
					if(btnUsrRock.getSelection()) {
						lblWhoWin.setText(cWin);
						compWins++;
						lblCompScore.setText("Comp's Score :" + compWins);
					} else if(btnUsrPaper.getSelection()) {
						lblWhoWin.setText(tie);
					} else if(btnUsrScissor.getSelection()) {
						lblWhoWin.setText(pWin);
						playerWins++;
						lblPlayerScore.setText("Player Score : " + playerWins);
					}
				} else if (CompChoice == 2/*Scissor*/) {
					if(btnUsrRock.getSelection()) {
						lblWhoWin.setText(pWin);
						playerWins++;
						lblPlayerScore.setText("Player Score : " + playerWins);
					} else if(btnUsrPaper.getSelection()) {
						lblWhoWin.setText(cWin);
						compWins++;
						lblCompScore.setText("Comp's Score :" + compWins);
					} else if(btnUsrScissor.getSelection()) {
						lblWhoWin.setText(tie);
					}
				}
				
				
			}
		});
		btnCheck.setBounds(126, 74, 75, 25);
		formToolkit.adapt(btnCheck, true, true);
		btnCheck.setText("Check");
	}
	
	public int GenerateRandomChoice() {
		btnCompRock.setSelection(false);
		btnCompPaper.setSelection(false);
		btnCompScissor.setSelection(false);
		
		Random ranNum = new Random(); 
		int randomInt = ranNum.nextInt(INT_RANGE);
		if (randomInt == 0) {
			btnCompRock.setSelection(true);
		} else if(randomInt == 1) {
			btnCompPaper.setSelection(true);
		}else if (randomInt == 2) {
			btnCompScissor.setSelection(true);
		}
		
		return randomInt;
	}
}
