/*
 * Created by: Romy I. Chu III
 * Created on: 03-March-2020
 * Created for: ICS4U
 * Day #15 (Student ADT)
 * This program ... Takes the information for a student and uses an ADT to hold the information then displays it to the user.
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentADT extends JFrame {

	// These are variables for the objects that will be created later.
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMiddleInit;
	
	// Variables
	int studentGrade;
	
	// Automatically Created...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentADT frame = new StudentADT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Automatically Created...
	public StudentADT() {
		setTitle("Student ADT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name : ");
		lblFirstName.setBounds(10, 10, 87, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setBounds(10, 40, 87, 20);
		contentPane.add(lblLastName);
		
		JLabel lblMiddleInit = new JLabel("Middle Initial : ");
		lblMiddleInit.setBounds(10, 70, 87, 20);
		contentPane.add(lblMiddleInit);
		
		JLabel lblGrade = new JLabel("Grade  : ");
		lblGrade.setBounds(10, 101, 70, 20);
		contentPane.add(lblGrade);
		
		JLabel lblIdentified = new JLabel("Identified : ");
		lblIdentified.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdentified.setBounds(10, 132, 70, 20);
		contentPane.add(lblIdentified);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(107, 10, 90, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(107, 40, 90, 20);
		contentPane.add(txtLastName);
		
		txtMiddleInit = new JTextField();
		txtMiddleInit.setColumns(10);
		txtMiddleInit.setBounds(107, 70, 90, 20);
		contentPane.add(txtMiddleInit);
		
		JComboBox<Object> cmbGrade = new JComboBox<Object>();
		cmbGrade.setModel(new DefaultComboBoxModel<Object>(new String[] {" ","7", "8", "9", "10", "11", "12"}));
		cmbGrade.setBounds(107, 101, 70, 20);
		contentPane.add(cmbGrade);
		
		JCheckBox chkIdentified = new JCheckBox("");
		chkIdentified.setBounds(107, 132, 97, 20);
		contentPane.add(chkIdentified);
		
		JButton btnEnterInfo = new JButton("Enter");
		//This Block of code creates an action listener and attaches it to the button. 
		btnEnterInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// This try-catch loop will catch any errors that occur during runtime.
				// The procedure will try to...
				try {
					StudentInfo studentInfo = new StudentInfo();							  // Creates a new Object for the studentInfo class.
					studentInfo.firstName = txtFirstName.getText();							  // Get the student's first name from the text box.
					studentInfo.lastName = txtLastName.getText();							  // Get the student's last name from the text box.
					studentInfo.middleInitial = txtMiddleInit.getText();					  // Get the student's middle initial from the text box.
					studentInfo.grade = Integer.parseInt((String) cmbGrade.getSelectedItem());// Get the student's grade from the combo box.
					if(chkIdentified.isSelected()) {										  // If the student is identified...
						studentInfo.identified = "identified";						   		  // Say that the student is identified.
					} else {																  // Otherwise...
						studentInfo.identified = "not identified";							  // Say that the student isn't identified.
					}
					if(studentInfo.firstName == null || studentInfo.lastName == null) {		  // If the user didn't input the first or last name... cause an exception.
					} else {																  // Otherwise...
						studentInfo.Display();												  // Display the student's information.
					}
				  // If an exception occurs during runtime...
				} catch (Exception exc) {
					// Tell the user that they didn't enter the required information.
					JOptionPane.showMessageDialog(null, "The information that has been inputed is incorrect.\n You need at least the first and last name!!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnterInfo.setBounds(207, 10, 109, 59);
		contentPane.add(btnEnterInfo);
	}

	
	//create a class for the students
	class StudentInfo {
			String firstName;		// A string for the student's first name.
			String lastName;		// A string for the student's last name.
			String middleInitial;   // A string for the student's middle initial.
			int grade;				// An int for the student's grade.
			String identified;		// A string for the student's identification.
			
			// A function that will display the student's information
			public void Display() {
				// format a string to output the information.
				String output = String.format("%s %s %s is in grade %d and is %s", firstName, middleInitial, lastName, grade, identified);
				// Display the information to the user
				JOptionPane.showMessageDialog(null, output);
			}
	}
}
