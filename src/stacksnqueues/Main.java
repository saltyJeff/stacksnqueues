package stacksnqueues;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		//add panels
		Alien alien = new Alien();
		AlienPanel alienPanel = new AlienPanel(alien);
		frame.add(alienPanel);
		frame.add(new ControlPanel());
		//format frame
		frame.setVisible(true);
		frame.setTitle("Alien Thing");
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//dummy data
		
		alien.addMove(new Move("LEFT", 1));
		alien.addMove(new Move("UP", 2));
		alien.addMove(new Move("DOWN", 1.3));
		alien.addMove(new Move("RIGHT", 2));
		
		Timer frameUpdate = new Timer();
		frameUpdate.schedule(new TimerTask () {
			@Override
			public void run() {
				alienPanel.repaint();
			}
		}, 0, 17);
	}
}
