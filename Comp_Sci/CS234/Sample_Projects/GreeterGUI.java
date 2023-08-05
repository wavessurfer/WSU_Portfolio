
/*
 * File: GreeterGui.java
 * Author: Java Java Java
 * Description: This class provides a graphical user interface for
 *  a greeter application.  The computational object is a Greeter,
 *  which contains a method that simply returns a greeting whenever
 *  it is called.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreeterGUI extends JFrame implements ActionListener
{   private JTextArea display;
    private JTextField inField;
    private JButton goButton;

    public GreeterGUI(String title)
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        display = new JTextArea(10,30);
        inField = new JTextField(10);
        goButton = new JButton("Click here for a greeting!");
        goButton.addActionListener(this);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input your name here: "));
        inputPanel.add(inField);
        inputPanel.add(goButton);
        contentPane.add("Center", display);
        contentPane.add("South", inputPanel);

        setTitle(title);
        // pack();  // packs the components based on the component’s preferred sizes.
        setSize(400, 400);
        setVisible(true);
    } // GreeterGUI()


    public void actionPerformed(ActionEvent e)
    {   if (e.getSource() == goButton)
        {   String name = inField.getText();
            String str = "Hi " + name + " nice to meet you.";
    	    display.append(str + "\n");  // Display a greeting

        }
    } // actionPerformed()

    public static void main(String args[])
    {
        new GreeterGUI("Greeter");
    }
} // GreeterGUI
