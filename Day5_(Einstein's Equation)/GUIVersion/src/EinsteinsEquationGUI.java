/*
 * Created by: Romy I. Chu III
 * Created on: 05-Feb-2019
 * Created for: ICS4U
 * Day #4 (Einstein's Equation)
 * This program ... Calculates E (energy) from Einstein's equation E=mc^2
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

public class EinsteinsEquationGUI {
	//These are variables for the objects that will be created later.
	protected Shell frmEinsteinsEquation;
	private Text txtMass;
	
	static final double SPEED_OF_LIGHT = 2.998e8; //A constant for the speed of light.
	
	//Automatically created...
	public static void main(String[] args) {
		try {
			EinsteinsEquationGUI window = new EinsteinsEquationGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Automatically created...
	public void open() {
		Display display = Display.getDefault();
		createContents();
		frmEinsteinsEquation.open();
		frmEinsteinsEquation.layout();
		while (!frmEinsteinsEquation.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Automatically created...
	protected void createContents() {
		frmEinsteinsEquation = new Shell();
		frmEinsteinsEquation.setSize(543, 123);
		frmEinsteinsEquation.setText("Einstein's Equation; E = m*c^2");
		
		Label lblMass = new Label(frmEinsteinsEquation, SWT.NONE);
		lblMass.setBounds(10, 10, 179, 15);
		lblMass.setText("Enter the Mass of the Object (kg): ");
		
		Label lblAnswer = new Label(frmEinsteinsEquation, SWT.NONE);
		lblAnswer.setBounds(10, 58, 530, 21);
		
		txtMass = new Text(frmEinsteinsEquation, SWT.BORDER);
		txtMass.setBounds(10, 31, 147, 21);
		
	
		Button btnCalculate = new Button(frmEinsteinsEquation, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			double cSquared = Math.pow(SPEED_OF_LIGHT, 2.0); 		//Squares the speed of light.
			Double energy;							//Creates a temporary variable for the energy(the answer).
			Double massOfObject;
			try {
				massOfObject = Double.parseDouble(txtMass.getText()); //Parses the text from the textbox into a double.
				energy = massOfObject * cSquared;		      //Calculates the energy.
				//Creates a string variable called output and sets as a formatted version of energy(max of 3 decimal places).
				String output = String.format("An object with a mass of %.3f, has %.3e Joules of energy", massOfObject, energy);
				lblAnswer.setText(output);			      //Sets the labels text to the output.
			}
			//If an exception occurs during runtime...
			catch (Exception exc) {
				//Tell the user that they inputed an invalid number.
				MessageDialog.openError(frmEinsteinsEquation, "An Error has Occurred", "There was an invalid number in the text field!");
			}
		}
		});
		btnCalculate.setBounds(163, 31, 75, 21);
		btnCalculate.setText("Calculate");
		


	}
}
