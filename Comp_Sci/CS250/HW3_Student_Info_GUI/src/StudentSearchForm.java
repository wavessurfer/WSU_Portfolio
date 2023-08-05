/*
*Author: Jose Ortega
*Assignment: Homework #3
*Date: 10/12/2021
*
*Problem Description: Develop a Java GUI application to read a text file containing students’ information into your program. Then, the users can search for a specific student by entering the student’s ID.
*Goals: Accurately read an array of Students, sort it, find students with their ID, and print them into the GUI Form
*Inputs:	students.txt
*			int ID, t, year;
			String name, email;
*Output:	Student: 847342, Kaitlin Goyette, 2015, kaitlin.goyette@test.edu
*
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentSearchForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchValue;
	private JTextArea textArea;
	private Student[] arr;
	
	
	/**
	 * This method reads the student.txt file and create a Student[] array to store the data
	 * 
	 * File and FileReader read the txt file
	 * Buffered Reader reads line per line with readLine()
	 * stores each line in a String[] array
	 * stores each Student data in a Student[] array
	 * @param filepath
	 * @return
	 */
	private void loadStudent(String filepath) {
		File infile = new File (filepath);
		try (BufferedReader br = new BufferedReader (new FileReader (infile));) {
			String line;
			line = br.readLine();
			int len = Integer.parseInt(line);
			arr = new Student[len];
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",\\s");
				int id = Integer.parseInt(str[0]);
				String name = str[1];
				int year = Integer.parseInt(str[2]);
				String email = str[3];
				Student obj = new Student(id, name, year, email);
				arr[count] = obj;
				count++;
			}
			
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("File " + filepath + "does not exist!");
		} catch(IOException ex) {
			System.out.println("File " + filepath + "could not be read!");
		} catch(NumberFormatException nfe) {
			System.out.println("Invalid inputs in the file " + filepath);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("Check the total number of records in the file " + filepath);
		}
		
		for (Student stud : arr)
			System.out.print(stud + "\n");
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSearchForm frame = new StudentSearchForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	* Use binary search to search for the id index target in arr.
	* Return -1 if not found
	*/
	private int binarySearch (Student[] arr, int id) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (id == arr[mid].getID())
				return mid;
			else if ( id > arr[mid].getID())
				low = mid + 1;
			else
				high = mid -1;
		}
		return -1;
	}
	

	/**
	 * Create the frame.
	 */
	public StudentSearchForm() {
		setTitle("Student Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSearchValue = new JLabel("Search Value");
		GridBagConstraints gbc_lblSearchValue = new GridBagConstraints();
		gbc_lblSearchValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchValue.gridx = 2;
		gbc_lblSearchValue.gridy = 0;
		contentPane.add(lblSearchValue, gbc_lblSearchValue);
		
		txtSearchValue = new JTextField();
		GridBagConstraints gbc_txtSearchValue = new GridBagConstraints();
		gbc_txtSearchValue.gridwidth = 3;
		gbc_txtSearchValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearchValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchValue.gridx = 3;
		gbc_txtSearchValue.gridy = 0;
		contentPane.add(txtSearchValue, gbc_txtSearchValue);
		txtSearchValue.setColumns(10);
		
		/**
		 * This method makes the Search btn use the user's input of student ID to find it through the binary search method and appends the info in the textArea
		 */
		
		JButton btnSearch = new JButton("Search");		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					int sID = Integer.parseInt(txtSearchValue.getText());
					int index = binarySearch(arr, sID);
					if (index == -1)
						textArea.append("Could not find any student with ID= " + sID + "\n");
					else
						textArea.append("Found the student with ID= " + sID + ": " + arr[index] + "\n");
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}	
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.gridwidth = 2;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 1;
		contentPane.add(btnSearch, gbc_btnSearch);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.gridwidth = 5;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		contentPane.add(textArea, gbc_textArea);
		
		loadStudent("src/students.txt");
		
		Arrays.sort(arr, new Comparator <Student> () {
			public int compare(Student s1, Student s2) {
				return s1.getID() - s2.getID();
			}
		});
				
	}

}
