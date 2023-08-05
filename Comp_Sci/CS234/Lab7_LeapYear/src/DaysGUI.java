/**
  * Class Name: DaysGUI
  * Author: Jose Ortega
  * Date: 03/11/2020\1
  * Problem Description: Lab7_LeapYear is an interactive application that determines how many days a specific month in a specific year has.
  * Also, it can recognize if that year was leap or not 
  * Goals of your application:
  * 	1. Print if the selected year is leap or not
  * 	2. Print the number of days of the selected month
  * 	3. Print the inputed date
  * Inputs:
 *      -int day
 *      -int year
 *      -String month
 * Outputs:
 *      - String "report"
 * Required packages: java.awt.*, java.awt.event.*; javax.swing.*
 * Test cases:
 *      Enter the date: JTextField(25) JComboBox(February) JTextField(1992)
 *      						btnReport(Report)
 *      JTextArea(	1992 is leap year
 *      			February has 29 days
					User has entered 25 )

 * Pseudo code:
 *     Step 1: Read the date with JFrame
 *     Step 2: Determine if it is Leap Year
 *     Step 3: Determine how many days the month selected in the specified year has
 *     Step 4: Deliver results
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DaysGUI extends JFrame implements ActionListener, KeyListener {
	private JLabel lblDate; //show "Enter the date: "
	private JTextField txtDay; //text box to enter the day
	private JComboBox cbbMonth; //combo box to select month
	private JTextField txtYear; //text box to enter the year
	private JButton btnReport; //button "Report"
	private JTextArea txtReport; //text box to show report

	
public DaysGUI() {
    //1. set the title of the GUI using the setTitle() method
	setTitle("Days in Month GUI App by Jose Ortega");
    //2. set the default close operation: setDefaultCloseOperation(EXIT_ON_CLOSE);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	//3. set the size of the form: setSize(350, 250);
	setSize(350, 250); 
    //4. set the layout: setLayout(new FlowLayout());
	setLayout(new FlowLayout());
    //5. create the instance lblDate
	lblDate = new JLabel("Enter the date:");
    //6. create the instance txtDay with 4 columns
	txtDay = new JTextField(4);
    //7. create the instance of string array named months
	String[] months = { "Month", "January", "February", "March", 
						"April", "May", "June", 
						"July", "August", "September", 
						"October", "November", "December" };
    //8. create the combobox cbbMonth
    cbbMonth = new JComboBox(months);
    //9. create the instance txtYear with 5 columns
    txtYear = new JTextField(5);
    //10. create the button btnReport with the text "Report"
    btnReport = new JButton("Report");
    //11. create the text area txtReport with 7 rows and 25 columns
    txtReport = new JTextArea(7,25);
    //12. make the text area txtReport not editable by calling txtReport.setEditable(false);
    txtReport.setEditable(false);
    //13. add all components to the form by calling the add() method like below:
    add(lblDate);
    add(txtDay);
    add(cbbMonth);
    add(txtYear);
    add(btnReport);
    add(txtReport);
    
    //14. make the form visible by calling setVisible with argument true
    setVisible(true);

    //add this class as the action listener of btnReport
     btnReport.addActionListener(this);
    //add this class as the key listener of txtYear
     txtYear.addKeyListener(this);
	}

public void report() {
    //1. TODO: clear the text in the txtReport by using setText() with empty string ""
	txtReport.setText("");
    //2. declare a String variable named yearStr = the text in the txtYear
    String yearStr = txtYear.getText();
    //3. check the leap year
    try {
        //TODO: 4. declare an integer year = parse integer from yearStr
        int year = Integer.parseInt(yearStr);
        //5. declare a boolean variable isLeapYear = Days.isLeapYear(year)
        boolean isLeapYear = Days.isLeapYear(year);
        //6. check if isLeapYear is true
        if(isLeapYear) {
            //7. append the text in txtYear + " is leap year\n" to txtReport
            txtReport.append(txtYear.getText() + " is leap year\n");
        }
        else {
            //8. TODO: similar to 7, append txtYear.getText() + " is not leap year\n" to txtReport
        	txtReport.append(txtYear.getText() + " is not leap year\n");
        }
        //report the days in the selected month
        //9. int month = get the selected month in cbbMonth
        int month = cbbMonth.getSelectedIndex();
        //10. check if month is greater than 0 and less than or equals to 12
        if(month > 0 && month <= 12) {
            //11. get the selected month
            String monthStr = cbbMonth.getSelectedItem().toString();
            //12. get how many days in the month by using Days.howManyDays()
            int daysInMonth = Days.howManyDays(month, year) ;
            //13. report the days in month and append to txtReport
            txtReport.append(monthStr + " has "	+ daysInMonth + " days\n");
        }
        else {
            //14. TODO, similar to 13, report that month is not selected and append to txtReport
            txtReport.append("You haven't selected the month\n");
        }
    } 
    catch (NumberFormatException e) {
        //15. TODO: similar to 7, append the text in txtYear + " is not a valid year\n" to txtReport
        txtReport.append(txtYear.getText() + " is not a valid year\n");
    }
    //check the day entered in txtDay
    //16. get the selected day
    String dayStr = txtDay.getText();
    try {
        //17. TODO: declare an integer day = parse integer from dayStr
    	int day = Integer.parseInt(dayStr);
        //18. report the day and append to the txtReport
        txtReport.append("User has entered " + day + " \n");
    } catch (NumberFormatException e) {
        //19. TODO: append the text in txtDay + " is not a valid day\n" to txtReport
    	txtReport.append(txtDay.getText() + " is not a valid day\n");
    }
}

public void actionPerformed( ActionEvent e) { 
    //if e.getSource() equals to btnReport => btnReport was clicked
    if (e.getSource() == btnReport) {
        //TODO: call the report() method
    	report();
    	}
	}
    
    public void keyPressed(KeyEvent e) { 
        //if e.getSource() equals to txtYear => key was pressed on the txtYear
        if (e.getSource() == txtYear) {
            // if e.getKeyCode() equals to KeyEvent.VK_ENTER, that means ENTER key was pressed
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                //TODO: call the report() method
            	report();
            }
        }
    } 

// copy the following code
public void keyReleased(KeyEvent arg0){
    }

public void keyTyped(KeyEvent arg0){
    }
    
public static void main(String[] args) { 
    new DaysGUI();
	}

}