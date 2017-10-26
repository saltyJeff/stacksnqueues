package stacksnqueues;

import java.awt.Image;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Alien {
	private int x;
	private int y;
	private Stack<Move> moveStack = new Stack<Move>();
	private Queue<Move> moveQueue = new LinkedList<Move>();
	private Move currentMove = null;
	private long lastMove; // tracks times between while(true)'s
	private long moveStart; // tracks time between moves
	private static final int PIXELS_PER_SEC = 100;
	private static final long MS_PER_FRAME = 60;
	private Spritesheet sheet;
	private Image[] currentAnim;
	private boolean doingUndoMove = false;
	private boolean dirty = true;
	public Alien() {
		moveStack = new Stack<Move>();
		x = 320;
		y = 240;
		sheet = new Spritesheet("./linkspritesheet.png", 97, 98, 5, 12);
		sheet.prepAnim("DOWN", 0, 4, 10);
		sheet.prepAnim("LEFT", 0, 5, 10);
		sheet.prepAnim("UP", 0, 6, 10);
		sheet.prepAnim("RIGHT", 0, 7, 10);
		sheet.prepAnim("IDLE", 0, 0, 3);
	}

	public void addMove(Move m) {
		moveQueue.add(m);
		dirty = true;
	}

	public void undoMove() {
		if (!moveStack.isEmpty()) {
			currentMove = moveStack.pop();
			doingUndoMove = true;
			lastMove = System.currentTimeMillis();
			moveStart = System.currentTimeMillis();
			currentAnim = sheet.getAnim(currentMove.moveName);
			dirty = true;
		}
	}

	public void update() {
		if (moveQueue.isEmpty() && currentMove == null) {
			currentAnim = sheet.getAnim("IDLE");
			return;
		}
		if (currentMove == null) {
			lastMove = System.currentTimeMillis();
			moveStart = System.currentTimeMillis();
			currentMove = moveQueue.remove();
			currentAnim = sheet.getAnim(currentMove.moveName);
			dirty = true;
			return;
		}
		long currentTime = System.currentTimeMillis();
		double deltaTime = (currentTime - lastMove) / 1000.0;
		switch (currentMove.moveName) {
		case "LEFT":
			x -= (int) (deltaTime * PIXELS_PER_SEC);
			break;
		case "RIGHT":
			x += (int) (deltaTime * PIXELS_PER_SEC);
			break;
		case "UP":
			y -= (int) (deltaTime * PIXELS_PER_SEC);
			break;
		case "DOWN":
			y += (int) (deltaTime * PIXELS_PER_SEC);
			break;
		default:
			currentMove = null;
		}
		if (moveStart + currentMove.secs * 1000 < currentTime) {
			if(!doingUndoMove) {
				moveStack.push(currentMove);
				dirty = true;
			}
			else {
				doingUndoMove = false;
			}
			currentMove = null;
		}
		lastMove = currentTime;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public Image getFrame () {
		return currentAnim[(int)((System.currentTimeMillis() / MS_PER_FRAME) % currentAnim.length)];
	}
	public String toString() {
		if(currentMove == null) {
			return "IDLE";
		}
		return String.format("%s for %.2f more seconds", currentMove.toString(), (moveStart + 1000 * currentMove.secs - System.currentTimeMillis()) / 1000.0);
	}
	public String getStackAndQueue() {
		if(!dirty) {
			return null;
		}
		dirty = false;
		StringBuilder str = new StringBuilder();
		str.append("Move Queue:\n");
		for(Move m : moveQueue) {
			str.append(m.toString());
			str.append('\n');
		}
		str.append("Undo Stack:\n");
		for(Move m : moveStack) {
			str.append(m.toString());
			str.append('\n');
		}
		return str.toString();
	}
}
