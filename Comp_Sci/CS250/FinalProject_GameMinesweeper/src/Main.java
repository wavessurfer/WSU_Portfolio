public class Main implements Runnable{
	GUI gui = new GUI();
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	@Override
	public void run() {
		//As long as run is being called, the gui will constantly be repainted
		while(true) {
			gui.repaint();
			if(gui.resetter == false) {
				gui.checkWin();
				//System.out.println("WON:" + gui.won + ", LOST: " + gui.lost);
			}
		}	
	}

}
