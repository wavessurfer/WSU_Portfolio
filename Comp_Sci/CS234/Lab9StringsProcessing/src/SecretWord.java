import java.lang.Math;
import java.util.Scanner;

public class SecretWord {
    /* declare instance variables */
    //array of words that can be used as secret word
    private final String[] WORDS = new String[] {
        "dog", "cat", "wolf", "dolphin", "tiger",
        "penguin", "lion", "horse", "fox", "panda",
        "bison", "eagle", "lobster", "monkey", "rabbit",
        "elephant", "giraffe", "leopard", "cheetah", "gorilla",
        "polar bear", "gray wolf", "mosquito", "armadillo", "wobbegong" };
    private String secretWord;   // The secret word
    private String displayedWord;  // Word where correct guesses are shown
    
    /* constructor method */
    public SecretWord() {
        //1. create a random index from 0 to WORDS.length
        int randomIndex = (int)(Math.random() * WORDS.length);
        //2. secret word = the random index word in the array
        secretWord = WORDS[randomIndex];
        //3. get the displayed word (default all '*')
        displayedWord = replaceChars(secretWord, '*');
    }
    
    /* return returns the secret word */
    public String getSecretWord() {
        return secretWord;
    }

    /* returns displayedWord which shows the progress of the guessing game */
    public String getDisplayedWord () {
        return displayedWord;
    }
	
    /* replaces each character of its String parameter
     *  with the character given as its char parameter. */
    private String replaceChars(String s, char ch) {
        //TODO: Implement the code of this method below
    	StringBuffer result = new StringBuffer(""); // create an instance of StringBuffer
    	for (int i = 0; i < s.length() ; i++)
    		result.append(ch);
    		
    	return result.toString();
    }

    /* replaces in s2 every occurrence of ch in s1. 
     *  For example, if replaceChars("hello", "*e***", 'l') would return "*ell*". */
    private String replaceChars(String s1, String s2, char ch) {
        //TODO: Implement the code of this method below
    	StringBuffer result = new StringBuffer(""); // create an instance of StringBuffer
    	for (int i = 0; i < secretWord.length(); i++){
    		
    	    if (s1.charAt(i) == ch)
    	       result.append(s1.charAt(i));
    	    else result.append(s2.charAt(i));
    	}
    	return result.toString();
    }

    /* checks whether its char parameter is
        *  contained in the secret word
        * The blank position is always the last element in the array */
    public boolean makeGuess(char ch) {
        //TODO: Implement the code of this method below
    	//index of ch in the string secretWord
    	int i = secretWord.indexOf(ch);
		if (i >= 0) { //the guess character is exist in the secret word
    		//get the new displayedWord by calling replaceChars() method
    		displayedWord = replaceChars(secretWord, displayedWord, ch);
    		return true;
			} 
			else return false;
    }   	 
 

    /* This method determines if the game is finished or not */
    public boolean isFinished() {
        //TODO: Implement the code of this method below
    	//i = index of '*' in the string displayedWord
    	int i = displayedWord.indexOf('*');
    			return i == -1;
    }

    /* the static main method to create a game play on Console */
    public static void main(String[] args) {
        //TODO: Implement the code of this method below
    	//1. create Scanner object
    	Scanner user_inputs = new Scanner(System.in);
    	//2. create the instance of game engine and print current displayedWord
    	SecretWord gameEngine = new SecretWord(); 
    	System.out.println("New game: current secret word: " + gameEngine.getDisplayedWord());
    	//3. while loop to play game
    	while  (gameEngine.isFinished() == false) {
    	    //3.1 read user input of guess character
    	    System.out.println( "Enter your guessed character: ");
    	    String ch = user_inputs.next(); //read user's input of guess char
    	    //3.2 check the guessed character by calling makeGuess() method
    	    boolean guess = gameEngine.makeGuess(ch.charAt(0));
    	    //3.3 display the guess result and new displayedWord if any
    	    if(guess == true)
    	        System.out.println("That Guess Was Right " 
    	                + gameEngine.getDisplayedWord() + "\n");
    	    else
    	        System.out.println("That Guess Was Wrong " 
    	                + gameEngine.getDisplayedWord() + "\n");
    	}

    	//check if game is solved then print congrats message
    	if(gameEngine.isFinished())
    	    System.out.println( "Congratulations! You win the game!" ); 
    }
} // end of SecretWord class