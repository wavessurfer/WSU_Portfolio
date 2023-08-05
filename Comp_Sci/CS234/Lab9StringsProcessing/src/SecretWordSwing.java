/**
  * Class Name: SecretWordSwing 
  * Author: Jose Ortega
  * Date: 04/12/21
  * Role: GUI interface to play the Secret Word Game
  * Problem Description:
  * 	Lab9StringsProcessing, we will develop Java application to simulate the Guess Secret Word game.
  * 	This game lets the user make repeated guesses at the letters contained in a secret word.
  * 	The secret word is shown in masked form. For example, if the secret word is hello, it 
  * 	would be displayed as *****. Each time the user makes a guess, the application reports
  * 	whether the guess is correct or not and displays the updated version of the secret word.
  * 	For example, if on the first guess the user guesses 'e', the secret word would be displayed as *e***.
  * Enumerate all the inputs and outputs for your application:
  *  String ch = character for every guess of a letter in the secretword
  *  String secretWord = The secret word
  *  String displayedWord = Word where correct guesses are shown
  * List all the java packages that need to be imported:
  * - java.awt.*
  * - java.awt.event.*
  * - javax.swing.*
  * Describe specifically your input and output screen formats – 
  *    New game: current secret word: ****
  *    Enter your guessed character: 
  *    o
  *    That Guess Was Right **o*
  *    Enter your guessed character: 
  *    s
  *    That Guess Was Wrong **o*
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SecretWordSwing extends JFrame implements ActionListener {
	private JLabel lblEnterChar;	    //label to prompt user to enter character
	private JTextField txtGuessChar;    //the text box to enter guess character
	private JButton btnNewGame;	    //button to create a new game
	private JTextArea txtOutputs;       //text area to log all guesses and results
	private SecretWord gameEngine;      //object to handle game play
	private int numberOfGuesses;        //the number of guesses so far
	
	public SecretWordSwing() {
	    //TODO 1. init the game engine 
		gameEngine = new SecretWord(); 
	    //TODO 2. init the numberOfGuesses with 0 
		numberOfGuesses = 0;
	    //TODO 3. set the title of the GUI using the setTitle() method 
		setTitle("Secret Word by Jose Ortega");
	    //TODO 4. set the default close operation
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //TODO 5. set the size of the form: 
		setSize(450, 280); 
	    //TODO 6. set layout with new instance of FlowLayout
		setLayout(new FlowLayout());
	    
	    //init the GUI components
	    //7. init the label lblEnterChar
	    lblEnterChar = new JLabel("Enter a letter you think is in the secret word:");
	    //8. init the text box txtGuessChar
	    txtGuessChar = new JTextField(5);
	    //9. make it editable
	    txtGuessChar.setEditable(true);
	    //10. init the button btnNewGame
	    btnNewGame = new JButton("New Game");
	    //11. init the text area txtOutputs with 10 rows, 35 columns
	    txtOutputs = new JTextArea(10,35);
	    //12. automatically add JScrollPane to the text area txtOutpus
	    JScrollPane sp = new JScrollPane(txtOutputs);   // JTextArea is placed in a JScrollPane.
	    //13. append the new game state and the current secret word to txtOutputs
	    txtOutputs.append("New game: the current secret word: " + gameEngine.getDisplayedWord() +"\n");   
	    
	    //14. add GUI components to form
	    add(lblEnterChar);
	    add(txtGuessChar);
	    add(btnNewGame);
	    add(sp);
	    
	    //15. set location null to make the form center of the screen
	    setLocationRelativeTo(null);
	    //TODO 16. make the form visible by calling setVisible with argument true
	    setVisible(true);
	    
	  //add this class as the action listener of btnNewGame and txtGuessChar
	    btnNewGame.addActionListener(this);
	    txtGuessChar.addActionListener(this);
	    
	}
	
	public static void main(String[] args) { 
	    new SecretWordSwing();
	}
	
	
	public void actionPerformed(ActionEvent e) { 
	    //if e.getSource() equals to btnNewGame => btnNewGame was clicked
	    if (e.getSource() == btnNewGame) {
	        //re-init the gameEngine object
	        gameEngine = new SecretWord();
	        //TODO: reset the number of guesses to 0
	        
	        //append new game state to txtOutputs
	        txtOutputs.append("New game: the current secret word: " + gameEngine.getDisplayedWord() +"\n");
	    }
	    
	    //else if user press ENTER on txtGuessChar
	    else if(e.getSource() == txtGuessChar) {
	        //get the guess char that user enter 
	        String inputString = txtGuessChar.getText();
	        //TODO: increase the number of guesses
	        
	        //clear the text in txtGuessChar so user can enter again
	        txtGuessChar.setText("");
	        //check the guess result and update game state
	        boolean guess = gameEngine.makeGuess(inputString.charAt(0));
	        // Process the user's guess
	        if (guess) 
	            txtOutputs.append ("Guess " + numberOfGuesses++ + " Was Right " + gameEngine.getDisplayedWord() + "\n");
	        else 
	            txtOutputs.append ("Guess " + numberOfGuesses++ + " Was Wrong " + gameEngine.getDisplayedWord() + "\n");
	        // check if the game is finished => append congrats text
	        if(gameEngine.isFinished()) {
	            txtOutputs.append("Congratulations, you won!\n");
	        }
	        //move caret to end of the text area
	        txtOutputs.setCaretPosition(txtOutputs.getDocument().getLength());
	    }
	}
	
	
}
