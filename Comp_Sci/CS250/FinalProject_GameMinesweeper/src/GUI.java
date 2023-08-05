import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class GUI extends JFrame {
	//GUI dimensions initialized
	public static int GUIlength = 1000;
	public static int GUIwidth = 830;
	
	//number of Columns = 12 and rows = 8, additionally space = 5 between them
	public static int sp;
	public static int col;
	public static int row;
	
	//Neighbors
	public static int neighs = 0;
	
	//smile :)
	public int smileX = GUIlength/2-50;
	public int smileY = 5;
	public int smileCentX = smileX+35;
	public int smileCentY = smileY+35;
	
	//flags
	public int flagX = GUIlength-GUIlength/2+50;
	public int flagY = 5;
	public int flagCentX = flagX+35;
	public int flagCentY = flagY+35;
	public boolean flag = false;
	
	public boolean happy = true;
	
	public boolean won = false;
	public boolean lost = false;
	public String mes = "";
	public int mesX = 0;
	public int mesY = 70;
	
	//mouse coordinates on screen
	public int mx = 0;
	public int my =0;
	
	//Random variable
	Random ran = new Random();
	public static int bombFrequency;
	
	//Timer variables
	//Date
	Date startDate = new Date();
	public int timeX = GUIlength - 185;
	public int timeY = 5;
	public long sec = 0;
	
	//Array with the actual information for game
	//mines
	int[][] mines = new int[col][row];
	//neighbors
	int[][] neighbors = new int[col][row];
	//revealed squares
	boolean[][] revealed = new boolean[col][row];
	//revealed flagged
	boolean[][] flagged = new boolean[col][row];
	
	public boolean resetter = false;
	
	

	/**
	 * @param sp the sp to set
	 */
	public static void setSp(int sp) {
		GUI.sp = sp;
	}

	/**
	 * @param col the col to set
	 */
	public static void setCol(int col) {
		GUI.col = col;
	}

	/**
	 * @param row the row to set
	 */
	public static void setRow(int row) {
		GUI.row = row;
	}

	/**
	 * @param bombFrequency the bombFrequency to set
	 */
	public static void setBombFrequency(int bombFrequency) {
		GUI.bombFrequency = bombFrequency;
	}

	//Default Window
	public GUI() {		
		// Window title on top
		this.setTitle("MINESWEEPER");
		
		this.setSize(GUIlength, GUIwidth);
		//Program stops running when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Able to see the Window
		this.setVisible(true);
		//User able to change the size of window
		this.setResizable(false);
		
		//iterate through rows and columns to place random bombs
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) {
				//decides if a slot is a bomb or not using 1 or 0; 1 is bomb, 0 is no bomb
				if(ran.nextInt(100) < bombFrequency) {
					mines[i][j] = 1;
				} else {
					mines[i][j] = 0;
				}
				//sets all boxes to not revealed at the start
				revealed[i][j] = false;
				flagged[i][j] = false;
			}
		}
		
		//Dealing with the neighbors oh no
		//
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) {
				neighs = 0;
				for(int m = 0; m < col; m++) {
					for(int n = 0; n< row; n++) {
						//When looking at neighbors, it does not count the box you click on as a neighbor
						if(!(m==i && n==j)) {
							if(isNeigh(i,j,m,n)== true)
								neighs++;
						}
						
					}
				}
				neighbors[i][j] = neighs;
			}
		}
		
		//Create a Board
		Board board = new Board();
		//JPanel is able to be used on JFrame to paint our Board on our Window
		this.setContentPane(board);
		
		//Implement Mouse classes to track during game
		//Movement class
		Movement move = new Movement();
		//Any if else statements or others written in the movement class below will now be run
		this.addMouseMotionListener(move);
		//Click class
		Click cl = new Click();
		this.addMouseListener(cl);
	}
	
	//Class allowing us to make the Board
	public class Board extends JPanel {
		public void paintComponent(Graphics g) {
			//select a color to use
			g.setColor(Color.DARK_GRAY);
			//Create rectangle using that color
			g.fillRect(0, 0, GUIlength, GUIwidth-30);
			
			//Nested for loop to change the colors of the boxes depending on action
			for(int i = 0; i < col; i++) {
				for(int j = 0; j< row; j++) {
					//select Color of the square depending if mouse is hovering or not
					g.setColor(Color.gray);
					//********************************
					//Show Bombs location
					if(mines[i][j]==1) {
						g.setColor(Color.magenta);
					}
					//********************************
					//If current box is set to be revealed, change the color
					if(revealed[i][j]== true) {
						//default revealed box color
						g.setColor(Color.white);
						
						//if current box is a bomb
						if(mines[i][j]==1)
							g.setColor(Color.red);
					}
					
					
					//checks to see if mouse coordinates are near the center of a square to highlight it
					if(mx>= sp + i*80 && mx<sp+i*80+80-2*sp && my >= sp+j*80+80+26 && my < sp+j*80+80+80-2*sp) {
						g.setColor(Color.yellow);
					}
					//created a square, making sure to give space around it for the adjacent square
					g.fillRect(sp + i*80, sp + j*80+80, 80-2*sp, 80-2*sp);
					
					//if current box is set to reveal, show the amount of adjacent bombs
					if(revealed[i][j] == true) {
						//sets color
						g.setColor(Color.black);
						//checks if box itself or neighbors does contain a bomb
						if(mines[i][j]==0 && neighbors[i][j] != 0) {
							//color of number displayed depends on number of bomb neighbors 
							if(neighbors[i][j]==1)
								g.setColor(Color.blue);
							else if(neighbors[i][j]==2)
								g.setColor(Color.green);
							else if(neighbors[i][j]==3)
								g.setColor(Color.red);
							else if(neighbors[i][j]==4)
								g.setColor(new Color(0,0,128));
							else if(neighbors[i][j]==5)
								g.setColor(new Color(178,34,34));
							else if(neighbors[i][j]==6)
								g.setColor(new Color(72,209,204));
							else if(neighbors[i][j]==8)
								g.setColor(Color.darkGray);
							
							//sets font of text
							g.setFont(new Font("Tahoma", Font.BOLD, 40));
							//when revealed, the number of neighboring bombs appears on top of box
							g.drawString(Integer.toString(neighbors[i][j]), i*80+27, j*80+80+55);
						}
						//box contains a bomb
						else if(mines[i][j]==1) {
							//draws cute bomb icon :)
							g.fillRect(i*80+10+20, j*80+100, 20, 40);
							g.fillRect(i*80+20, j*80+80+30, 40, 20);
							g.fillRect(i*80+5+20, j*80+105, 30, 30);
						}
					}
					
					//Paint the flags when flag is true
					if(flagged[i][j]==true) {
						//System.out.println("aaaaaaaa");
						g.setColor(Color.black);
						g.fillRect(i*80+32, j*80+80+15, 5, 40);
						g.fillRect(i*80+20,  j*80+80+50, 30, 10);
						g.fillRect(i*80+12,  j*80+80+11, 28, 23);
						g.setColor(Color.red);
						g.fillRect(i*80+16,  j*80+80+15, 20, 15);
					}
				}
			}
			//classic minesweeper smile
			g.setColor(Color.yellow);
			g.fillOval(smileX, smileY, 70, 70);
			g.setColor(Color.black);
			g.fillOval(smileX+15, smileY+20, 10, 10);
			g.fillOval(smileX+45, smileY+20, 10, 10);
			if(happy==true) {
				g.fillRect(smileX+20, smileY+50, 30, 5);
				g.fillRect(smileX+17, smileY+45, 5, 5);
				g.fillRect(smileX+48, smileY+45, 5, 5);
			}
			else {
				g.fillRect(smileX+20, smileY+45, 30, 5);
				g.fillRect(smileX+17, smileY+50, 5, 5);
				g.fillRect(smileX+48, smileY+50, 5, 5);
			}
			//Painting flag
			g.setColor(Color.black);
			g.fillRect(flagX+32, flagY+15, 5, 40);
			g.fillRect(flagX+20, flagY+50, 30, 10);
			g.fillRect(flagX+12, flagY+11, 28, 23);
			g.setColor(Color.red);
			g.fillRect(flagX+16, flagY+15, 20, 15);
			
			//paint flag selected, circle will turn red, otherwise its black
			g.setColor(Color.black);
			if(flag == true) {
				g.setColor(Color.red);
			}
			g.drawOval(flagX, flagY, 70, 70);
			g.drawOval(flagX+1, flagY+1, 68, 68);
			g.drawOval(flagX+2, flagY+2, 66, 66);
			
			
			//PAINTED TIMER
			//black bar background
			g.setColor(Color.black);
			g.fillRect(timeX, timeY, 140, 70);
			//seconds past from the start
			
			//Timer caps at 999 seconds
			if(sec>999)
				sec=999;
			
			if(lost == false) {
				sec = (int)((new Date().getTime()-startDate.getTime()) / 1000);
				g.setColor(Color.white);
				g.setFont(new Font("Tahoma", Font.PLAIN, 80));
				//timer before double digits
				if(sec < 10) {
					g.drawString("00" + sec,timeX , timeY+65);
				} 
				//Timer before triple digits
				else if(sec <100) {
					g.drawString("0" + sec, timeX, timeY+65);
				}
			}
			else if(lost == true) {
				//sec = (int)((new Date().getTime()-startDate.getTime()) / 1000);
				g.setColor(Color.red);
				g.setFont(new Font("Tahoma", Font.PLAIN, 80));
				//timer before double digits
				if(sec < 10) {
					g.drawString("00" + sec,timeX , timeY+65);
				} 
				//Timer before triple digits
				else if(sec <100) {
					g.drawString("0" + sec, timeX, timeY+65);
				}
			}
			
			//Paint Message if you won or lost
			if(won == true) {
				g.setColor(Color.green);
				mes = "YOU WIN";
			}
			else if(lost == true) {
				g.setColor(Color.red);
				mes = "YOU LOSE";
			}
			//display condition of game when game is over
			if(won == true || lost == true) {
				g.setFont( new Font("Tohama", Font.PLAIN, 70));
				g.drawString(mes, mesX, mesY);
			}
				
			
			
		}
	}
	//Class to detect Mouse motions such as dragging or moving
	public class Movement implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			mx = e.getX();
			my = e.getY();
		}
		
	}
	//Class to detect Mouse actions such as clicking, pressing, entered, and exiting
	public class Click implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			//when mouse click, update mouse coordinates
			mx = e.getX();
			my = e.getY();
			//if click flag, it turns it on if off, and turns off if on
			if(inFlag()== true) {
				if(flag==true)
					flag = false;
				else
					flag = true;
			}
			
			//prints out which box the mouse is located in when click
			if(inBoxX() != -1 && inBoxY() != -1) {
				mx = e.getX();
				my = e.getY();
				//System.out.println("Mouse located in [" + inBoxX() + "," + inBoxY() + "]"
					//	+ ", number of mine neighbors: " + neighbors[inBoxX()][inBoxY()]);
				
				//FLAGGING THE BOXES
				if(flag == true && revealed[inBoxX()][inBoxY()]==false) {
					if(flagged[inBoxX()][inBoxY()] == false) {
						flagged[inBoxX()][inBoxY()] = true;
					} else {
						flagged[inBoxX()][inBoxY()] = false;
					}
						
					
				}//reveals the box when clicked by mouse
				else {
					if(flagged[inBoxX()][inBoxY()] == false) {
						revealed[inBoxX()][inBoxY()] = true;
					}
					
				}
			} else {
				System.out.println("Mouse is outside box");
			}
			//If click smile face it restarts, or creates new game
			if(inSmile() == true) {
				resetAll();
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	//Checking if you win
	public void checkWin() {
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) {
				//revealed a bomb oh no that means you lost and get a sad face
				if(revealed[i][j] == true && mines[i][j] == 1) {
					lost = true;
					happy = false;
				}
				
			}
		}
		
		if(totalReveal() == (col*row) - totalMines()) {
			won = true;
		}
	}
	
	//returns the total amount of mines
	public int totalMines() {
		int total = 0;
		//checks all the rows and columns and if box is bomb, increase total
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) {
				if(mines[i][j] == 1) {
					total++;
				}
			}
		}
		return total;
	}
	
	//return the total amount of boxes revealed
	public int totalReveal() {
		int total = 0;
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) {
				if(revealed[i][j] == true) {
					total++;
				}
			}
		}
		return total;
	}
	
	//Reset Game
	public void resetAll() {
		resetter = true;
		flag = false;
		startDate = new Date();
		happy = true;
		won = false;
		lost = false;
		
		//iterate through rows and columns to place random bombs
				for(int i = 0; i < col; i++) {
					for(int j = 0; j< row; j++) {
						//decides if a slot is a bomb or not using 1 or 0; 1 is bomb, 0 is no bomb
						if(ran.nextInt(100) < bombFrequency) {
							mines[i][j] = 1;
						} else {
							mines[i][j] =0;
						}
						//sets all boxes to not revealed at the start
						revealed[i][j] = false;
						flagged[i][j] = false;
					}
				}
				
				//Dealing with the neighbors oh no
				//
				for(int i = 0; i < col; i++) {
					for(int j = 0; j< row; j++) {
						neighs = 0;
						for(int m = 0; m < col; m++) {
							for(int n = 0; n< row; n++) {
								//When looking at neighbors, it does not count the box you click on as a neighbor
								if(!(m==i && n==j)) {
									if(isNeigh(i,j,m,n)== true)
										neighs++;
								}
								
							}
						}
						neighbors[i][j] = neighs;
					}
				}
			resetter = false;
	}
	//mouse is in smile icon
	public boolean inSmile() {
		//pythagorean theorem, distance from mid to know if mouse coordinates are in circle
		int dif = (int) Math.sqrt(Math.abs(mx-smileCentX)*Math.abs(mx-smileCentX) + Math.abs(my-smileCentY)*Math.abs(my-smileCentY));
		if(dif < 35)
			return true;
		return false;
	}
	
	//mouse is in flag icon
	public boolean inFlag() {
		//pythagorean theorem, distance from mid to know if mouse coordinates are in circle
		int dif = (int) Math.sqrt(Math.abs(mx-flagCentX)*Math.abs(mx-flagCentX) + Math.abs(my-flagCentY)*Math.abs(my-flagCentY));
		if(dif < 35)
			return true;
		return false;
	}
	
	//Determine which row the x coordinate is in 
	public int inBoxX() {
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) { 
				if(mx>= sp + i*80 && mx<i*80+80-sp && my >= sp+j*80+106 && my < j*80+186-sp) {
					return i;
				}
			}
		}
		return -1;
	}
	//Determine which column the y coordinate is in 
	public int inBoxY() {
		for(int i = 0; i < col; i++) {
			for(int j = 0; j< row; j++) { 
				if(mx>= sp + i*80 && mx<i*80+80-sp && my >= sp+j*80+106 && my < j*80+186-sp) {
					return j;
				}
			}
		}
		return -1;
	}
	//current box, checks if boxes near are neighbors
	public boolean isNeigh(int mX, int mY, int cX, int cY) {
		//if the x and y difference is less than 2        
		if(mX-cX<2 && mX - cX > -2 && mY-cY<2 && mY - cY > -2 && mines[cX][cY] ==1) {
			return true;
		}
		return false;
		
	}

}
