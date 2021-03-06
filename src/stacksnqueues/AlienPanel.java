package stacksnqueues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class AlienPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Alien alien;
	
	public AlienPanel(Alien a) {
		alien = a;
		this.setPreferredSize(new Dimension(640, 480));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);   
		alien.update();
		String stackNQueue = alien.getStackAndQueue();
		if(stackNQueue != null) {
			Main.c.updateLabel(stackNQueue);
		}
	    g.setColor(Color.RED);
	    g.drawString(alien.toString(), alien.getX() - 10, alien.getY() - 10);
		g.drawImage(alien.getFrame(), alien.getX(), alien.getY(), this);
	}
	
}
