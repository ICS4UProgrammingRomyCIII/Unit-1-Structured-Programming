/*
 * Created by: Romy I. Chu III
 * Created on: 24-Feb-2020
 * Created for: ICS4U
 * Day #12 (Max and Min Numbers)
 * This program ... Randomly generates 10 numbers and gets the minimum and maximum number from those 10 numbers.
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class MaxAndMinNumbers extends JFrame {
	//These are variables for the objects that will be created later.
	private JPanel contentPane;
	
	static int[] numbers = new int[10]; // An array to store 10 random integers.

	//Automatically created...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaxAndMinNumbers frame = new MaxAndMinNumbers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Automatically created...
	public MaxAndMinNumbers() {
		setTitle("Max and Min Numbers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMinNum = new JLabel("The min Number is : ");
		lblMinNum.setBounds(10, 43, 149, 14);
		contentPane.add(lblMinNum);
		
		JLabel lblMaxNum = new JLabel("The max Number is : ");
		lblMaxNum.setBounds(10, 68, 149, 14);
		contentPane.add(lblMaxNum);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(169, 10, 71, 163);
		contentPane.add(textArea);
		
		JButton btnGenerateNumbers = new JButton("Generate \r\n\r\nNumbers");
		//This Block of code creates an action listener and attaches it to the button. 
		btnGenerateNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");							  // Clears the text area.
				Random ranNum = new Random();						  // Creates a new Random Object.			
				for(int i = 0; i < numbers.length; i++) {				  // For when integer i is less than the array length of numbers.		
					//This if-else statment prevents the first line in the text area from being a '\n'.
					if(numbers[0] == 0) {						  // If numbers[0] is 0.
						numbers[i] = (ranNum.nextInt(100) + 1);			  // Generate a random number and add it to the array.
						textArea.setText(textArea.getText() + numbers[i]);	  // Add the number to the text area.
					}else {								  // Otherwise...
						numbers[i] = (ranNum.nextInt(100) + 1);			  // Generate a random number and add it to the array.
						textArea.setText(textArea.getText() + "\n" + numbers[i]); // Add '\n' and the random number to the text area.
					}
				}
				lblMaxNum.setText("The max Number is : " + GetMax(numbers));		  // Gets the largest number.
				lblMinNum.setText("The min Number is : " + GetMin(numbers));		  // Gets the smallest number.
			}
		});
		btnGenerateNumbers.setBounds(10, 11, 131, 23);
		contentPane.add(btnGenerateNumbers);
	}
	
	// This function gets the largest number in an array.
	private Integer GetMax(int[] listInts) {
		int maxNumber = 0;			// Create a variable for the max number.
		for(int currentNum : listInts) {	// For each integer in the array...
			if(currentNum > maxNumber) {	// If the current number (in the array) is bigger than the maxNumber...
				maxNumber = currentNum; // Make the current nunmber the new maxNumber.
			}
		}
		return maxNumber;			// Return the maxNumber.
	}
	// This function gets the smallest number in an array.
	private Integer GetMin(int[] listInts) {
		int minNumber = 100;			// Create a variable for the min number.
		for(int currentNum : listInts) {	// For each integer in the array...
			if(currentNum < minNumber) {    // If the current number (in the array) is smaller than the minNumber...
				minNumber = currentNum; // Make the current nunmber the new minNumber.
			}
		}
		return minNumber;			// Return the minNumber.
	}
}
