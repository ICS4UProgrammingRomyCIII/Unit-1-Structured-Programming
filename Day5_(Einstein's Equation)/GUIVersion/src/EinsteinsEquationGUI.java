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
	protected Shell frmEinsteinsEquation;
	private Text txtMass;
	public static void main(String[] args) {
		try {
			EinsteinsEquationGUI window = new EinsteinsEquationGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			final double SPEED_OF_LIGHT = 2.998e8;
			double cSquared = Math.pow(SPEED_OF_LIGHT, 2.0);
			Double energy;
			Double massOfObject = null;
			try {
				massOfObject = Double.parseDouble(txtMass.getText());
			}
			catch (Exception exc) {
				MessageDialog.openError(frmEinsteinsEquation, "An Error has Occurred", "There was an invalid number in the text field!");
			}
			
			energy = massOfObject * cSquared;
			String output = String.format("An object with a mass of %.3f, has %.3e Joules of energy", massOfObject, energy);
			lblAnswer.setText(output);
			//lblAnswer.setText(Double.toString(energy));
			}
		});
		btnCalculate.setBounds(163, 31, 75, 21);
		btnCalculate.setText("Calculate");
		


	}
}
