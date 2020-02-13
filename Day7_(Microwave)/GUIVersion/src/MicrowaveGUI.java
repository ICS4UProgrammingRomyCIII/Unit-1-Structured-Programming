/*
 * Created by: Romy I. Chu III
 * Created on: 10-Feb-2019
 * Created for: ICS4U
 * Day #7 (Calculator)
 * This program ... Calculates the required microwaving time for a specified food item.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MicrowaveGUI {
	protected Shell shell;
	public static void main(String[] args) {
		try {
			MicrowaveGUI window = new MicrowaveGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}

}
