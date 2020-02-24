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
	private JPanel contentPane;
	static int[] numbers = new int[10];
	static boolean btnPressed = false;

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
		btnGenerateNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPressed = true;
				if(btnPressed) {
					textArea.setText("");
					btnPressed = false;
					Random ranNum = new Random();
					for(int i = 0; i < numbers.length; i++) {
						numbers[i] = (ranNum.nextInt(100) + 1);
						textArea.setText(textArea.getText() + "\n" + numbers[i]);	
					}
				}else {
					Random ranNum = new Random();
					for(int i = 0; i < numbers.length; i++) {
						numbers[i] = (ranNum.nextInt(99) + 1);
						textArea.setText(textArea.getText() + "\n" + numbers[i]);	
					}
				}
				lblMaxNum.setText("The max Number is : " + GetMax(numbers));
				lblMinNum.setText("The min Number is : " + GetMin(numbers));
			}
		});
		btnGenerateNumbers.setBounds(10, 11, 131, 23);
		contentPane.add(btnGenerateNumbers);
	}
	
	private Integer GetMax(int[] listInts) {
		int maxNumber = 0;
		for(int currentNum : listInts) {
			if(currentNum > maxNumber) {
				maxNumber = currentNum;
			}
		}
		return maxNumber;
	}
	
	private Integer GetMin(int[] listInts) {
		int minNumber = 100;
		for(int currentNum : listInts) {
			if(currentNum < minNumber) {
				minNumber = currentNum;
			}
		}
		return minNumber;
	}
}
