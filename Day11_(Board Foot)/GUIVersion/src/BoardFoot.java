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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		frmBoardFoot = new Shell();
		frmBoardFoot.setSize(350, 132);
		frmBoardFoot.setText("Board Foot");
		
		Label lblFirstNum = new Label(frmBoardFoot, SWT.NONE);
		lblFirstNum.setBounds(10, 10, 87, 15);
		lblFirstNum.setText("First Dimension: ");
		
		Label lblSecondNum = new Label(frmBoardFoot, SWT.NONE);
		lblSecondNum.setText("Second Dimension: ");
		lblSecondNum.setBounds(10, 50, 104, 15);
		
		txtFirstNum = new Text(frmBoardFoot, SWT.BORDER);
		txtFirstNum.setBounds(10, 23, 76, 21);
		
		txtSecondNum = new Text(frmBoardFoot, SWT.BORDER);
		txtSecondNum.setBounds(10, 64, 76, 21);
		
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
					
					lblThirdDim.setText("The Third Dimension is : " + (144/(firstDim * secondDim)));
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
