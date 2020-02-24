/*
 * Created by: Romy I. Chu III
 * Created on: 19-Feb-2020
 * Created for: ICS4U
 * Day #11 (Board Foot)
 * This program ... Calculates the third dimension, given the two other dimensions, of a board foot.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import javax.swing.JOptionPane;

public class BoardFoot {
	protected Shell frmBoardFoot;
	private Text txtFirstNum;
	private Text txtSecondNum;

	public static void main(String[] args) {
		try {
			BoardFoot window = new BoardFoot();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		frmBoardFoot.open();
		frmBoardFoot.layout();
		while (!frmBoardFoot.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}


	protected void createContents() {
		frmBoardFoot = new Shell();
		frmBoardFoot.setSize(350, 154);
		frmBoardFoot.setText("Board Foot");
		
		Label lblFirstNum = new Label(frmBoardFoot, SWT.NONE);
		lblFirstNum.setBounds(10, 10, 87, 15);
		lblFirstNum.setText("First Dimension: ");
		
		Label lblSecondNum = new Label(frmBoardFoot, SWT.NONE);
		lblSecondNum.setText("Second Dimension: ");
		lblSecondNum.setBounds(10, 61, 104, 15);
		
		txtFirstNum = new Text(frmBoardFoot, SWT.BORDER);
		txtFirstNum.setBounds(10, 31, 76, 21);
		
		txtSecondNum = new Text(frmBoardFoot, SWT.BORDER);
		txtSecondNum.setBounds(10, 84, 76, 21);
		
		Label lblThirdDim = new Label(frmBoardFoot, SWT.NONE);
		lblThirdDim.setBounds(115, 36, 209, 15);
		lblThirdDim.setText("The Third Dimension is : ");
		
		Button btnCalculate = new Button(frmBoardFoot, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//Get the user's inputs as a double
					Double firstDim = Double.parseDouble(txtFirstNum.getText());
					Double secondDim = Double.parseDouble(txtSecondNum.getText());
					//Calculate the third dimension.
					Double thirdDim = 144/(firstDim * secondDim);
					
					lblThirdDim.setText(String.format("The Third Dimension is : %.4f", thirdDim));
				}catch(Exception exc) {
					//Tell the user that they inputted an invalid number.
					JOptionPane.showMessageDialog(null, "You Have Inputted an invalid Number!!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalculate.setBounds(115, 5, 75, 25);
		btnCalculate.setText("Calculate");
	}
}
