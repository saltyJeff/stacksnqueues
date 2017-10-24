package stacksnqueues;

import javax.swing.*;

public class Main {
	private static JFrame frame;
	private static AlienPanel alienPanel;
	public static void main(String[] args) {
		frame = new JFrame();
		alienPanel = new AlienPanel();
		frame.add(alienPanel);
		frame.setVisible(true);
		frame.setTitle("Alien Thing");
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
