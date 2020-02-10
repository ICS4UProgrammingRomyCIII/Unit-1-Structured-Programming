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
import javax.swing.JOptionPane;

public class LoggingCompanyGUI {
	protected Shell frmLoggingCompany;
	private Text txtLogLength;
	private Text txtLogWeight;
	private Text txtCarryCapacity;
	public static void main(String[] args) {
		try {
			LoggingCompanyGUI window = new LoggingCompanyGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double lLength, lWeight, maxCarryCapacity, numLogs;
				String output;
				
				try {
					lLength = Double.parseDouble(txtLogLength.getText());
					lWeight = Double.parseDouble(txtLogWeight.getText());
					maxCarryCapacity = Double.parseDouble(txtCarryCapacity.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(frmLoggingCompany, "An Error has Occurred", "There was an invalid number in the text field!");
					return;
				}
				numLogs = (maxCarryCapacity / (lWeight * lLength));
				output = String.format("Max Number of Logs : %.2f", numLogs);
				lblNumLogs.setText(output);
			}
		});
	}
}
