import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import javax.swing.JOptionPane;

public class HelloWorldGUI {
	//These are variables for the objects that will be created later.
	protected Shell frmWhat;
	Button btnSurprise;
	
	//Automatically created...
	public static void main(String[] args) {
		try {
			HelloWorldGUI window = new HelloWorldGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Automatically created...
	void open() {
		Display display = Display.getDefault();
		createContents();
		frmWhat.open();
		frmWhat.layout();
		while (!frmWhat.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	//Automatically created...
	protected void createContents() {
		frmWhat = new Shell();
		frmWhat.setBackground(SWTResourceManager.getColor(255, 255, 255));
		frmWhat.setSize(208, 162);
		frmWhat.setText("What?");
		
		btnSurprise = new Button(frmWhat, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnSurprise.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Opens a message box and displays a message
				JOptionPane.showMessageDialog(null, "Hello Small world of ICS4U Programming!!");
			}
		});
		btnSurprise.setBounds(10, 10, 172, 103);
		btnSurprise.setText("Surprise!!");

	}
}
