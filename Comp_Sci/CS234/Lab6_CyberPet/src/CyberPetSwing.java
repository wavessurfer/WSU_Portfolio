

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class CyberPetSwing extends JFrame implements ActionListener {
	private CyberPet pet1; //the instance of CyberPet
	private JLabel lblName; //show the text "Enter pet name: "
	private JTextField txtName; //textbox to enter pet name
	private JButton btnCreatePet; //button to create pet object instance
	private JLabel lblPetStatus; //a label to show pet's name and state
	private JTextField txtState; //a textbox to show pet's state
	//3 buttons to change the state of the pet
	private JButton btnEat, btnSleep, btnPlay;   	
	//3 images to show the state of the pet
	private ImageIcon eatImage, sleepImage, playImage;
	private JLabel imageIcon; //label to show the image <=> pet's state
	
	public CyberPetSwing() { 
	    //1. set the title of the GUI using the setTitle() method
	            setTitle("CyberPet GUI by Jose Ortega");
	    //2. set the default close operation: 
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //3. set the layout: 
	            setLayout(new FlowLayout()); 
	    //4. create the instance lblName with the text "Enter pet name: "
	            lblName = new JLabel("Enter pet name: ");
	    //5. create the instance txtName with 20 columns
	            txtName = new JTextField(20);
	    //6. create the instance of btnCreatePet and set prefered size
	            btnCreatePet = new JButton("Create Pet");
	            btnCreatePet.setPreferredSize(new Dimension(300, 35));
	    //7. similar to lblName, create lblPetStatus with a PreferredSize (330, 35)
	            lblPetStatus = new JLabel("");
	            lblPetStatus.setPreferredSize(new Dimension(330, 35));
	            
	    //8. similar to txtName, create txtState with 25 columns 
	    //  and also setPreferredSize (330, 35)
	            txtState = new JTextField(25);
	            txtState.setPreferredSize(new Dimension(330, 35));
	            
	    //9. turn off text editable of txtState: 
	            txtState.setEditable(false);
	    //10. create the 3 buttons btnSleep, btnEat, btnPlay 
	    // and set their preferred size similar to the following code:
	            btnSleep = new JButton("Sleep!");
	            btnSleep.setPreferredSize(new Dimension(100, 35));
	            btnEat = new JButton("Eat!");
	            btnEat.setPreferredSize(new Dimension(100, 35));
	            btnPlay = new JButton("Play!");
	            btnPlay.setPreferredSize(new Dimension(100, 35));
	    //11. create the imageIcon JLabel with empty text
	            imageIcon = new JLabel("");
	            //imageIcon.setPreferredSize(new Dimension(330, 35));;
	    //12. add all components to the form by calling the add() method like below:
	            add(lblName);
	            add(txtName);
	            add(btnCreatePet);
	            add(lblPetStatus);
	            add(txtState);
	            add(btnSleep);
	            add(btnEat);
	            add(btnPlay);
	            add(imageIcon);
	    //13. set the size of the form: 
	            setSize(350, 450);
	            
	            eatImage = new ImageIcon(getClass().getResource("dog_eat.png"));	
	            sleepImage = new ImageIcon(getClass().getResource("dog_sleep.png"));	
	            playImage = new ImageIcon(getClass().getResource("dog_play.png"));
	      
	            btnCreatePet.addActionListener(this);
	            btnSleep.addActionListener(this);
	            btnEat.addActionListener(this);
	            btnPlay.addActionListener(this);
	}
	
	public void actionPerformed( ActionEvent e) { 
	    //1. if e.getSource() equals to btnCreatePet => btnCreatePet was clicked
	    if (e.getSource() == btnCreatePet) {
	        //1.1 get the name that user enter in txtName
	        String name = txtName.getText();
	        //1.2 TODO: create instance of CyberPet with the above name
	        pet1 = new CyberPet(name);
	        //1.3 set the text content of lblPetStatus
	        lblPetStatus.setText("Hi! My name is " + pet1.getName() + " and currently I am: ");
	        //1.4 set the correct image to imageIcon
	        imageIcon.setIcon(sleepImage);
	    }
	    //2. else if e.getSource() equals to btnSleep => btnSleep was clicked
	    else if (e.getSource() == btnSleep) {
	        //2.1 call the sleep() method pet1
	        pet1.sleep();
	        //2.2 set the correct image (sleepImage) to imageIcon
	        imageIcon.setIcon(sleepImage);
	    }
	    //3. else if e.getSource() equals to btnEat => btnEat was clicked
	    else if (e.getSource() == btnEat) {
	        //check previous code of 2 and do similarly
	        //3.1 TODO: call the eat() method pet1
	    	pet1.eat();
	        //3.2 TODO: set the correct image (eatImage) to imageIcon
	    	imageIcon.setIcon(eatImage);
	    }
	    //4. else if e.getSource() equals to btnPlay => btnPlay was clicked
	    else if (e.getSource() == btnPlay) {
	        //check previous code of 2 & 3 and do similarly
	        //4.1 TODO: call the play() method pet1
	        //4.2 TODO: set the correct image (playImage) to imageIcon
	    	pet1.play();
	    	imageIcon.setIcon(playImage);
	    }
	    //5. update the text of txtState using the result of pet1.getState()
	    txtState.setText(pet1.getState());
	    //6. call the repaint() method to repaint the form
	    repaint();
	} 
	
}