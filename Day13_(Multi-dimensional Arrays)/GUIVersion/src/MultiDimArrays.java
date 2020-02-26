/*
 * Created by: Romy I. Chu III
 * Created on: 25-Feb-2020
 * Created for: ICS4U
 * Day #13 (Multi-Dimensional Arrays)
 * This program ... Creates a 2D array that holds the marks of students
 * 		(Students x Assignments). It will then generate a random number for 
 * 		each position in the array (4 students x 6 assignments), from 0 - 100.
 * 		It will then get the class average.
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MultiDimArrays extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAverage;
	
	//These are just like a template for what the table will look like.
	String columns[]={"","","","",""}; 
	String data[][]={ {"","Student 1","Student 2","Student 3","Student 4"},    
               		  {"Asgin. 1","","","",""},
               		  {"Asgin. 2","","","",""},
               		  {"Asgin. 3","","","",""},
               	  	  {"Asgin. 4","","","",""},
               	  	  {"Asgin. 5","","","",""},
               		  {"Asgin. 6","","","",""}};
	//This will be used to generate a random number.
	Random ranInt = new Random();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiDimArrays frame = new MultiDimArrays();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MultiDimArrays() {
		setTitle("Multi-Dimensional Arrays");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		table = new JTable(data, columns);
		table.setBorder(UIManager.getBorder("ToolTip.border"));
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(11, 43, 315, 112);
		contentPane.add(table);
		
		lblAverage = new JLabel("Class Average  : ");
		lblAverage.setBounds(12, 164, 314, 14);
		contentPane.add(lblAverage);
		
		JButton btnGenerateGrades = new JButton("Generate Grades");
		btnGenerateGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//This is for the marks as an int type.
				int[][] markData = new int[6][4];
				
				//These nested for loops will iterate through the 2D array...
				for(int row = 1; row <= table.getRowCount() - 1; row++){
					for(int column = 1; column <= table.getColumnCount() - 1; column++) {
						//For each space in the 2D array...
						//Generate a random integer, between 0 and 100...
						int output = ranInt.nextInt(101);
						//Change the value of the table, and display it to the user.
						table.setValueAt(Integer.toString(output), row, column);
						//Fill the markData array.
						markData[row - 1][column - 1] = output;
					}
				}
				//This will call the Average function and change the label to display the returned string
				lblAverage.setText(Average(markData) + "%");
			}
		});
		btnGenerateGrades.setBounds(10, 11, 120, 23);
		contentPane.add(btnGenerateGrades);
	}
	
	//This function will take a int 2D array and output a string, which will be the average of all the ints.
	public String Average(int[][] allMarks) {
		double classAverage = 0;		//An int which will be the class average
		String output = "";				//The string that the function will output
		for(int[] row : allMarks) {		//These nested foreach loops will add up all of the numbers in the 2D array.
			for(int block : row) {
				classAverage += block;
			}
		}
		//This calculates the average (the Sum / (# of assignments * # of students))
		classAverage = classAverage / 24;
		//This will return a formated version of the string (max 3 decimal places).
		return output.format("Class Average  : %.3f", classAverage);
	}
}