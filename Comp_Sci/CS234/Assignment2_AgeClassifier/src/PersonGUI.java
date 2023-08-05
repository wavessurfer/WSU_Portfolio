/*
 * Class name: PersonGUI
 * Author: Jose Ortega
 * Date: 2/22/21
 * Problem: PersonGUI is an application that will differentiate between users' age and print respective age classifications. This will happen in a GUI window.
 * Goals:
 *      - Print age classifications according to users' input of year of birth.
 * Inputs:
 *      -string name
 *      -int birthyear
 * Outputs:
 *      - int age
 * Required packages: java.awt.*; javax.swing.*; java.awt.event.*
 * Test cases:
 *      Enter the name: Test Person
 *      Enter the year of birth: 1996
 *      -------------------------
 *      Name: Test Person
 *      Age: 25 years old
 *      Age Classification: Adult
 * Pseudo code:
 *     Step 1: Read name with JtextField.getText()
 *     Step 2: Read year of birth with JtextField.getText()
 *     Step 3: Get age by creating a calling an app obejct from AgeClassifer class
 *     Step 4: Deliver results of age classification
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PersonGUI extends JFrame implements ActionListener {
    private JLabel lblName;    //the name label
    private JTextField txtName;    //the name text box
    private JLabel lblYear;  //the year label
    private JTextField txtYear;  //the year text box
    private JButton btnReport;  //the Report button
    private JTextArea lblAgeReport; //reporting name, age and classification label

    /* the constructor method */
    public PersonGUI ( ) {
        setTitle("Person GUI program");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setSize(250, 200);
        setLayout(new FlowLayout());
        
        //initialize the GUI components
        lblName = new JLabel("Enter the name: ");
        txtName = new JTextField(10);
        lblYear = new JLabel("Enter the year: ");
        txtYear = new JTextField(10);
        btnReport = new JButton("Report age and classification");
        lblAgeReport = new JTextArea(5,20);
        lblAgeReport.setEditable(false);
        
        //add those components to the form
        add(lblName);
        add(txtName);
        add(lblYear);
        add(txtYear);
        add(btnReport);
        add(lblAgeReport);
        
        //make the form visible
        setVisible(true);
        
        //TODO: register event handler of "Report" button
        btnReport.addActionListener(this);
    }

    /* the main method */
    public static void main ( String args [] ) {
        new PersonGUI();
    }

    /* handle user click events */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Implement the event when user click on the Report button
        //Check if "Report" button was clicked
        if(e.getSource() == btnReport) {
            //TODO: clear the text in the lblAgeReport by calling setText method with empty string
        	lblAgeReport.setText("");
            
            //TODO: call the append() method of lblAgeReport to show the Name
            //      remember to put new line character at the end
        	String name = txtName.getText();
            lblAgeReport.append("Name: " + name + "\n");
			
            //TODO: create a String variable that get the year entered by user (txtYear)
            String year = txtYear.getText();
            
            //TODO: use Integer.parseInt with above String variable to get the birth year (integer variable)
            int birthyear = Integer.parseInt(year);
			
            //TODO: calculate the age and store as an integer variable
            AgeClassifier app = new AgeClassifier(name, birthyear);            
           
            //TODO: call the append() method of lblAgeReport to show the Age
            lblAgeReport.append("Age: " + app.getAge() + "\n");

			
            //TODO: if-else statement to check the age and report the age classification
            //      by appending to the lblAgeReport
            lblAgeReport.append("Classification:" + app.getAgeClassification(app.getAge()));
        }
    }
}