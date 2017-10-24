package stacksnqueues;

import javax.swing.*;

public class Main {
	private static JFrame frame;
	private static AlienPanel alienPanel;
	private static  x;
	public static void main(String[] args) {
		frame = new JFrame();
		Alien a = new Alien(10,10);
		alienPanel = new AlienPanel(a);
		frame.add(alienPanel);
		frame.setVisible(true);
		frame.setTitle("Alien Thing");
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

}
