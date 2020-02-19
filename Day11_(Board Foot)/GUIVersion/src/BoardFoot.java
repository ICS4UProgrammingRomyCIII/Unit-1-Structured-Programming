import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class BoardFoot {

	protected Shell frmBoardFoot;
	private Text txtFirstNum;
	private Text txtSecondNum;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BoardFoot window = new BoardFoot();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
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
		frmBoardFoot.setSize(451, 132);
		frmBoardFoot.setText("Board Foot");
		
		Label lblFirstNum = new Label(frmBoardFoot, SWT.NONE);
		lblFirstNum.setBounds(10, 10, 87, 15);
		lblFirstNum.setText("First Number : ");
		
		Label lblSecondNum = new Label(frmBoardFoot, SWT.NONE);
		lblSecondNum.setText("Second Number : ");
		lblSecondNum.setBounds(10, 50, 104, 15);
		
		txtFirstNum = new Text(frmBoardFoot, SWT.BORDER);
		txtFirstNum.setBounds(10, 23, 76, 21);
		
		txtSecondNum = new Text(frmBoardFoot, SWT.BORDER);
		txtSecondNum.setBounds(10, 64, 76, 21);
		
		Button btnCalculate = new Button(frmBoardFoot, SWT.NONE);
		btnCalculate.setBounds(115, 5, 75, 25);
		btnCalculate.setText("Calculate");
		
		Label lblThirdDim = new Label(frmBoardFoot, SWT.NONE);
		lblThirdDim.setBounds(120, 39, 184, 15);
		lblThirdDim.setText("The Third Dimension is : ");

	}
}
