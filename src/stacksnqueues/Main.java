package stacksnqueues;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static Alien alien;
	public static ControlPanel c;
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		//add panels
		alien = new Alien();
		final AlienPanel alienPanel = new AlienPanel(alien);
		frame.add(alienPanel);
		c = new ControlPanel();
		frame.add(c);
		//format frame
		frame.setVisible(true);
		frame.setTitle("Alien Thing");
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Timer frameUpdate = new Timer();
		frameUpdate.schedule(new TimerTask () {
			@Override
			public void run() {
				alienPanel.repaint();
			}
		}, 0, 17);
	}
}
