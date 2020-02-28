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
	//These are variables for the objects that will be created later.
	protected Shell frmMicroWave;
	public static int foodSelected;
	
	//These are variables used to calculate the time required in the microwave (default 1 and 1).
	public static int numItems = 1;
	public static float numITime = 1;
	
	//Automatically created...
	public static void main(String[] args) {
		try {
			MicrowaveGUI window = new MicrowaveGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Automatically created...
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
	//Automatically created...
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
				foodSelected = 60;												//Sets the "foodSelected" integer to 60.
				CalculateTime(foodSelected, numITime, lblTotalTime);	//Calls CalculateTime() passing, foodSelected, numITime, and lblTotalTime as arguments.
			}
		});
		btnSubs.setBounds(10, 31, 75, 25);
		btnSubs.setText("Sub");
		
		
		Button btnPizza = new Button(frmMicroWave, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnPizza.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				foodSelected = 45;												//Sets the "foodSelected" integer to 45.
				CalculateTime(foodSelected, numITime, lblTotalTime);	//Calls CalculateTime() passing, foodSelected, numITime, and lblTotalTime as arguments.
			}
		});
		btnPizza.setText("Pizza");
		btnPizza.setBounds(91, 31, 75, 25);
		
		
		Button btnSoup = new Button(frmMicroWave, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnSoup.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				foodSelected = 105;												//Sets the "foodSelected" integer to 105.
				CalculateTime(foodSelected, numITime, lblTotalTime);	//Calls CalculateTime() passing, foodSelected, numITime, and lblTotalTime as arguments.
			}
		});
		btnSoup.setText("Soup");
		btnSoup.setBounds(172, 31, 75, 25);
		
		
		Button btnOneItem = new Button(frmMicroWave, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnOneItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numItems = 1;												//Sets numItems to 1;
				numITime = 1;												//Sets numITime to 1;
				CalculateTime(foodSelected, numITime, lblTotalTime);	//Calls CalculateTime() passing, foodSelected, numITime, and lblTotalTime as arguments.
			}
		});
		btnOneItem.setBounds(10, 89, 75, 25);
		btnOneItem.setText("1");
		
		
		Button btnTwoItems = new Button(frmMicroWave, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnTwoItems.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numItems = 2;												//Sets numItems to 2;
				numITime = (float) 1.5;										//Sets numITime to 1.5;
				CalculateTime(foodSelected, numITime, lblTotalTime);	//Calls CalculateTime() passing, foodSelected, numITime, and lblTotalTime as arguments.
			}
		});
		btnTwoItems.setText("2");
		btnTwoItems.setBounds(91, 89, 75, 25);
		
		
		Button btnThreeItems = new Button(frmMicroWave, SWT.NONE);
		//This Block of code creates an action listener and attaches it to the button. 
		btnThreeItems.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numItems = 3;												//Sets numItems to 3;
				numITime = 2;												//Sets numITime to 2;
				CalculateTime(foodSelected, numITime, lblTotalTime);	//Calls CalculateTime() passing, foodSelected, numITime, and lblTotalTime as arguments.
			}
		});
		btnThreeItems.setText("3");
		btnThreeItems.setBounds(172, 89, 75, 25);
	}
	
	//This procedure will calculate the required time in the microwave and set the labels text to the output.
	public void CalculateTime(int food, float items, Label lbl) {
		float time = (food * items); //Creates a variable called time and calculates the required time.
		//If the food is a sub...
		if (food == 60) {
			//Change the labels text to tell the required time.
			lbl.setText("The total time in the microwave is : " + numItems + " " + "Sub" +" = " + time + 's');
		  //If the food is a sub...
		} else if(food == 45) {
			//Change the labels text to tell the required time.
			lbl.setText("The total time in the microwave is : " + numItems + " " + "Pizza" +" = " + time + 's');
		  //If the food is a sub...
		} else if (food == 105) {
			//Change the labels text to tell the required time.
			lbl.setText("The total time in the microwave is : " + numItems + " " + "Soup" +" = " + time + 's');
		  //If the food is a sub...
		} else if(food == 0) {
			//Tells the user that there was an error.
			JOptionPane.showMessageDialog(null, "Please select a food item", "An Error has Occurred", JOptionPane.ERROR_MESSAGE);
		}
	}
}
