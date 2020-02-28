/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Logging Company)
 * This program ... Calculates the number of logs that can fit in a truck.
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

public class LoggingCompanyGUI {
	//These are variables for the objects that will be created later.
	protected Shell frmLoggingCompany;
	private Text txtLogLength;
	private Text txtLogWeight;
	private Text txtCarryCapacity;
	
	//Automatically created...
	public static void main(String[] args) {
		try {
			LoggingCompanyGUI window = new LoggingCompanyGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Automatically created...
	public void open() {
		Display display = Display.getDefault();
		createContents();
		frmLoggingCompany.open();
		frmLoggingCompany.layout();
		while (!frmLoggingCompany.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	//Automatically created...
	protected void createContents() {
		frmLoggingCompany = new Shell();
		frmLoggingCompany.setSize(313, 183);
		frmLoggingCompany.setText("Logging Company");
		
		Label lblLogLength = new Label(frmLoggingCompany, SWT.NONE);
		lblLogLength.setText("Log Length: ");
		lblLogLength.setBounds(10, 10, 66, 15);
		
		Label lblLogWeight = new Label(frmLoggingCompany, SWT.NONE);
		lblLogWeight.setText("Log Weight: ");
		lblLogWeight.setBounds(112, 10, 66, 15);
		
		Label lblCarryCapacity = new Label(frmLoggingCompany, SWT.NONE);
		lblCarryCapacity.setText("Log Capacity: ");
		lblCarryCapacity.setBounds(214, 10, 75, 15);
		
		txtLogLength = new Text(frmLoggingCompany, SWT.BORDER);
		txtLogLength.setBounds(10, 31, 76, 21);
		
		txtLogWeight = new Text(frmLoggingCompany, SWT.BORDER);
		txtLogWeight.setBounds(112, 31, 76, 21);
		
		txtCarryCapacity = new Text(frmLoggingCompany, SWT.BORDER);
		txtCarryCapacity.setBounds(214, 31, 76, 21);
		
		Label lblNumLogs = new Label(frmLoggingCompany, SWT.NONE);
		lblNumLogs.setBounds(10, 120, 204, 15);
		lblNumLogs.setText("Max Number of Logs : ");
		
		Button btnCalculate = new Button(frmLoggingCompany, SWT.NONE);
		btnCalculate.setBounds(10, 73, 277, 25);
		btnCalculate.setText("Calculate Max Amount of Logs");
		
		//This Block of code creates an action listener and attaches it to the button. 
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Temporary variables for the length, weight, carry capacity of the truck, and the number of logs.
				double lLength, lWeight, maxCarryCapacity, numLogs;
				//The string that the text of lblNumLogs will change to.
				String output;
				
				//This try-catch loop will catch any errors that occur during runtime.
				//The procedure will try to...
				try {
					lLength = Double.parseDouble(txtLogLength.getText());				//Parse the text from txtLogLength into a double
					lWeight = Double.parseDouble(txtLogWeight.getText());				//Parse the text from txtLogWeight into a double
					maxCarryCapacity = Double.parseDouble(txtCarryCapacity.getText());	//Parse the text from txtCarryCapacity into a double
					
					numLogs = (maxCarryCapacity / (lWeight * lLength));					//Calculates the number of logs (keeps it as a double).
					output = String.format("Max Number of Logs : %.2f", numLogs);		//Formats the numLogs to only have 2 decimal places.
					lblNumLogs.setText(output); 										//Sets the text of the label to the output.
				}
				//If an exception occurs during runtime...
				catch (Exception exc) {
					//Tells the user that they inputed an invalid number in the text fields.
					MessageDialog.openError(frmLoggingCompany, "An Error has Occurred", "There was an invalid number in the text field!");
				}
				
			}
		});
	}
}
