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
	
	String columns[]={"BLANK", "Student 1", "Student 2", "Student 3", "Student 4"}; 
	String data[][]={ {"","Student 1","Student 2","Student 3","Student 4"},    
               		  {"Asgin. 1","","","",""},
               		  {"Asgin. 2","","","",""},
               		  {"Asgin. 3","","","",""},
               	  	  {"Asgin. 4","","","",""},
               	  	  {"Asgin. 5","","","",""},
               		  {"Asgin. 6","","","",""}};
	Integer markData[][] = {{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
						   };
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
				for(int row = 1; row <= table.getRowCount() - 1; row++){
					for(int column = 1; column <= table.getColumnCount() - 1; column++) {
						int output = ranInt.nextInt(101);
						table.setValueAt(Integer.toString(output), row, column);
						markData[row - 1][column - 1] = output;
					}
				}
			}
		});
		btnGenerateGrades.setBounds(10, 11, 120, 23);
		contentPane.add(btnGenerateGrades);
	}
	
	public double Average(int[][]studentMarks, int numStudents) {
		System.out.println("Called");
		//variables
		double average = 0.0;
		int mark = 0;
		int totalSum = 0;
		
		//loop through the students
		for (int index = 0; index < studentMarks.length; index++) {
			 
			//loop through each students marks
			for(int marks = 0; marks < studentMarks[1].length; marks ++) {
				
				//get the students mark
				mark = studentMarks[index][marks];
				
				//add to the total
				totalSum = totalSum + mark;
			}
		}
		
		//calculate the average
		average = totalSum/(numStudents * 6);
		
		return average;
	}
}