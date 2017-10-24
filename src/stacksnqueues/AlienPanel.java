package stacksnqueues;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class AlienPanel extends JPanel {
	
	private Alien alien;
	private JPanel panel;
	
	public AlienPanel(Alien a) {
		alien = a;
		panel = new JPanel();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);       
	    g.drawRect(alien.getX(), alien.getY(), 10,10);
	    g.setColor(Color.RED);
	}
	
}
