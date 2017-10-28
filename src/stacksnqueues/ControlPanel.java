package stacksnqueues;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 6431748548824090575L;

	private JComboBox<String> dropDown;
	private JButton submitButton;
	private JButton undoButton;
	private JTextArea timeTextArea;
	private JTextArea moveText;
	public ControlPanel() {
		this.setPreferredSize(new Dimension(160, 240));
		String[] moves = { "RIGHT", "LEFT", "UP", "DOWN" };
		dropDown = new JComboBox<String>(moves);
		timeTextArea = new JTextArea("Time Here");
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.alien.addMove(new Move(getMoveName(), getTime()));
			}
		});
		undoButton = new JButton("Redo");
		undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.alien.undoMove();
			}
		});
		moveText = new JTextArea();
		moveText.setEditable(false);
		
		this.add(dropDown);
		this.add(timeTextArea);
		this.add(submitButton);
		this.add(undoButton);
		this.add(moveText);

	}
	public String getMoveName() {
		return (String) dropDown.getSelectedItem();
	}

	public Double getTime() {
		return Double.parseDouble(timeTextArea.getText());
	}
	public void updateLabel(String newTxt) {
		moveText.setText(newTxt);
	}
}