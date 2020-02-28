/*
 * Created by: Romy I. Chu III
 * Created on: 06-Feb-2019
 * Created for: ICS4U
 * Day #6 (Simple Calculator)
 * This program ... Is basically just a simple calculator that really isn't that useful.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SimpleCalc {
	//These are variables for the objects that will be created later.
	protected Shell shlSimpleCalculator;
	private Text txtFirstNumber;
	private Text txtSecondNumber;
	
	//Automatically Created...
	public static void main(String[] args) {
		try {
			SimpleCalc window = new SimpleCalc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Automatically created...
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSimpleCalculator.open();
		shlSimpleCalculator.layout();
		while (!shlSimpleCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	//Automatically created...
	protected void createContents() {
		shlSimpleCalculator = new Shell();
		shlSimpleCalculator.setSize(261, 154);
		shlSimpleCalculator.setText("Simple Calculator");
		
		Label lblFirstNumber = new Label(shlSimpleCalculator, SWT.NONE);
		lblFirstNumber.setBounds(10, 10, 76, 15);
		lblFirstNumber.setText("First Number");
		
		Label lblSecondNumber = new Label(shlSimpleCalculator, SWT.NONE);
		lblSecondNumber.setText("Second Number");
		lblSecondNumber.setBounds(129, 10, 86, 15);
		
		Label lblAnswer = new Label(shlSimpleCalculator, SWT.NONE);
		lblAnswer.setBounds(10, 89, 168, 15);
		lblAnswer.setText("The Answer is :");
		
		txtFirstNumber = new Text(shlSimpleCalculator, SWT.BORDER);
		txtFirstNumber.setBounds(10, 31, 98, 21);
		
		txtSecondNumber = new Text(shlSimpleCalculator, SWT.BORDER);
		txtSecondNumber.setBounds(129, 31, 106, 21);
		
		Button btnAddition = new Button(shlSimpleCalculator, SWT.NONE);
		btnAddition.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int firstNumber, secondNumber; //Temporary variables for the first and second number.
				try {
					firstNumber = Integer.parseInt(txtFirstNumber.getText());   //Parses the text from the textbox into an int.
					secondNumber = Integer.parseInt(txtSecondNumber.getText()); //Parses the text from the textbox into an int.
					int answer = firstNumber + secondNumber;		    //Creates a variable, answer, and adds the nummbers together.
					lblAnswer.setText("The Answer is : " + answer); 	    //Sets the answer label to the answer.
					
				} catch (Exception exc) {
					//Tells the user that they inputed an invalid number.
					MessageDialog.openError(shlSimpleCalculator, "Error", "Invalid Number");
				}
			}
		});
		btnAddition.setBounds(10, 58, 39, 25);
		btnAddition.setText("+");
		
		
		
		Button btnSubtract = new Button(shlSimpleCalculator, SWT.NONE);
		btnSubtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int firstNumber, secondNumber; //Temporary variables for the first and second number.
				try {
					firstNumber = Integer.parseInt(txtFirstNumber.getText());    //Parses the text from the textbox into an int.
					secondNumber = Integer.parseInt(txtSecondNumber.getText());  //Parses the text from the textbox into an int.
					int answer = firstNumber - secondNumber; 		     //Creates a variable, answer, and subtracts the second number from the first.
 					lblAnswer.setText("The Answer is : " + answer); 	     //Sets the answer label to the answer.
				}
				catch (Exception exc) {
					//Tells the user that they inputed an invalid number.
					MessageDialog.openError(shlSimpleCalculator, "Error", "Invalid Number");
				}
			}
		});
		btnSubtract.setText("-");
		btnSubtract.setBounds(69, 58, 39, 25);
		
		
		
		Button btnMultiply = new Button(shlSimpleCalculator, SWT.NONE);
		btnMultiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int firstNumber, secondNumber; //Temporary variables for the first and second number.
				try {
					firstNumber = Integer.parseInt(txtFirstNumber.getText());    //Parses the text from the textbox into an int.
					secondNumber = Integer.parseInt(txtSecondNumber.getText());  //Parses the text from the textbox into an int.
					int answer = firstNumber * secondNumber;		     //Creates a variable, answer, and Multiplies the numbers
					lblAnswer.setText("The Answer is : " + answer); 	     //Sets the answer label to the answer.
				}
				catch (Exception exc) {
					//Tells the user that they inputed an invalid number.
					MessageDialog.openError(shlSimpleCalculator, "Error", "Invalid Number");
				}
			}
		});
		btnMultiply.setText("*");
		btnMultiply.setBounds(139, 58, 39, 25);
		
		
		
		Button btnDivide = new Button(shlSimpleCalculator, SWT.NONE);
		btnDivide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double firstNumber, secondNumber; //Temporary variables for the first and second number.
				try {
					firstNumber = Double.parseDouble(txtFirstNumber.getText());   //Parses the text from the textbox into an double.
					secondNumber = Double.parseDouble(txtSecondNumber.getText()); //Parses the text from the textbox into an double.
					double answer = firstNumber / secondNumber;		      //Creates a variable, answer, and divides the first number by the second.
					lblAnswer.setText("The Answer is : " + answer); 	      //Sets the answer label to the answer.
				}
				catch (Exception exc) {
					//Tells the user that they inputed an invalid number.
					MessageDialog.openError(shlSimpleCalculator, "Error", "Invalid Number");
				}

			}
		});
		btnDivide.setText("/");
		btnDivide.setBounds(196, 58, 39, 25);
	}
}
