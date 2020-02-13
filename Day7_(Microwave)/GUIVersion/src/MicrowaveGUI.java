/*
 * Created by: Romy I. Chu III
 * Created on: 10-Feb-2019
 * Created for: ICS4U
 * Day #7 (Calculator)
 * This program ... Calculates the required microwaving time for a specified food item.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import javax.swing.JOptionPane;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MicrowaveGUI {
	protected Shell frmMicroWave;
	public static int foodSelected;
	public static int numItems = 1;
	public static float numITime = 1;
	
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
		frmMicroWave.open();
		frmMicroWave.layout();
		while (!frmMicroWave.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		frmMicroWave = new Shell();
		frmMicroWave.setSize(445, 199);
		frmMicroWave.setText("Microwave Time");
		
		Label lblSelectTheFood = new Label(frmMicroWave, SWT.NONE);
		lblSelectTheFood.setBounds(10, 10, 275, 15);
		lblSelectTheFood.setText("Select the food you want to put in the microwave : ");
		
		Label lblHow = new Label(frmMicroWave, SWT.NONE);
		lblHow.setBounds(10, 68, 106, 15);
		lblHow.setText("Number of Items : ");
		
		Label lblTotalTime = new Label(frmMicroWave, SWT.NONE);
		lblTotalTime.setBounds(10, 134, 414, 15);
		lblTotalTime.setText("The total time in the microwave is : ");
		
		
		Button btnSubs = new Button(frmMicroWave, SWT.NONE);
		btnSubs.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				foodSelected = 60;
				CalculateTime("Subs", foodSelected, numITime, lblTotalTime);
			}
		});
		btnSubs.setBounds(10, 31, 75, 25);
		btnSubs.setText("Sub");
		
		
		Button btnPizza = new Button(frmMicroWave, SWT.NONE);
		btnPizza.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				foodSelected = 45;
				CalculateTime("Pizzas", foodSelected, numITime, lblTotalTime);
			}
		});
		btnPizza.setText("Pizza");
		btnPizza.setBounds(91, 31, 75, 25);
		
		
		Button btnSoup = new Button(frmMicroWave, SWT.NONE);
		btnSoup.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				foodSelected = 105;
				CalculateTime("Soups", foodSelected, numITime, lblTotalTime);
			}
		});
		btnSoup.setText("Soup");
		btnSoup.setBounds(172, 31, 75, 25);
		
		
		
		
		Button btnOneItem = new Button(frmMicroWave, SWT.NONE);
		btnOneItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numItems = 1;
				numITime = 1;
				CalculateTime("Soups", foodSelected, numITime, lblTotalTime);
			}
		});
		btnOneItem.setBounds(10, 89, 75, 25);
		btnOneItem.setText("1");
		
		
		Button btnTwoItems = new Button(frmMicroWave, SWT.NONE);
		btnTwoItems.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numItems = 2;
				numITime = (float) 1.5;
				CalculateTime("Soups", foodSelected, numITime, lblTotalTime);
			}
		});
		btnTwoItems.setText("2");
		btnTwoItems.setBounds(91, 89, 75, 25);
		
		
		Button btnThreeItems = new Button(frmMicroWave, SWT.NONE);
		btnThreeItems.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numItems = 3;
				numITime = 2;
				CalculateTime("Soups", foodSelected, numITime, lblTotalTime);
			}
		});
		btnThreeItems.setText("3");
		btnThreeItems.setBounds(172, 89, 75, 25);
	}
	
	public void CalculateTime(String type, int food, float items, Label lbl) {
		if (food == 0) {
			JOptionPane.showMessageDialog(null, "Please select a food item", "An Error has Occurred", JOptionPane.ERROR_MESSAGE);
		}
		float time = (food * items);
		lbl.setText("The total time in the microwave is : " + numItems + " " + type +" = " + time + 's');
	}
}
