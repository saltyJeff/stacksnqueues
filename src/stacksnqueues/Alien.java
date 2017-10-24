package stacksnqueues;

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
	private static final int PIXELS_PER_SEC = 10;

	public Alien() {
		moveStack = new Stack<Move>();
		x = 320;
		y = 240;
	}

	public void addMove(Move m) {
		moveQueue.add(m);
	}

	public void undoMove() {
		if (!moveStack.isEmpty())
			moveStack.pop();
	}

	public void update() {
		if (moveQueue.isEmpty()) {
			continue;
		}
		if (currentMove == null) {
			lastMove = System.currentTimeMillis();
			moveStart = System.currentTimeMillis();
			currentMove = moveQueue.remove();
			continue;
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
		if (currentTime - moveStart >= currentMove.secs * 1000) {
			moveStack.push(currentMove);
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
}
