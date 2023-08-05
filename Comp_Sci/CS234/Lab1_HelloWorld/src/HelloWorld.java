
public class HelloWorld extends Object        // Class header
{                                             // Start class body
    private String greeting = "Hello World! My name is Jose.";  
    public void greet()                         // Method definition
    {                                           // Start method body
        System.out.println(greeting);           //  Output statement
    } // greet()                                // End method body
    public static void main(String args[])       // Method header
    {                   
        HelloWorld hwApp;                     // declare
        hwApp = new HelloWorld();             // create
        hwApp.greet();                        // Method call
    }  //  main()
}  // HelloWorld                              // End class body

