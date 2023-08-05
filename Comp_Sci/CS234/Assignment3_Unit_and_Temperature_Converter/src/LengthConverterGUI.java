
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LengthConverterGUI extends JFrame implements ActionListener {
    private JLabel lblLength;    //show "Enter the input length (km): "
    private JTextField txtLength; //text box to input the length 
    private JLabel lblDestUnit; //show the text "Choose the units to convert"
    private JComboBox cbbDestUnit; //combo box to select the unit 
    private JButton btnConvert; //button to perform convert
    private JTextArea txtResult; //text box to show the converting result

    /* the constructor method */
    public LengthConverterGUI ( ) {
        //TODO: using setTitle with set the title "Length Converter Program by <YourName>"
        //Note: Replace <YourName> with your real name
    	setTitle("Length Converter Program by Jose Ortega");
        //TODO: set the default close operation with EXIT_ON_CLOSE
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TODO: set the size (300, 240) of the form
    	setSize(300,240);
        //TODO: set the layout FlowLayout
        setLayout(new FlowLayout());
        //initialize the GUI components
        //TODO: init the label lblLength with text 
        lblLength = new JLabel("Enter the length (km): ");
        //TODO: init the textbox txtLength with 10 columns
        txtLength = new JTextField(10);
        //TODO: init the label lblDestUnit with text 
        lblDestUnit = new JLabel("Select the target unit:");
        //Create the string arrays of units
        String[] units = new String[] {"mile", "meter", "inch", "centimeter"};
        //create the combobox for user to select the target unit
        cbbDestUnit = new JComboBox(units);
        //TODO: init the button btnConvert with the text "Convert"
        btnConvert = new JButton("Convert");
        //TODO: init the text area with 5 rows, 20 columns
        txtResult = new JTextArea(5,20);
        
        //add those components to the form
        add(lblLength);
        add(txtLength);
        add(lblDestUnit);
        add(cbbDestUnit);
        add(btnConvert);
        add(txtResult);
        
        //make the form visible
        setVisible(true);
        //TODO: register event handler of "Report" button
        btnConvert.addActionListener(this);

    }

    /* the main method */
    public static void main ( String args [] ) {
        new LengthConverterGUI();
    }

    /* handle user click events */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Implement the event when user click on the Convert button
        //Check if "Convert" button was clicked
        if(e.getSource() == btnConvert) {
            //TODO 1: clear the text in the txtResult by calling setText method with empty string
            txtResult.setText("");
            //TODO 2: double km = get the text from txtLength and convert to double using Double.parseDouble()
			double km = Double.parseDouble(txtLength.getText());
            //TODO 3: int sUnit = get the selected index of target unit in the combo box cbbDestUnit
            int sUnit = cbbDestUnit.getSelectedIndex();
            //TODO 4: use if-else on the selected target unit to convert the input length
            // to the target unit by using the static methods in the UnitConverter class
            // and append to text box txtResult
            if(sUnit == 0) { //select "Mile"
                double miles = UnitConverter.kmToMile(km);
                txtResult.append(km + " kilometer/s is " + 
                        		String.format("%.2f", miles) + " mile/s!");
            }
            //TODO 5: complete for the remaining cases
            else if (sUnit == 1) {//meter
            	double meters = UnitConverter.kmToMeter(km);
            	txtResult.append(km + " kilometer/s is " + 
            					String.format("%.2f", meters) + " meter/s!");
            }
            else if (sUnit == 2) { //inch
            	double inches = UnitConverter.kmToInch(km);
            	txtResult.append(km + " kilometer/s is " +
            					String.format("%.2f", inches) + " inch/es!");
            }
            else  { //cm
            	double cm = UnitConverter.kmToCentimeter(km);
            	txtResult.append(km + " kilometer/s is " +
            					String.format("%.2f", cm) + " centimeter/s!");
            }
        }
    }
}