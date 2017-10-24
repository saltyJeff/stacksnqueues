package stacksnqueues;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	private static JFrame frame;
	private static AlienPanel alienPanel;
	private static Timer frameUpdate;
	public static void main(String[] args) {
		frame = new JFrame();
		Alien a = new Alien();
		alienPanel = new AlienPanel(a);
		frame.add(alienPanel);
		frame.setVisible(true);
		frame.setTitle("Alien Thing");
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameUpdate.schedule(new TimerTask () {
			@Override
			public void run() {
				alienPanel.repaint();
			}
		}, 0, 17);
	}
}
